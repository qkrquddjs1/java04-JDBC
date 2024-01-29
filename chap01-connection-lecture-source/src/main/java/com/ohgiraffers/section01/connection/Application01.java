package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application01 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            /*사용할 드라이버 등록

입력한 클래스명이 올바르지 않을 경우 문제가 생기므로 ClassNotFoundException핸들링*/
            Class.forName("com.mysql.cj.jdbc.Driver\n");
            /*DriverManager를 이용해 Connection 생성

            접속 url, 계정 정보를 전달하여 Connection 객체를 만들어서 반환 받는다.
            접속 정보가 틀리면 연결할 수 없으므로 SQLException이 발생할 수 있다. */
        con = DriverManager.getConnection("jdbc:mysql://localhost/employee","ohgiraffers","ohgiraffers");
        /* con객체를 통해 데이터베이스와의 연결이 일어나고 있다. con이 자원역할임 */

            System.out.println("con: "+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
