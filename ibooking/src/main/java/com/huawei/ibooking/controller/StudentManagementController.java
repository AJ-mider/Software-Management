package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentManagementController {
    @Autowired
    private StudentBusiness stuBiz;

    @GetMapping(value = "/manager/studentManagement")
    public ResponseEntity<List<StudentDO>> list() {
        final List<StudentDO> students = stuBiz.getStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/manager/studentManagement/{stuNum}")
    public ResponseEntity<StudentDO> query(@PathVariable("stuNum") String stuNum) {
        Optional<StudentDO> stu = stuBiz.getStudent(stuNum);

        return stu.map(studentDO -> new ResponseEntity<>(studentDO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/manager/studentManagement")
    public ResponseEntity<Void> add(@RequestBody StudentDO student) {
        boolean result = stuBiz.saveStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/manager/studentManagement")
    public ResponseEntity<Void> save(@RequestBody StudentDO student) {
        boolean result = stuBiz.saveStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/manager/studentManagement")
    public ResponseEntity<Void> delete(@RequestBody StudentDO student) {
        boolean result = stuBiz.deleteStudent(student.getStuNum());
        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
