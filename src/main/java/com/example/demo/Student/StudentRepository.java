package com.example.demo.Student;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {
    boolean existsByID(Long id);
    Student findByid (Long id);
    long deleteByid(@NonNull Long id);
    @Query("{ 'Email' : ?0 }")
    Optional<Student> findByEmail(String Email);

}
