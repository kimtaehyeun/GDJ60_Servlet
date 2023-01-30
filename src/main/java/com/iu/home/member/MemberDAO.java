package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.iu.home.util.DBConnection;

public class MemberDAO {

	public int setAddMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getAddress());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		
		return result;
	}
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO.setName("a");
		memberDTO.setAddress("a");
		memberDTO.setPhone("a");
		memberDTO.setEmail("a");
		try {
			
			int result = memberDAO.setAddMember(memberDTO);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
