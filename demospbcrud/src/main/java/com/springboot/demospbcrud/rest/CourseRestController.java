package com.springboot.demospbcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.demospbcrud.binding.Course;
import com.springboot.demospbcrud.service.courseservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CourseRestController {
    @Autowired
    private courseservice courseservice;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course)
    {
        String status = courseservice.upsert(course);   
        return ResponseEntity.status(HttpStatus.CREATED).body("Resource created successfully");
    } 
    @GetMapping("/course/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid)
    {
       Course course  = courseservice.getById(cid);
       return new ResponseEntity<>(course,HttpStatus.OK);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        List<Course> allCourses = courseservice.getAllCourses();
        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }
    
    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course)
    {
        String status = courseservice.upsert(course);   
        return ResponseEntity.status(HttpStatus.CREATED).body(" Course updated successfully");
    }

    @DeleteMapping("/course/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid)
    {
       String status  = courseservice.deleteById(cid);
       return new ResponseEntity<>(status,HttpStatus.OK);
    }
  
}
