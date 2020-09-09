package joyou.Products.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class ProductsBean {
	public Integer productId;
	public String productName;
	public Integer productStock;
	public Integer productPrice;
	public Integer gametypeId;
	public String productAge;
	public String productLang;
	public String imgName;
	public Blob productImg; 
	
	public ProductsBean() {
	}
	public ProductsBean(String productName,Integer productStock,Integer productPrice,Integer gametypeId
	,String productAge,String productLang,String imgName,Blob productImg) {
		this.productName=productName;
		this.productStock=productStock;
		this.productPrice=productPrice;
		this.gametypeId=gametypeId;
		this.productAge=productAge;
		this.productLang=productLang;
		this.imgName=imgName;
		this.productImg=productImg; 
	}
	
	public ProductsBean(String productName,Integer productStock,Integer productPrice,Integer gametypeId
	,String productAge,String productLang) {
		this.productName=productName;
		this.productStock=productStock;
		this.productPrice=productPrice;
		this.gametypeId=gametypeId;
		this.productAge=productAge;
		this.productLang=productLang;
	}
	
	@Id
	@Column(name="productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name="productname")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name="productstock")
	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	@Column(name="productprice")
	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name="gametypeid")
	public Integer getGametypeId() {
		return gametypeId;
	}

	public void setGametypeId(Integer gametypeId) {
		this.gametypeId = gametypeId;
	}

	@Column(name="productage")
	public String getProductAge() {
		return productAge;
	}

	public void setProductAge(String productAge) {
		this.productAge = productAge;
	}

	@Column(name="productlang")
	public String getProductLang() {
		return productLang;
	}

	public void setProductLang(String productLang) {
		this.productLang = productLang;
	}

	@Column(name="imgname")
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
		
	}
	@Column(name="productimg")
	public Blob getProductImg() {
		return productImg;
	}

	public void setProductImg(Blob productImg) {
		this.productImg = productImg;
	}
	
	
}
