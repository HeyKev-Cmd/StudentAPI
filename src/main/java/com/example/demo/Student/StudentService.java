package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    public StudentService() {
    }

    private static StudentRepository studentRepository;
    private static  SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    public StudentService(StudentRepository studentRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.studentRepository = studentRepository;
        this.sequenceGeneratorService=sequenceGeneratorService;
    }


    public static void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken!");
        }
        student.setID(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        studentRepository.save(student);
        System.out.println(student+"added");
    }

    public List<Student> getStudents( )
    {
        return studentRepository.findAll();
    }

    public void delStudent(Long id) {
        boolean exists=studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Student with Id: "+id+" does not exist!");
        }
        studentRepository.deleteByid(id);
        sequenceGeneratorService.decreaseSequence(Student.SEQUENCE_NAME);
        System.out.println("Student with ID: "+id+" deleted");
    }


    public void editStudent(Long id,String firstName,String lastName,String email) {
           Student student= studentRepository.findByid(id);
            if (student==null){
                throw new IllegalStateException("Student with Id: "+id+" does not exist!");
            }
            if(
                    firstName!= null&&
                            firstName.length()>0&&
                            !Objects.equals(student.getFirstName(),firstName)
            ){
                student.setFirstName(firstName);
            }
            if(
                    lastName!= null&&
                            lastName.length()>0&&
                            !Objects.equals(student.getLastName(),lastName)
            ){
                student.setLastName(lastName);
            }
            if(
                    email!= null&&
                            email.length()>0&&
                            !Objects.equals(student.getEmail(),email)
            ){
//                check if email been taken
                Optional<Student> studentOptional=studentRepository.findByEmail(email);
                System.out.println(studentOptional);
                System.out.println(email);
                if (studentOptional.isPresent()){
                    throw new IllegalStateException("Email Taken!");
                }
                student.setEmail(email);
            }
            System.out.println(student);
            studentRepository.save(student);
    }
}
