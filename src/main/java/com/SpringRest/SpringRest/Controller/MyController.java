package com.SpringRest.SpringRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.SpringRest.Services.CourseService;
import com.SpringRest.SpringRest.entities.Courses;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		
	return "Welcome to courses application";
		
		
	}
	
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		
		return this.courseservice.getCourses();
	}
	
	//get single course
    @GetMapping("/courses/{courseId}")	
     public Courses getCourse(@PathVariable String courseId) {
	
	 return this.courseservice.getCourse(Long.parseLong(courseId));
	
}
    //add new course
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses courses) {
    	return this.courseservice.addCourse(courses);
    	
    }
    
  //Update course using PUT mapping
	@PutMapping("/courses")
  	public Courses UpdateCourse(@RequestBody Courses course) {
  		return this.courseservice.UpdateCourse(course);
  	}
//delete the courses
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String courseId){
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
