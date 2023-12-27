package com.springboot.demospbcrud.service;



import java.util.List;

import com.springboot.demospbcrud.binding.Course;

public interface courseservice {
  
    public String upsert(Course course);

    public Course getById(Integer cid);

    public List<Course> getAllCourses();

    public String deleteById(Integer cid);



}
