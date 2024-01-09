package com.jspiders.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student findStudentById(long id) {
		Optional<Student> optional = studentRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Student deleteStudentById(long id) {
		Student student = findStudentById(id);
		studentRepo.deleteById(id);
		return student;
	}

	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student findStudentByMobile(long mobile) {
		return studentRepo.findByMobile(mobile);
	}

}
