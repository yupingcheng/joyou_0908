package joyou.Products.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import joyou.Products.model.ProductsBean;

@Repository("myProductsDao")
public class ProductsDao {
	Session session;

	public ProductsDao(Session session) {
		this.session = session;
	}

	public ProductsDao() {

	}

	public ProductsBean insert(ProductsBean pBean) {                         // 新增商品
		if (pBean != null) {
			session.save(pBean);
			return pBean;
		}
		return null;
	}

	public ProductsBean selectbyId(Integer productId) {                      //依ID查詢商品
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		return pBean;
	}
	
	public List<ProductsBean> selectAll(){                                  //查詢全部商品
		Query<ProductsBean> query = session.createQuery("from ProductsBean",ProductsBean.class);
		return query.list();
	}
	
	
	public ProductsBean updatenoImg(Integer productId, String productName,           //依ID修改商品不含照片。
			Integer productStock, Integer productPrice,Integer gametypeId, 
			String productAge, String productLang) {
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		if (pBean != null) {
			pBean.setProductName(productName);
			pBean.setProductStock(productStock);
			pBean.setProductPrice(productPrice);
			pBean.setGametypeId(gametypeId);
			pBean.setProductAge(productAge);
			pBean.setProductLang(productLang);
			
		}
		return pBean;
	}
	
	
	public ProductsBean update(Integer productId, String productName,           //依ID修改商品含照片。
			Integer productStock, Integer productPrice,Integer gametypeId, 
			String productAge, String productLang,Blob productImg) {
		
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		if (pBean != null) {
			pBean.setProductName(productName);
			pBean.setProductStock(productStock);
			pBean.setProductPrice(productPrice);
			pBean.setGametypeId(gametypeId);
			pBean.setProductAge(productAge);
			pBean.setProductLang(productLang);
			pBean.setProductImg(productImg);
		}
		return pBean;
	}

	public boolean delete(int productId) {                                // 依ID刪除商品
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		if (pBean != null) {
			session.delete(pBean);
			return true;
		}
		return false;
	}
	
	public List<ProductsBean> selectByPage(int page){
		Query<ProductsBean> query = session.createQuery("from ProductsBean",ProductsBean.class);
		List<ProductsBean> beanList = query.list();
		List<ProductsBean> result = new ArrayList<ProductsBean>();
		for(int i=(page-1)*10;(i<=(page-1)*10+9)&&(i<beanList.size());i++) {
			result.add(beanList.get(i));
		}
		return result;
		
	}
	
}
