package com.ohgiraffers.model.dto;


import java.sql.Date;

/* DTO(Data Tranfer Object)
*  : 여러 계층간 데이터 전송을 위해 다양한 타입의 데이터를 하나로 묶어 전송하는 쓰임의 클래스 */
public class EmployeeDTD {

    private String empId;
    private String empName;
    private String empNO;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private String salary;
    private String bonus;
    private String managerId;
    private java.sql.Date hireDate;
    private java.sql.Date entDate;
    private String entYun;

    public EmployeeDTD() {
    }

    public EmployeeDTD(String empId, String empName, String empNO, String email, String phone, String deptCode, String jobCode, String salLevel, String salary, String bonus, String managerId, Date hireDate, Date entDate, String entYun) {
        this.empId = empId;
        this.empName = empName;
        this.empNO = empNO;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.entDate = entDate;
        this.entYun = entYun;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNO() {
        return empNO;
    }

    public void setEmpNO(String empNO) {
        this.empNO = empNO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEntDate() {
        return entDate;
    }

    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }

    public String getEntYun() {
        return entYun;
    }

    public void setEntYun(String entYun) {
        this.entYun = entYun;
    }

    @Override
    public String toString() {
        return "EmployeeDTD{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNO='" + empNO + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", entDate=" + entDate +
                ", entYun='" + entYun + '\'' +
                '}';
    }
}
