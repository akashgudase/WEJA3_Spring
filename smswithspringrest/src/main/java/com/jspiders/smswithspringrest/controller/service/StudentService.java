package com.jspiders.smswithspringrest.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringrest.pojo.Student;
import com.jspiders.smswithspringrest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.addStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

}
