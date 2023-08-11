package com.brij.empService.model.entity;

public class Subject {

    Long subjectId;
    String subjectName;
    Long semester;
    Long facultyId;
    Long courseId;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", semester=" + semester +
                ", facultyId=" + facultyId +
                ", courseId=" + courseId +
                '}';
    }

    public Subject(String subjectName, Long semester, Long facultyId, Long courseId) {
        this.subjectName = subjectName;
        this.semester = semester;
        this.facultyId = facultyId;
        this.courseId = courseId;
    }

    public Subject() {
    }
}
