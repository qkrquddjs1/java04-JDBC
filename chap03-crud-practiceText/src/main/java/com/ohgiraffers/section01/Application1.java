package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.UserDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Properties prop = new Properties();
        Scanner sc = new Scanner(System.in);
        System.out.println("성을 입력해주세요 :");
        String name = sc.nextLine();

        List<UserDTO> list = null;
        UserDTO userDTO = null;
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/user-query.xml"));
            String query = prop.getProperty("selectUse_name");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rset = pstmt.executeQuery();


            list = new ArrayList<>();
            while (rset.next()){
                userDTO = new UserDTO();
                userDTO.setName(rset.getString("user_name"));
                userDTO.setGender(rset.getString("gender"));
                userDTO.setAge(rset.getInt("age"));
                list.add(userDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        for(UserDTO a : list){
            System.out.println(a);
        }
    }
}
