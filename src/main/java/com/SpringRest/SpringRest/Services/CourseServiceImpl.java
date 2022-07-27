package com.SpringRest.SpringRest.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.SpringRest.Dao.CourseDao;
import com.SpringRest.SpringRest.entities.Courses;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courceDao;
	
	
//	List<Courses>list;
	
	public CourseServiceImpl() {
		
	
			
//		list=new ArrayList<>();
//		list.add(new Courses(145,"Java core course","this course contains basic of java"));
//		list.add(new Courses(4343,"Spring boot course","this course contains basic of Spring"));
		
	}


	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
	return courceDao.findAll();
	}




	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseId) {
//   Courses c=null;
//    for(Courses course:list) {
//	if(course.getId()==courseId) {
//	c=course;
//		break;
//		
//	}
//	
//}
		return courceDao.getOne(courseId);
		
//		
	}
	

	
	public Courses addCourse(Courses course) {
		
//		list.add(course);
		courceDao.save(course);
		return course;
	}


	@Override
	public Courses UpdateCourse(Courses course) {
//			
//		list.forEach(e-> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		
//		});
		courceDao.save(course);
		
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		@SuppressWarnings("deprecation")
		Courses entity=courceDao.getOne(parseLong);
		courceDao.delete(entity);
	}

	
}
