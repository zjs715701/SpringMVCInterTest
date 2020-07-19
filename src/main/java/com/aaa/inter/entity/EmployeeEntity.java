package com.aaa.inter.entity;

import javax.persistence.*;

@Table(name = "`tab_employee`")
public class EmployeeEntity {
    @Id
    @Column(name = "`employee_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "`department_id`")
    private Integer departmentId;

    @Column(name = "`employee_name`")
    private String employeeName;

    @Column(name = "`employee_sex`")
    private String employeeSex;

    @Column(name = "`employee_age`")
    private Integer employeeAge;

    @Column(name = "`employee_state`")
    private String employeeState;

    @Column(name = "`account_id`")
    private Integer accountId;

    private DepartmentEntity departmentEntity;

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSex='" + employeeSex + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeState='" + employeeState + '\'' +
                ", accountId=" + accountId +
                ", departmentEntity=" + departmentEntity +
                '}';
    }

    /**
     * @return employee_id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return employee_name
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    /**
     * @return employee_sex
     */
    public String getEmployeeSex() {
        return employeeSex;
    }

    /**
     * @param employeeSex
     */
    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex == null ? null : employeeSex.trim();
    }

    /**
     * @return employee_age
     */
    public Integer getEmployeeAge() {
        return employeeAge;
    }

    /**
     * @param employeeAge
     */
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * @return employee_state
     */
    public String getEmployeeState() {
        return employeeState;
    }

    /**
     * @param employeeState
     */
    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState == null ? null : employeeState.trim();
    }

    /**
     * @return account_id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}