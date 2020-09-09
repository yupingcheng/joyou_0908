package joyou.Products.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import joyou.Products.model.ProductsBean;

@Repository("myProductsDao")
public class ProductsDao {
	Session session;
	DataSource ds = null;
	public static final int RECORDS_PER_PAGE = 10;
	private int totalPages;
	private Query<ProductsBean> query;

	public ProductsDao(Session session) {
		this.session = session;
	}

	public ProductsDao() {

	}

	public ProductsBean insert(ProductsBean pBean) { // 新增商品
		if (pBean != null) {
			session.save(pBean);
			return pBean;
		}
		return null;
	}

	public ProductsBean selectbyId(Integer productId) { // 依ID查詢商品
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		return pBean;
	}

	public List<ProductsBean> selectAll() { // 查詢全部商品
		Query<ProductsBean> query = session.createQuery("from ProductsBean", ProductsBean.class);
		return query.list();
	}

	public ProductsBean updatenoImg(Integer productId, String productName, // 依ID修改商品不含照片。
			Integer productStock, Integer productPrice, Integer gametypeId, String productAge, String productLang) {
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

	public ProductsBean update(Integer productId, String productName, // 依ID修改商品含照片。
			Integer productStock, Integer productPrice, Integer gametypeId, String productAge, String productLang,
			String imgName, Blob productImg) {

		ProductsBean pBean = session.get(ProductsBean.class, productId);
		if (pBean != null) {
			pBean.setProductName(productName);
			pBean.setProductStock(productStock);
			pBean.setProductPrice(productPrice);
			pBean.setGametypeId(gametypeId);
			pBean.setProductAge(productAge);
			pBean.setProductLang(productLang);
			pBean.setImgName(imgName);
			pBean.setProductImg(productImg);
		}
		return pBean;
	}

	public boolean delete(int productId) { // 依ID刪除商品
		ProductsBean pBean = session.get(ProductsBean.class, productId);
		if (pBean != null) {
			session.delete(pBean);
			return true;
		}
		return false;
	}

	public List<ProductsBean> selectByPage(int page) {
		query = session.createQuery("from ProductsBean", ProductsBean.class);
		List<ProductsBean> beanList = query.list();
		List<ProductsBean> result = new ArrayList<ProductsBean>();
		for (int i = (page - 1) * 10; (i <= (page - 1) * 10 + 9) && (i < beanList.size()); i++) {
			result.add(beanList.get(i));
		}
		return result;

	}

	public int getTotalPages() {
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) RECORDS_PER_PAGE));
		return totalPages;
	}

	public long getRecordCounts() {
		long count = 0;
		query = session.createQuery("from ProductsBean", ProductsBean.class);
		List<ProductsBean> beanList = query.list();
		for (ProductsBean pBean : beanList) {
			count++;
		}
		System.out.println(count);
		return count;
	}
}
