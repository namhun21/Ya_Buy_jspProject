package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBconnection {

	private static DBconnection DBconn = null;
	private Connection conn;

	private DBconnection() {
	}

	public static DBconnection getInstance() {
		if (DBconn == null) {
			DBconn = new DBconnection();
		}
		return DBconn;
	}

	public Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); // url id pw 오류
		}

		return conn;
	}

	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
