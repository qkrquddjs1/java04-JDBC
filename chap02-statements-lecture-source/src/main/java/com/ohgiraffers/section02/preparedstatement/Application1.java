package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            /* PreparedStatment 객체 생성 시 수행할 sql 구문을 인자로 전달하면서 생성한다. */
            pstmt = con.prepareStatement("SELECT emp_id, emp_name FROM employee");

            rset = pstmt.executeQuery();

            while (rset.next()){
                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
