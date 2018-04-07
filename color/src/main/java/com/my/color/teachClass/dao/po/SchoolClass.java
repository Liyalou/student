package com.my.color.teachClass.dao.po;

public class SchoolClass {
    /**班级管理id*/
    private String schoolClassId;

    /**年级*/
    private String schoolGradeNumber;

    /**班级*/
    private String schoolClassNumber;

    /**专业*/
    private String classSpecialty;
    
    /**班级名称：school_class_name*/
    private String schoolClassName;

    /**人数*/
    private Integer classStudentNumber;

    /**培训方案*/
    private String classTrainScheme;

    /**毕业时间*/
    private String classGraduationTime;

    /**辅导员id*/
    private String classInstructorUid;

    /**辅导员*/
    private String classInstructorUname;

    /**创建时间*/
    private String classCreateTime;

    /**创建人id*/
    private String classCreateUid;

    /**创建人姓名*/
    private String classCreateUname;

    /**修改人id*/
    private String classLastUpuid;

    /**修改人*/
    private String classLastUpuname;

    /**修改时间*/
    private String classLastUptime;
    
    /**是否有效：class_is_vaild*/
    private String classIsVaild;

    
    public String getClassIsVaild() {
		return classIsVaild;
	}


	public void setClassIsVaild(String classIsVaild) {
		this.classIsVaild = classIsVaild;
	}


	public String getSchoolClassName() {
		return schoolClassName;
	}


	public void setSchoolClassName(String schoolClassName) {
		this.schoolClassName = schoolClassName;
	}


	public String getSchoolClassId() {
        return schoolClassId;
    }

    
    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    
    public String getSchoolGradeNumber() {
        return schoolGradeNumber;
    }

    
    public void setSchoolGradeNumber(String schoolGradeNumber) {
        this.schoolGradeNumber = schoolGradeNumber;
    }

    
    public String getSchoolClassNumber() {
        return schoolClassNumber;
    }

    
    public void setSchoolClassNumber(String schoolClassNumber) {
        this.schoolClassNumber = schoolClassNumber;
    }

    
    public String getClassSpecialty() {
        return classSpecialty;
    }

    
    public void setClassSpecialty(String classSpecialty) {
        this.classSpecialty = classSpecialty;
    }

    
    public Integer getClassStudentNumber() {
        return classStudentNumber;
    }

    
    public void setClassStudentNumber(Integer classStudentNumber) {
        this.classStudentNumber = classStudentNumber;
    }

    
    public String getClassTrainScheme() {
        return classTrainScheme;
    }

    
    public void setClassTrainScheme(String classTrainScheme) {
        this.classTrainScheme = classTrainScheme;
    }

    
    public String getClassGraduationTime() {
        return classGraduationTime;
    }

    
    public void setClassGraduationTime(String classGraduationTime) {
        this.classGraduationTime = classGraduationTime;
    }

    
    public String getClassInstructorUid() {
        return classInstructorUid;
    }

    
    public void setClassInstructorUid(String classInstructorUid) {
        this.classInstructorUid = classInstructorUid;
    }

    
    public String getClassInstructorUname() {
        return classInstructorUname;
    }

    
    public void setClassInstructorUname(String classInstructorUname) {
        this.classInstructorUname = classInstructorUname;
    }

    
    public String getClassCreateTime() {
        return classCreateTime;
    }

    
    public void setClassCreateTime(String classCreateTime) {
        this.classCreateTime = classCreateTime;
    }

    
    public String getClassCreateUid() {
        return classCreateUid;
    }

    
    public void setClassCreateUid(String classCreateUid) {
        this.classCreateUid = classCreateUid;
    }

    
    public String getClassCreateUname() {
        return classCreateUname;
    }

    
    public void setClassCreateUname(String classCreateUname) {
        this.classCreateUname = classCreateUname;
    }

    
    public String getClassLastUpuid() {
        return classLastUpuid;
    }

    
    public void setClassLastUpuid(String classLastUpuid) {
        this.classLastUpuid = classLastUpuid;
    }

    
    public String getClassLastUpuname() {
        return classLastUpuname;
    }

    
    public void setClassLastUpuname(String classLastUpuname) {
        this.classLastUpuname = classLastUpuname;
    }

    
    public String getClassLastUptime() {
        return classLastUptime;
    }

    
    public void setClassLastUptime(String classLastUptime) {
        this.classLastUptime = classLastUptime;
    }
}