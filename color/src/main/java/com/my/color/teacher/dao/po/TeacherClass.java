package com.my.color.teacher.dao.po;

public class TeacherClass {
    /**班级id*/
    private String schoolClassId;

    /**老师id*/
    private String teacherUserId;

    /**老师类型（1辅导员，2任课老师）*/
    private String teacherType;

    
    public String getSchoolClassId() {
        return schoolClassId;
    }

    
    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    
    public String getTeacherUserId() {
        return teacherUserId;
    }

    
    public void setTeacherUserId(String teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    
    public String getTeacherType() {
        return teacherType;
    }

    
    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }
}