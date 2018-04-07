package com.my.color.wait.dao.po;

import java.util.Date;

public class WaitDeal {
    /**待处理id*/
    private String waitDealId;

    /**请假单id*/
    private String waitReferenceId;

    /**辅导员id*/
    private String waitInstructorUid;

    /**辅导员名称*/
    private String waitInstructorUname;

    /**学生id*/
    private String waitStudentUid;

    /**学生姓名*/
    private String waitStudentUname;

    /**班级id*/
    private String waitClassId;

    /**班级名称*/
    private String waitClassName;

    /**是否有效*/
    private String waitIsVaild;

    /**处理状态（0待处理，1已处理）*/
    private String waitDealState;

    /**创建时间*/
    private String waitCreateTime;

    /**回复结果（1同意，2不同意）*/
    private String waitReplyResult;

    /**处理时间*/
    private Date waitReplyTime;

    
    public String getWaitDealId() {
        return waitDealId;
    }

    
    public void setWaitDealId(String waitDealId) {
        this.waitDealId = waitDealId;
    }

    
    public String getWaitReferenceId() {
        return waitReferenceId;
    }

    
    public void setWaitReferenceId(String waitReferenceId) {
        this.waitReferenceId = waitReferenceId;
    }

    
    public String getWaitInstructorUid() {
        return waitInstructorUid;
    }

    
    public void setWaitInstructorUid(String waitInstructorUid) {
        this.waitInstructorUid = waitInstructorUid;
    }

    
    public String getWaitInstructorUname() {
        return waitInstructorUname;
    }

    
    public void setWaitInstructorUname(String waitInstructorUname) {
        this.waitInstructorUname = waitInstructorUname;
    }

    
    public String getWaitStudentUid() {
        return waitStudentUid;
    }

    
    public void setWaitStudentUid(String waitStudentUid) {
        this.waitStudentUid = waitStudentUid;
    }

    
    public String getWaitStudentUname() {
        return waitStudentUname;
    }

    
    public void setWaitStudentUname(String waitStudentUname) {
        this.waitStudentUname = waitStudentUname;
    }

    
    public String getWaitClassId() {
        return waitClassId;
    }

    
    public void setWaitClassId(String waitClassId) {
        this.waitClassId = waitClassId;
    }

    
    public String getWaitClassName() {
        return waitClassName;
    }

    
    public void setWaitClassName(String waitClassName) {
        this.waitClassName = waitClassName;
    }

    
    public String getWaitIsVaild() {
        return waitIsVaild;
    }

    
    public void setWaitIsVaild(String waitIsVaild) {
        this.waitIsVaild = waitIsVaild;
    }

    
    public String getWaitDealState() {
        return waitDealState;
    }

    
    public void setWaitDealState(String waitDealState) {
        this.waitDealState = waitDealState;
    }

    
    public String getWaitCreateTime() {
        return waitCreateTime;
    }

    
    public void setWaitCreateTime(String waitCreateTime) {
        this.waitCreateTime = waitCreateTime;
    }

    
    public String getWaitReplyResult() {
        return waitReplyResult;
    }

    
    public void setWaitReplyResult(String waitReplyResult) {
        this.waitReplyResult = waitReplyResult;
    }

    
    public Date getWaitReplyTime() {
        return waitReplyTime;
    }

    
    public void setWaitReplyTime(Date waitReplyTime) {
        this.waitReplyTime = waitReplyTime;
    }
}