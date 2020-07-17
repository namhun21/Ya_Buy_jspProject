package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;
import product.dto.ProductDTO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/Category")
public class CategoryController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();

		ProductDAO dao = new ProductDAO();
		plist = dao.selectProductAll();

		if (plist.isEmpty()) {
			response.sendRedirect("main");
		} else {
			request.setAttribute("plist", plist);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/category.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
