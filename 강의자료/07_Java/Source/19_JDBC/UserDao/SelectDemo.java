package daoex;

import java.sql.Connection;

import daoex.model.Users;
import daoex.model.UsersDao;
import daoex.model.UsersDaoImpl;

public class SelectDemo {

	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().open();

        if (conn == null) {
            System.out.println("데이터베이스 접속 실패");
            return;
        }

        // 2) 조회할 데이터
        String target = "winter";

        // 3) 데이터 수정
        UsersDao dao = new UsersDaoImpl(conn);
        Users result = dao.selectOne(target);

        // 4) 결과 판별
        if (result == null) {
            System.out.println("조회결과 없음");
        } else {
            System.out.println(result.toString());
        }

        // 5) DB 접속 해제
        DBManager.getInstance().close();

	}

}
