package com.my.color.manage.dao.po;

import java.util.Date;

public class SalaryManage {
    /**考勤管理id*/
    private String salaryManageId;

    /**学生id*/
    private String studentUserId;

    /**学生姓名*/
    private String studentUserName;

    /**班级*/
    private String salaryClass;

    /**考勤时间*/
    private Date salaryTime;

    /**节次*/
    private Double salaryClassNumber;

    /**课程名称*/
    private String salaryCourseName;

    /**教室地址*/
    private String salaryClassAddress;

    /**考勤状态*/
    private String salaryStatus;

    /**老师id*/
    private String teacherUserId;

    /**老师姓名*/
    private String teacherUserName;

    /**是否有效（0无效，1有效）*/
    private String salaryIsVaild;

    /**创建时间*/
    private Date salaryCreateTime;

    /**最后修改时间*/
    private Date salaryLastUptime;

    /**修改人id*/
    private String salaryLastUpuid;

    /**修改人*/
    private String salaryLastUpuname;

    
    public String getSalaryManageId() {
        return salaryManageId;
    }

    
    public void setSalaryManageId(String salaryManageId) {
        this.salaryManageId = salaryManageId;
    }

    
    public String getStudentUserId() {
        return studentUserId;
    }

    
    public void setStudentUserId(String studentUserId) {
        this.studentUserId = studentUserId;
    }

    
    public String getStudentUserName() {
        return studentUserName;
    }

    
    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    
    public String getSalaryClass() {
        return salaryClass;
    }

    
    public void setSalaryClass(String salaryClass) {
        this.salaryClass = salaryClass;
    }

    
    public Date getSalaryTime() {
        return salaryTime;
    }

    
    public void setSalaryTime(Date salaryTime) {
        this.salaryTime = salaryTime;
    }

    
    public Double getSalaryClassNumber() {
        return salaryClassNumber;
    }

    
    public void setSalaryClassNumber(Double salaryClassNumber) {
        this.salaryClassNumber = salaryClassNumber;
    }

    
    public String getSalaryCourseName() {
        return salaryCourseName;
    }

    
    public void setSalaryCourseName(String salaryCourseName) {
        this.salaryCourseName = salaryCourseName;
    }

    
    public String getSalaryClassAddress() {
        return salaryClassAddress;
    }

    
    public void setSalaryClassAddress(String salaryClassAddress) {
        this.salaryClassAddress = salaryClassAddress;
    }

    
    public String getSalaryStatus() {
        return salaryStatus;
    }

    
    public void setSalaryStatus(String salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    
    public String getTeacherUserId() {
        return teacherUserId;
    }

    
    public void setTeacherUserId(String teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    
    public String getTeacherUserName() {
        return teacherUserName;
    }

    
    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    
    public String getSalaryIsVaild() {
        return salaryIsVaild;
    }

    
    public void setSalaryIsVaild(String salaryIsVaild) {
        this.salaryIsVaild = salaryIsVaild;
    }

    
    public Date getSalaryCreateTime() {
        return salaryCreateTime;
    }

    
    public void setSalaryCreateTime(Date salaryCreateTime) {
        this.salaryCreateTime = salaryCreateTime;
    }

    
    public Date getSalaryLastUptime() {
        return salaryLastUptime;
    }

    
    public void setSalaryLastUptime(Date salaryLastUptime) {
        this.salaryLastUptime = salaryLastUptime;
    }

    
    public String getSalaryLastUpuid() {
        return salaryLastUpuid;
    }

    
    public void setSalaryLastUpuid(String salaryLastUpuid) {
        this.salaryLastUpuid = salaryLastUpuid;
    }

    
    public String getSalaryLastUpuname() {
        return salaryLastUpuname;
    }

    
    public void setSalaryLastUpuname(String salaryLastUpuname) {
        this.salaryLastUpuname = salaryLastUpuname;
    }
}