package com.ohgiraffers.section01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application3 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/user-query.xml"));
            String query = prop.getProperty("insertName");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "아이유");
            pstmt.setString(2, "여");
            pstmt.setInt(3, 30);

            result = pstmt.executeUpdate();




        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        System.out.println("result : " + result);

    }
}
