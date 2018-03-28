package com.my.color.vacate.dao.po;

import java.util.Date;

public class StudentVacate {
    /**学生请假id*/
    private String studentVacateId;

    /**请假人id*/
    private String vacateUserId;

    /**姓名*/
    private String vacateUserName;

    /**班级*/
    private String vacateUserClass;

    /**辅导员*/
    private String studentInstructorUid;

    /**辅导员姓名*/
    private String studentInstructorUname;

    /**请假类型*/
    private String vacateType;

    /**节次/天数*/
    private Double vacateNumber;

    /**请假开始时间*/
    private Date vacateStartTime;

    /**请假结束时间*/
    private Date vacateEndTime;

    /**课时名称*/
    private String vacateCourseName;

    /**请假理由*/
    private String vacateReason;

    /**是否有效*/
    private String vacateIsVaild;

    /**请假状态*/
    private String vacateState;

    /***/
    private Date vacateCreateTime;

    
    public String getStudentVacateId() {
        return studentVacateId;
    }

    
    public void setStudentVacateId(String studentVacateId) {
        this.studentVacateId = studentVacateId;
    }

    
    public String getVacateUserId() {
        return vacateUserId;
    }

    
    public void setVacateUserId(String vacateUserId) {
        this.vacateUserId = vacateUserId;
    }

    
    public String getVacateUserName() {
        return vacateUserName;
    }

    
    public void setVacateUserName(String vacateUserName) {
        this.vacateUserName = vacateUserName;
    }

    
    public String getVacateUserClass() {
        return vacateUserClass;
    }

    
    public void setVacateUserClass(String vacateUserClass) {
        this.vacateUserClass = vacateUserClass;
    }

    
    public String getStudentInstructorUid() {
        return studentInstructorUid;
    }

    
    public void setStudentInstructorUid(String studentInstructorUid) {
        this.studentInstructorUid = studentInstructorUid;
    }

    
    public String getStudentInstructorUname() {
        return studentInstructorUname;
    }

    
    public void setStudentInstructorUname(String studentInstructorUname) {
        this.studentInstructorUname = studentInstructorUname;
    }

    
    public String getVacateType() {
        return vacateType;
    }

    
    public void setVacateType(String vacateType) {
        this.vacateType = vacateType;
    }

    
    public Double getVacateNumber() {
        return vacateNumber;
    }

    
    public void setVacateNumber(Double vacateNumber) {
        this.vacateNumber = vacateNumber;
    }

    
    public Date getVacateStartTime() {
        return vacateStartTime;
    }

    
    public void setVacateStartTime(Date vacateStartTime) {
        this.vacateStartTime = vacateStartTime;
    }

    
    public Date getVacateEndTime() {
        return vacateEndTime;
    }

    
    public void setVacateEndTime(Date vacateEndTime) {
        this.vacateEndTime = vacateEndTime;
    }

    
    public String getVacateCourseName() {
        return vacateCourseName;
    }

    
    public void setVacateCourseName(String vacateCourseName) {
        this.vacateCourseName = vacateCourseName;
    }

    
    public String getVacateReason() {
        return vacateReason;
    }

    
    public void setVacateReason(String vacateReason) {
        this.vacateReason = vacateReason;
    }

    
    public String getVacateIsVaild() {
        return vacateIsVaild;
    }

    
    public void setVacateIsVaild(String vacateIsVaild) {
        this.vacateIsVaild = vacateIsVaild;
    }

    
    public String getVacateState() {
        return vacateState;
    }

    
    public void setVacateState(String vacateState) {
        this.vacateState = vacateState;
    }

    
    public Date getVacateCreateTime() {
        return vacateCreateTime;
    }

    
    public void setVacateCreateTime(Date vacateCreateTime) {
        this.vacateCreateTime = vacateCreateTime;
    }
}