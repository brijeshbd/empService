package com.brij.empService.dao;

import com.brij.empService.model.entity.Subject;

import java.util.List;

public interface SubjectDao {
    int save(Subject subject);

    List<Subject> getAll(Long facultyId);

    int deleteSub(Long subjectId);

    Subject getById(Long subjectId);
}
