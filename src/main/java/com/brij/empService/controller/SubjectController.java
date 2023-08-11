package com.brij.empService.controller;

import com.brij.empService.model.request.SubjectRequest;
import com.brij.empService.model.response.SubjectResponse;
import com.brij.empService.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/save/{facultyId}")
    public ResponseEntity<?> saveSubject(@RequestBody SubjectRequest subjectRequest, @PathVariable Long facultyId){
        int subjectResponse = subjectService.saveSubject(facultyId, subjectRequest);
        if(subjectResponse == 1)
            return ResponseEntity.ok("Saved Successfully...");
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/getAll/{facultyId}")
    public ResponseEntity<List<?>> getAllByFacultyId(@PathVariable Long facultyId){
        List<SubjectResponse> responseList = subjectService.getAll(facultyId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping(value = "/delete/{facultyId}")
    public ResponseEntity<?> delete(@PathVariable Long facultyId, @RequestParam Long subjectId){
        int responseList = subjectService.deleteSubject(facultyId, subjectId);
        if(responseList>0)
            return ResponseEntity.ok("Deleted successfully...");
        return ResponseEntity.badRequest().build();
    }

}
