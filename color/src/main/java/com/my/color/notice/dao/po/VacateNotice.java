package com.my.color.notice.dao.po;

public class VacateNotice {
    /**请假通知id*/
    private String vacateNoticeId;

    /**待处理id*/
    private String waitDealId;

    /**请假单id*/
    private String noticeReferenceId;

    /**ͨ任课老师id*/
    private String noticeTeacherUid;

    /**老师姓名*/
    private String noticeTeacherUname;

    /**学生id*/
    private String vacateStudentUid;

    /**学生姓名*/
    private String vacateStudentUname;

    /**请假开始时间*/
    private String vacateStartTime;

    /**请假结束时间*/
    private String vacateEndTime;

    /**是否有效*/
    private String noticeIsVaild;

    /**是否查看*/
    private String noticeIsRead;

    /**创建时间*/
    private String noticeCreateTime;
    
    //临时字段
    /**辅导员姓名*/
    private String studentInstructorUname;
    
    /**请假类型:1节次，2天数*/
    private String vacateType;

    /**节次/天数*/
    private Double vacateNumber;
    
    /**班级*/
    private String studentClassName;

    
    public String getVacateNoticeId() {
        return vacateNoticeId;
    }

    
    public void setVacateNoticeId(String vacateNoticeId) {
        this.vacateNoticeId = vacateNoticeId;
    }

    
    public String getWaitDealId() {
        return waitDealId;
    }

    
    public void setWaitDealId(String waitDealId) {
        this.waitDealId = waitDealId;
    }

    
    public String getNoticeReferenceId() {
        return noticeReferenceId;
    }

    
    public void setNoticeReferenceId(String noticeReferenceId) {
        this.noticeReferenceId = noticeReferenceId;
    }

    
    public String getNoticeTeacherUid() {
        return noticeTeacherUid;
    }

    
    public void setNoticeTeacherUid(String noticeTeacherUid) {
        this.noticeTeacherUid = noticeTeacherUid;
    }

    
    public String getNoticeTeacherUname() {
        return noticeTeacherUname;
    }

    
    public void setNoticeTeacherUname(String noticeTeacherUname) {
        this.noticeTeacherUname = noticeTeacherUname;
    }

    
    public String getVacateStudentUid() {
        return vacateStudentUid;
    }

    
    public void setVacateStudentUid(String vacateStudentUid) {
        this.vacateStudentUid = vacateStudentUid;
    }

    
    public String getVacateStudentUname() {
        return vacateStudentUname;
    }

    
    public void setVacateStudentUname(String vacateStudentUname) {
        this.vacateStudentUname = vacateStudentUname;
    }

    
    public String getVacateStartTime() {
        return vacateStartTime;
    }

    
    public void setVacateStartTime(String vacateStartTime) {
        this.vacateStartTime = vacateStartTime;
    }

    
    public String getVacateEndTime() {
        return vacateEndTime;
    }

    
    public void setVacateEndTime(String vacateEndTime) {
        this.vacateEndTime = vacateEndTime;
    }

    
    public String getNoticeIsVaild() {
        return noticeIsVaild;
    }

    
    public void setNoticeIsVaild(String noticeIsVaild) {
        this.noticeIsVaild = noticeIsVaild;
    }

    
    public String getNoticeIsRead() {
        return noticeIsRead;
    }

    
    public void setNoticeIsRead(String noticeIsRead) {
        this.noticeIsRead = noticeIsRead;
    }

    
    public String getNoticeCreateTime() {
        return noticeCreateTime;
    }

    
    public void setNoticeCreateTime(String noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
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


	public String getStudentClassName() {
		return studentClassName;
	}


	public void setStudentClassName(String studentClassName) {
		this.studentClassName = studentClassName;
	}
    
    
}