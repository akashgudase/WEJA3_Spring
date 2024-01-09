package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/student")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addStudent = studentService.addStudent(student);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setMessage("Student added");
		studentResponse.setStudent(addStudent);
		studentResponse.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
	}

	@GetMapping(path = "/student/{id}")
	public ResponseEntity<StudentResponse> findStudentById(@PathVariable long id) {
		Student student = studentService.findStudentById(id);
		if (student != null) {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student found");
			studentResponse.setStudent(student);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		} else {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/student/{id}")
	public ResponseEntity<StudentResponse> deleteStudentById(@PathVariable long id) {
		Student student = studentService.deleteStudentById(id);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setMessage("Student deleted");
		studentResponse.setStudent(student);
		studentResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
	}

	@PutMapping(path = "/student")
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(student);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setMessage("Student updated");
		studentResponse.setStudent(updatedStudent);
		studentResponse.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/student")
	public ResponseEntity<StudentResponse> findStudentByMobile(@RequestParam long mobile) {
		Student student = studentService.findStudentByMobile(mobile);
		if (student != null) {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student found");
			studentResponse.setStudent(student);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		} else {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}

}
