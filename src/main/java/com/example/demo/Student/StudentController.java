package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService= studentService;
    }

    @GetMapping("getStudents")
    public List<Student> getStudents( )
    {
        return studentService.getStudents();
    }
    @PostMapping("addStudent")
    public void addStudent(@RequestBody Student student){
        StudentService.addNewStudent(student);
    }
    @DeleteMapping("delStudent")
    public void deleteStudent(
             @RequestParam("studentId")Long id
    ) {
        studentService.delStudent(id);
    }
    @PutMapping("editStudent")
    public void editStudent(
            @RequestParam(value = "studentId")Long id,
            @RequestParam(value = "firstName",required=false) String firstName,
            @RequestParam(value = "lastName",required = false) String lastName,
            @RequestParam(value = "email",required = false) String email
    ){

        studentService.editStudent(id,firstName,lastName,email);
    }
}
