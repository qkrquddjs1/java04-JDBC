package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.UserDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 이름 번호 입력 : ");
        int userCode = sc.nextInt();
        sc.nextLine();
        System.out.println("변경할 이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("변경할 성별 입력 : ");
        String gender = sc.nextLine();
        System.out.println("변경할 나이 입력 : ");
        int age = sc.nextInt();
        sc.nextLine();

        UserDTO changeUser = new UserDTO();
        changeUser.setNo(userCode);
        changeUser.setName(name);
        changeUser.setGender(gender);
        changeUser.setAge(age);

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/user-query.xml"));
            String query = prop.getProperty("updateName");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(4, changeUser.getNo());
            pstmt.setString(1, changeUser.getName());
            pstmt.setString(2,changeUser.getGender());
            pstmt.setInt(3, changeUser.getAge());

            result = pstmt.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }

        if(result > 0 ){
            System.out.println("이름 변경 성공! " );
        } else {
            System.out.println("이름 변경 실패!! ");
        }


    }
}
