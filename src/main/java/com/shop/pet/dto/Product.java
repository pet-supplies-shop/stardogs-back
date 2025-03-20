package com.shop.pet.dto;

public class Product {
	private String prodName, prodimg, prodClass;
    private int price, reviewCnt;
    private boolean freeDel;
    
	public Product(String prodName, String prodimg, String prodClass, int price, int reviewCnt, boolean freeDel) {
		super();
		this.prodName = prodName;
		this.prodimg = prodimg;
		this.prodClass = prodClass;
		this.price = price;
		this.reviewCnt = reviewCnt;
		this.freeDel = freeDel;
	}

	@Override
	public String toString() {
		return "Product [prodName=" + prodName + ", prodimg=" + prodimg + ", prodClass=" + prodClass + ", price="
				+ price + ", reviewCnt=" + reviewCnt + ", freeDel=" + freeDel + "]";
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdimg() {
		return prodimg;
	}

	public void setProdimg(String prodimg) {
		this.prodimg = prodimg;
	}

	public String getProdClass() {
		return prodClass;
	}

	public void setProdClass(String prodClass) {
		this.prodClass = prodClass;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public boolean isFreeDel() {
		return freeDel;
	}

	public void setFreeDel(boolean freeDel) {
		this.freeDel = freeDel;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
