package com.brij.empService.service;

import com.brij.empService.dao.SubjectDao;
import com.brij.empService.model.entity.Subject;
import com.brij.empService.model.request.SubjectRequest;
import com.brij.empService.model.response.SubjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SubjectServiceImpl implements SubjectService{

    static final String COURSE_NAME_BY_ID = "http://localhost:8081/course/getNameById/";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public int saveSubject(Long facultyId, SubjectRequest subjectRequest) {

        Subject subject = new Subject(subjectRequest.getSubjectName(), subjectRequest.getSemester(), facultyId, subjectRequest.getCourseId());

        return subjectDao.save(subject);
    }

    @Override
    public List<SubjectResponse> getAll(Long facultyId) {
        List<Subject> subjectList = subjectDao.getAll(facultyId);
        Long courseId = subjectList.get(0).getCourseId();
        String courseName = restTemplate.getForObject("http://localhost:8081/course/getNameById/"+courseId, String.class);
        List<SubjectResponse> subjectResponses = new ArrayList<>();
        for(Subject s : subjectList) {
            SubjectResponse subjectResponse = new SubjectResponse("S"+s.getSubjectId(),s.getSubjectName(), s.getSemester(), courseName);
            subjectResponses.add(subjectResponse);
        }
        return subjectResponses;
    }

    @Override
    public int deleteSubject(Long facultyId, Long subjectId) {
        Subject subject = subjectDao.getById(subjectId);
        if(subject!=null && (!Objects.equals(subject.getFacultyId(), facultyId)))
                {throw new RuntimeException("Faculty is different here...");
        }
        return subjectDao.deleteSub(subjectId);
    }
}
