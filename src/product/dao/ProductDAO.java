package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product.dto.ProductCommentDTO;
import product.dto.ProductDTO;
import util.DBconnection;;

public class ProductDAO {

	private static ProductDAO productDAO = null;

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// 모든 상품가져오기
	public ArrayList<ProductDTO> selectProductAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBconnection.getInstance().getConnection();
		String sql = "select * from product";
		ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCategorycode(rs.getString("categorycode"));
				dto.setPid(rs.getString("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_hit(rs.getInt("product_hit"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setProduct_regist(rs.getString("product_regist"));
				dto.setProduct_reply_cnt(rs.getInt("product_reply_cnt"));
				dto.setStock(rs.getInt("stock"));
				plist.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return plist;
	}

	// 해당상품 가져오기
	public ProductDTO selectProduct(String productID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBconnection.getInstance().getConnection();
		String sql = "select * from product where pid = ?";
		ProductDTO dto = new ProductDTO();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setCategorycode(rs.getString("categorycode"));
				dto.setPid(rs.getString("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_hit(rs.getInt("product_hit"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setProduct_regist(rs.getString("product_regist"));
				dto.setProduct_reply_cnt(rs.getInt("product_reply_cnt"));
				dto.setStock(rs.getInt("stock"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return dto;
	}

	// sort한 상품 가져오기
	public ArrayList<ProductDTO> selectSortedProduct(String sortby) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();

		String param = "";
		if (sortby.equals("orders")) {
			param = "PRODUCT_HIT";
		} else if (sortby.equals("price")) {
			param = "price";
		}

		conn = DBconnection.getInstance().getConnection();
		String sql = "select * from product order by " + param;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCategorycode(rs.getString("categorycode"));
				dto.setPid(rs.getString("pid"));
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_hit(rs.getInt("product_hit"));
				dto.setProduct_img(rs.getString("product_img"));
				dto.setProduct_regist(rs.getString("product_regist"));
				dto.setProduct_reply_cnt(rs.getInt("product_reply_cnt"));
				dto.setStock(rs.getInt("stock"));
				plist.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return plist;
	}

	// 상품 댓글가져오기
	public ArrayList<ProductCommentDTO> selectCommentAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBconnection.getInstance().getConnection();
		String sql = "select * from product_reply order by repregist desc";
		ArrayList<ProductCommentDTO> clist = new ArrayList<ProductCommentDTO>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductCommentDTO dto = new ProductCommentDTO();
				dto.setPid(rs.getString("pid"));
				dto.setRepid(rs.getString("repid"));
				dto.setRepregist(rs.getString("repregist"));
				dto.setUserid(rs.getString("userid"));
				dto.setComments(rs.getString("comments"));
				dto.setIsdelete(rs.getInt("isdelete"));
				clist.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return clist;
	}

	// comment 삽입
	public int insertComment(String commentValue, String pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		// TODO userid : receive data from session or cookie
		String userid = "juseok";
		ArrayList<ProductCommentDTO> clist = selectCommentAll();
		String replyID = String.valueOf(clist.size() + 1);

		conn = DBconnection.getInstance().getConnection();
		String sql = "insert into product_reply values(?,?,?,sysdate,?,0)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyID);
			pstmt.setString(2, pid);
			pstmt.setString(3, userid);
			pstmt.setString(4, commentValue);
			result = pstmt.executeUpdate();
			if (result > 0) {
				result = Integer.parseInt(replyID);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return result;
	}

	// 특정 comment 불러오기
	public ProductCommentDTO selectInsertedComment(String replyID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductCommentDTO dto = new ProductCommentDTO();
		ArrayList<ProductCommentDTO> clist = selectCommentAll();

		conn = DBconnection.getInstance().getConnection();
		String sql = "select * from product_reply where repid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setPid(rs.getString("pid"));
				dto.setRepid(rs.getString("repid"));
				dto.setRepregist(rs.getString("repregist"));
				dto.setUserid(rs.getString("userid"));
				dto.setComments(rs.getString("comments"));
				dto.setIsdelete(rs.getInt("isdelete"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBconnection.getInstance().close(pstmt, rs);
		}

		return dto;
	}
}
