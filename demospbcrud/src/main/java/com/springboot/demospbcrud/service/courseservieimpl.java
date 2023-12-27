package com.springboot.demospbcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demospbcrud.binding.Course;
import com.springboot.demospbcrud.repo.CourseRepository;

@Service
public class courseservieimpl implements courseservice {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public String upsert(Course course) {
        courseRepo.save(course);
        return "SUCCESS";
        
    }

    @Override
    public Course getById(Integer cid) {
        Optional<Course> findById = courseRepo.findById(cid);
        
        if(findById.isPresent())
        {
            return findById.get();
        }
        
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteById(Integer cid) {
      if(courseRepo.existsById(cid)){
        courseRepo.deleteById(cid);
        return " Delete sucess";
      }
      else{
        return "No record found";
      }    
    
    }
    
}
