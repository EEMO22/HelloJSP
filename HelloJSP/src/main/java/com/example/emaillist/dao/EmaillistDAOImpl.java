package com.example.emaillist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.emaillist.vo.EmailVO;

public class EmaillistDAOImpl implements EmaillistDAO {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
		//	드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//	Connection 가져오기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",	//	DBURL
					"C##BITUSER",	//	DB USER
					"bituser");		//	DB Pass
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	@Override
	public List<EmailVO> getList() {
		List<EmailVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = " SELECT no, last_name, first_name, email, createdAt "
					+ " FROM emaillist ORDER BY no DESC";
			
			//	쿼리 수행
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String email = rs.getString(4);
				Date createdAt = rs.getDate(5);	//	java.util.Date
				
				//	VO 객체 생성 (생성자 대신)
				EmailVO vo = new EmailVO();
				vo.setNo(no);
				vo.setLastName(lastName);
				vo.setFirstName(firstName);
				vo.setEmail(email);
				vo.setCreatedAt(createdAt);
				
				//	리스트에 추가
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return list;
	}

	@Override
	public int insert(EmailVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
