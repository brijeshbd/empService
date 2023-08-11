package com.brij.empService.service;

import com.brij.empService.model.request.SubjectRequest;
import com.brij.empService.model.response.SubjectResponse;

import java.util.List;

public interface SubjectService {
    int saveSubject(Long facultyId, SubjectRequest subjectRequest);

    List<SubjectResponse> getAll(Long facultyId);

    int deleteSubject(Long facultyId, Long subjectId);
}
