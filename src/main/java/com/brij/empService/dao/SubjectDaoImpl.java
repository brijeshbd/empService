package com.brij.empService.dao;

import com.brij.empService.model.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDaoImpl implements SubjectDao{

    static final String SAVE_SUBJECT = "INSERT INTO faculty.subject (subject_name, semester, faculty_id, course_id) VALUES(?,?,?,?)";
    static final String SUBJECT_BY_FACULTY = "SELECT * FROM faculty.subject WHERE faculty_id = ?";
    static final String DELETE_BY_ID = "DELETE FROM faculty.subject WHERE subject_id = ?";
    static final String SUBJECT_BY_ID = "SELECT * FROM faculty.subject WHERE subject_id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Subject subject) {
        return jdbcTemplate.update(SAVE_SUBJECT, new Object[]{subject.getSubjectName(), subject.getSemester(), subject.getFacultyId(), subject.getCourseId()});
    }

    @Override
    public List<Subject> getAll(Long facultyId) {
        return jdbcTemplate.query(SUBJECT_BY_FACULTY, BeanPropertyRowMapper.newInstance(Subject.class), facultyId);
    }

    @Override
    public int deleteSub(Long subjectId) {
        return jdbcTemplate.update(DELETE_BY_ID, subjectId);
    }

    @Override
    public Subject getById(Long subjectId) {
        return jdbcTemplate.queryForObject(SUBJECT_BY_ID,
                BeanPropertyRowMapper.newInstance(Subject.class), subjectId);
    }
}
