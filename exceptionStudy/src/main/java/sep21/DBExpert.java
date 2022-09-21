package sep21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBExpert { //삽입, 삭제, 변경, 조회 메서드
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	public boolean entryBBS(int id, String w, String title, String cont ) {
		String insert = "insert into test_tbl values(?,?,?,sysdate,?)";
		boolean flag = false; //작업 성공여부를 위한 변수
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, id); //글번호(정수) 설정
			pstmt.setString(2, w); //작성자(문자열) 설정
			pstmt.setString(3, title); //제목(문자열) 설정
			pstmt.setString(4, cont); //글내용(문자열) 설정
			pstmt.executeUpdate();//insert 쿼리 실행
			con.commit();
			flag = true; //삽입 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ 
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return flag;
	}//게시글 삽입 메서드
	
}
