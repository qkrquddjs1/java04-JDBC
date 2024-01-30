package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTD;

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

public class Application4 {
    public static void main(String[] args) {

        /* XML 파일에 별도로 입력 한 sql문을 통해 처리  */



        /* 1. Connection 생성 */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        /* 한 행의 정보를 담을 DTO */
        EmployeeDTD selectedEmp = null;
        /* 여러 DTO 타입의 객체를 담을 List */
        List<EmployeeDTD> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 이름의 성을 입력하세요 : ");
        String empName = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml"));
            String query = prop.getProperty("selectEmpByFamilyName");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empName);


            /*. PreparedStatement의 executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환 받음 */
            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            /*  ResultSet에 담긴 값을 List 타입의 객체에 설정 */
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
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            /* 사용한 자원반납 */
            close(rset);
            close(pstmt);
            close(con);
        }

        for(EmployeeDTD employeeDTD : empList){
            System.out.println(employeeDTD);
        }


    }
}
