package com.ohgiraffers.seatement;

import com.ohgiraffers.model.dto.EmployeeDTD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTempLate.close;
import static com.ohgiraffers.common.JDBCTempLate.getConnection;

public class Application4 {
    public static void main(String[] args) {



        /* 1. Connection 생성 */
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        /* 한 행의 정보를 담을 DTO */
        EmployeeDTD selectedEmp = null;
        /* 여러 DTO 타입의 객체를 담을 List */
        List<EmployeeDTD> empList = null;

        try {
            /* 2. Connection 의 creatsStatment() 를 이용한 Statement 인스턴스 생성 */
            stmt = con.createStatement();

            String query = "SELECT * FROM employee";

            /* 3. STatement의 executeQuery(sql)로 쿼리문 실행하고 결과를 ResultSet으로 반환 받음 */
            rset = stmt.executeQuery(query);

            empList = new ArrayList<>();

            /* 4. ResultSet에 담긴 값을 List 타입의 객체에 설정 */
            while(rset.next()){
               selectedEmp = new EmployeeDTD();

               selectedEmp.setEmpId(rset.getString("emp_id"));
               selectedEmp.setEmpName(rset.getString("emp_name"));
               selectedEmp.setEmpNO(rset.getString("emp_no"));
               selectedEmp.setEmail(rset.getString("Email"));
               selectedEmp.setPhone(rset.getString("phone"));
               selectedEmp.setDeptCode(rset.getString("dept_code"));
               selectedEmp.setJobCode(rset.getString("job_code"));
               selectedEmp.setSalLevel(rset.getString("sal_level"));
               selectedEmp.setSalary(rset.getString("salary"));
               selectedEmp.setBonus(rset.getString("bonus"));
               selectedEmp.setManagerId(rset.getString("manager_id"));
               selectedEmp.setHireDate(rset.getDate("hire_date"));
               selectedEmp.setEntDate(rset.getDate("ent_date"));
               selectedEmp.setEntYun(rset.getString("ent_yn"));

               empList.add(selectedEmp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*5 . 사용한 자원반납 */
            close(rset);
            close(stmt);
            close(con);
        }

        for(EmployeeDTD employeeDTD : empList){
            System.out.println(employeeDTD);
        }


    }
}
