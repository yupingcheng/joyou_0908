package joyou.Products.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import joyou.Products.model.ProductsBean;

public class ProductsDao2 implements Serializable {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	
	
	public int saveBook(ProductsBean bean) {
		int n=0;
		String sql = "INSERT INTO Products (productName, productStock, productPrice, gametypeId,productAge,productLang,productImg) VALUES (?, ?, ?, ?, ?,?,?)";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, bean.getProductName());
			pst.setInt(2, bean.getProductStock());
			pst.setInt(3, bean.getProductPrice());
			pst.setInt(4, bean.getGametypeId());
			pst.setString(5, bean.getProductAge());
			pst.setString(6, bean.getProductAge());
			pst.setBlob(7, bean.getProductImg());
			n = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n; 

	}
}
