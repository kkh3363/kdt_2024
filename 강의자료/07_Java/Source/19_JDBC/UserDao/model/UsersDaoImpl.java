/**
 * 
 */
package daoex.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class UsersDaoImpl implements UsersDao {
	private Connection conn;
	
	public UsersDaoImpl (Connection conn) {
        this.conn = conn;
    }
	@Override
	public int insert(Users params) {
		int result = 0;

        /** 실행할 SQL구문 정의*/
        String sql = "insert into users (userid, username, userpassword, userage,useremail) "+
				"values (?, ? , ? ,? ,?)";

        /** SQL 구문 실행하기 위한 객체*/
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        /** SQL 구문 처리하기*/

        try {
            // pstmt 객체 할당
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 템플릿에 데이터 설정
            pstmt.setString(1, params.getUserid());
            pstmt.setString(2, params.getUsername());
            pstmt.setString(3, params.getUserpassword());
            pstmt.setInt(4, params.getUserage());
            pstmt.setString(5, params.getUseremail());

            // SQL문 실행하기 --> 결과 행의 수를 리턴할 변수에 대입함
            pstmt.executeUpdate();

            // Primary Key 받기
            rs = pstmt.getGeneratedKeys();
            rs.next();
            result = rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            if(rs != null) {
                // 객체 닫기
                try {
                    rs.close();
                } catch (Exception e) {}
            }
            if (pstmt != null) {
                // 객체 닫기
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
        }

        return result;
	}

	@Override
	public int delete(String params) {
		 int result = 0;
	        String sql = "DELETE FROM users WHERE userid=?";
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, params);
            	result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("MySQL SQL Fail : " + e.getMessage());
	        } finally {
	            if (pstmt != null) {
	                // 객체 닫기
	                try {
	                    pstmt.close();
	                } catch (SQLException e) {}
	            }
	        }

	        return result;
	}

	@Override
	public int update(Users params) {
		int result = 0;

        /** 실행할 SQL 구문 정의 */
        String sql = "UPDATE users SET username=?, userpassword=? userage=?, useremail=?  WHERE userid=?";

        /** SQL 구문 실행하기 위한 객체 */
        // --> import java.sql.PreparedStatement;
        PreparedStatement pstmt = null;

        /** SQL 구문 처리하기 */
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, params.getUsername());
            pstmt.setString(2, params.getUserpassword());
            pstmt.setInt(3, params.getUserage());
            pstmt.setString(4, params.getUseremail());
            pstmt.setString(5, params.getUserid());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            if (pstmt != null) {
                // 객체 닫기
                try {
                    pstmt.close();
                } catch (SQLException e) {}
            }
        }
        return result;
	}

	@Override
	public Users selectOne(String params) {
		Users result = null;

        /** 실행할 SQL 구문 정의 */
        String sql = "SELECT userid, username, userpassword, userage, useremail " +
				"FROM users " +
				"WHERE userid=?";

        /** SQL 구문 실행하기 위한 객체 */
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        /** SQL 구문 처리하기 */
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, params);
            rs = pstmt.executeQuery();
            // 조회 결과의 첫 번째 줄로 이동
            boolean first = rs.next();

            if(first) {
                // SELECT절에 명시한 컬럼 이름을 사용하여 데이터 추출
                String  userid = rs.getString("userid");
                String username = rs.getString("username");
                String userpassword = rs.getString("userpassword");
                int userage = rs.getInt("userage");
                String useremail = rs.getString("useremail");

                // 리턴할 객체에 조회한 값을 사용하여 객체를 할당한다.
                result = new Users(userid, username, userpassword, userage, useremail );
            } else {
                System.out.println("조회 결과가 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            // 객체를 생성한 순서의 역순으로 객체를 닫는다.
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { }
            }
            if ( pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) { }
            }
        }
        return result;
	}

	@Override
	public List<Users> select() {
		List<Users> result = null;

        // 'department' 테이블에 데이터를 갱신하기 위한 SQL의 템플릿
        String sql = "SELECT userid, username, userpassword, userage, useremail " +	"FROM users ";

        /** SQL 구문 실행하기 위한 객체 */
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            result = new ArrayList<Users>();

            // 한 줄씩 스캔하는 반복문 구성
            while (rs.next()) {
                String  userid = rs.getString("userid");
                String username = rs.getString("username");
                String userpassword = rs.getString("userpassword");
                int userage = rs.getInt("userage");
                String useremail = rs.getString("useremail");

                // 리턴할 객체에 조회한 값을 사용하여 객체를 할당한다.
                Users user = new Users(userid, username, userpassword, userage, useremail );
                result.add(user);
            }
        } catch (SQLException e) {
            System.out.println("MySQL SQL Fail : " + e.getMessage());
        } finally {
            // 객체를 생성한 순서의 역순으로 객체를 닫는다.
            if ( rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { }
            }
            if ( pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) { }
            }
        }
        return result;
	}

}
