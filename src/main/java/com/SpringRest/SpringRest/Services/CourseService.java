package com.SpringRest.SpringRest.Services;

import java.util.List;

import com.SpringRest.SpringRest.entities.Courses;

public interface CourseService {
	
public List<Courses> getCourses();

public Courses getCourse(long courseId);

public Courses addCourse(Courses courses);

public Courses UpdateCourse(Courses course);

public void deleteCourse(long parseLong);

}
