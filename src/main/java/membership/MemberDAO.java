package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.JDBConnect;


public class MemberDAO extends JDBConnect {
	
	
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	
	

	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=? and pass=?";

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs=psmt.executeQuery();
			// 결과 처리
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int insertMember(MemberDTO dto) {
		int rs = 0;
		String query = "insert into Member(id,pass,name) values(?,?,?)";
		try {
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			
			rs=psmt.executeUpdate();
			System.out.println("rs>>>>"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	
}
