package com.aaa.inter.entity;

import javax.persistence.*;

@Table(name = "`tab_department`")
public class DepartmentEntity {
    @Id
    @Column(name = "`department_id`")
    private Integer departmentId;

    @Column(name = "`department_name`")
    private String departmentName;

    @Column(name = "`department_state`")
    private String departmentState;

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
     * @return department_name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * @return department_state
     */
    public String getDepartmentState() {
        return departmentState;
    }

    /**
     * @param departmentState
     */
    public void setDepartmentState(String departmentState) {
        this.departmentState = departmentState == null ? null : departmentState.trim();
    }
}