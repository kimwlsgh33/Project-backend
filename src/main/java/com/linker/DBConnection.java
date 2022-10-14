package com.linker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            String user = "UserId";
            String pass = "UserPass";
            String url = "jdbc:mysql://database-1.c2fmjk6l23se.ap-northeast-2.rds.amazonaws.com:3306/linker?serverTimezone=Asia/Seoul&useSSL=false";

            Class.forName("software.aws.rds.jdbc.mysql.Driver");

            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("Database에 연결되었습니다.");

        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 서버 로딩 실패 : " + cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속 실패 : " + sqle.toString());
        } catch (Exception e) {
            System.out.println("알수없는 에러가 발생했습니다.");
            e.printStackTrace();
        }

        return conn;
    }
}