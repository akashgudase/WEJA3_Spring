package com.jspiders.smswithspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspiders.smswithspringrest.controller.service.StudentService;
import com.jspiders.smswithspringrest.pojo.Student;
import com.jspiders.smswithspringrest.response.StudentResponse;

@Controller
@ResponseBody
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addStudent = studentService.addStudent(student);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setMessage("Student added");
		studentResponse.setStudent(addStudent);
		studentResponse.setStudents(null);
		studentResponse.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
	}

	@GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		if (students != null && students.size() > 0) {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Students fetched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(students);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		} else {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Students not fetched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}

}
