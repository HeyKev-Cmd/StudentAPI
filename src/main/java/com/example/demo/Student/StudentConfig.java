package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Configuration
public class StudentConfig {

    private SequenceGeneratorService sequenceGeneratorService;
    private StudentRepository studentRepository;
    @Autowired
    public StudentConfig(SequenceGeneratorService sequenceGeneratorService, StudentRepository studentRepository) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.studentRepository = studentRepository;
    }





    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args-> {



            Student Luka= new Student(
                    "Luka",
                    "Dpncic",
                    2407777777L,
                    "UMD",
                    "Luka77@umd.edu",
                    LocalDate.of(2000, Month.JANUARY,26),
                    2022
            );

            Student Daniel= new Student(
                    "Daniel",
                    "Son",
                    2407777777L,
                    "UMD",
                    "Daniel3@umd.edu",
                    LocalDate.of(2000, Month.FEBRUARY,26),
                    2023
            );

//            check if email exist
            Optional<Student> LukaOptional=studentRepository.findByEmail(Daniel.getEmail());
            if (! LukaOptional.isPresent()){
                Luka.setID(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
                repository.save(Luka);
            }

            Optional<Student> DanielOptional=studentRepository.findByEmail(Daniel.getEmail());
            if (! DanielOptional.isPresent()){
                Daniel.setID(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
                repository.save(Daniel);
            }

        };
    }
}

