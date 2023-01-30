package com.iu.home.product;

public class ProductOptionDTO {

	private Long optionnum;
	private Long productnum;
	private String optionname;
	private Integer optionprice;
	private Integer optionjego;
	public Long getOptionnum() {
		return optionnum;
	}
	public void setOptionnum(Long optionnum) {
		this.optionnum = optionnum;
	}
	public Long getProductnum() {
		return productnum;
	}
	public void setProductnum(Long productnum) {
		this.productnum = productnum;
	}
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}
	public Integer getOptionprice() {
		return optionprice;
	}
	public void setOptionprice(Integer optionprice) {
		this.optionprice = optionprice;
	}
	public Integer getOptionjego() {
		return optionjego;
	}
	public void setOptionjego(Integer optionjego) {
		this.optionjego = optionjego;
	}
	
}
