package com.my.color.teacher.dao.po;

public class TeacherClass {
    /**�༶id*/
    private String schoolClassId;

    /**��ʦid*/
    private String teacherUserId;

    /**��ʦ���ͣ�1����Ա��2�ο���ʦ��*/
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