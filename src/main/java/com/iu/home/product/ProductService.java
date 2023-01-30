package com.iu.home.product;

public class ProductService {

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setName("product1");
		productDTO.setDetail("detail1");
		
		ProductOptionDTO optionDTO = new ProductOptionDTO();
		optionDTO.setOptionname("optionName1");
		optionDTO.setOptionprice(100);
		optionDTO.setOptionjego(10);
		optionDTO.setProductnum(null);
		
		ProductOptionDTO optionDTO2 = new ProductOptionDTO();
		optionDTO2.setOptionname("optionName2");
		optionDTO2.setOptionprice(100);
		optionDTO2.setOptionjego(10);
		optionDTO2.setProductnum(null);
		
		try {
			Long num = productDAO.getProductNum()	;
			productDTO.setNum(num);
			int result = productDAO.SetAddProduct(productDTO);
			
			optionDTO.setProductnum(num);
			if(result>0) {
				productDAO.setAddoption(optionDTO);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
