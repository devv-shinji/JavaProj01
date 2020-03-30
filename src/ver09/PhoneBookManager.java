package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PhoneBookManager {

	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	
	public PhoneBookManager() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:orcl", "kosmo", "1234");
			System.out.println("오라클 DB 연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
		}
	}

	public void dataInput() {
		try {
			String query = "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval,?,?,?)";
			psmt = con.prepareStatement(query);

			Scanner scan = new Scanner(System.in);
			String iName, iPhone, iBirth;

			System.out.println("이름:");
			iName = scan.nextLine();
			System.out.println("전화번호:");
			iPhone = scan.nextLine();
			System.out.println("생년월일:");
			iBirth = scan.nextLine();

			psmt.setString(1, iName);
			psmt.setString(2, iPhone);
			psmt.setString(3, iBirth);

			psmt.executeUpdate();

			System.out.println("데이터 입력이 완료되었습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
		}
	}

	public void dataSearch() {
		try {

			Scanner scan = new Scanner(System.in);
			System.out.println("검색할 이름을 입력하세요:");
			String searchName = scan.nextLine();

			stmt = con.createStatement();

			String query = "SELECT name, phonenum, birth FROM phonebook_tb where name like '%" + searchName + "%'";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString(1); 
				String phonenum = rs.getString(2);
				String birth = rs.getString(3);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phonenum);
				System.out.println("생일 : " + birth);
			}

		} catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
	}

	public void dataDelete() {
		try {
			String query = "delete from phonebook_tb where name = ?";
			psmt = con.prepareStatement(query);

			Scanner scan = new Scanner(System.in);

			System.out.println("이름:");
			String iName = scan.nextLine();

			psmt.setString(1, iName);

			psmt.executeUpdate();

			System.out.println("데이터 삭제 완료되었습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
		}
	}

	public void dataAllShow() {
		try {
			stmt = con.createStatement();

			String query = "SELECT name, phonenum, birth FROM phonebook_tb";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString(1); // 인덱스 1
				String phonenum = rs.getString(2);
				String birth = rs.getString(3);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phonenum);
				System.out.println("생일 : " + birth);
			}

		} catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
	}

}
