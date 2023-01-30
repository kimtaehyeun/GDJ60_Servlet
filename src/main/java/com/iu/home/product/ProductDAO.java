package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {

	public Long getProductNum() throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		Long num = rs.getLong(1);
		DBConnection.disConnection(rs, st, connection);
		return num;
	}
	
	
	public List<ProductDTO> getProductList()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_NUM,PRODUCT_NAME, PRODUCT_JUMSU"
				+ " FROM PRODUCT ORDER BY PRODUCT_JUMSU DESC";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setNum(rs.getLong("PRODUCT_NUM"));
			productDTO.setName(rs.getString("PRODUCT_NAME"));
			productDTO.setJumsu(rs.getDouble("PRODUCT_JUMSU"));
			ar.add(productDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		
		return ar;
		
	}
	
	
	
	
	
	public int SetAddProduct(ProductDTO productDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT "
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getNum());
		st.setString(2, productDTO.getName());
		st.setString(3, productDTO.getDetail());
		st.setDouble(4, productDTO.getJumsu());
		int result= st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	public List<ProductOptionDTO> getOptionList() throws Exception{
		Connection con = DBConnection.getConnection();
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		String sql = "SELECT OPTION_NUM ,PRODUCT_NUM ,OPTION_NAME ,OPTION_PRICE ,OPTION_JEGO  FROM PRODUCTOPTION";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductOptionDTO dto = new ProductOptionDTO();
			dto.setOptionnum(rs.getLong("OPTION_NUM"));
			dto.setProductnum(rs.getLong("PRODUCT_NUM"));
			dto.setOptionname(rs.getString("OPTION_NAME"));
			dto.setOptionprice(rs.getInt("OPTION_PRICE"));
			dto.setOptionjego(rs.getInt("OPTION_JEGO"));
			ar.add(dto);
		}
		return ar;
	}
	
	
	
	public int setAddoption(ProductOptionDTO optionDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTOPTION VALUES "
				+ "(OPTION_SEQ.NEXTINT,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, optionDTO.getProductnum());
		st.setString(2, optionDTO.getOptionname());
		st.setInt(3, optionDTO.getOptionprice());
		st.setInt(4, optionDTO.getOptionjego());
		int result  = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	
	
	
	//test
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		try {
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
