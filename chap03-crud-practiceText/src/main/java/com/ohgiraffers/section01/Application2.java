package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.UserDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        UserDTO userDTO = null;
        List<UserDTO> userList = null;

        try {
            stmt = con.createStatement();

            String query = "SELECT * FROM user_check";

            rset = stmt.executeQuery(query);

            userList = new ArrayList<>();

            while(rset.next()){
                userDTO = new UserDTO();

                userDTO.setNo(rset.getInt("user_no"));
                userDTO.setName(rset.getString("user_name"));
                userDTO.setGender(rset.getString("gender"));
                userDTO.setAge(rset.getInt("age"));

                userList.add(userDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

        for(UserDTO a : userList){
            System.out.println(a);
        }
    }
}
