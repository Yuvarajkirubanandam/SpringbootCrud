package com.springboot.demospbcrud.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demospbcrud.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {

    

    
}
