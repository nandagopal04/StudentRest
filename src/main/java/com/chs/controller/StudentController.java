package com.chs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chs.dto.StudentDto;
import com.chs.exception.InvalidStudentIdException;
import com.chs.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// save new student
	@PostMapping("/create")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
		StudentDto savedStudentDto = studentService.saveStudentDto(studentDto);
		return new ResponseEntity<StudentDto>(savedStudentDto, HttpStatus.CREATED);
	}
	
	// find all students
	@GetMapping("/get/all")
	public ResponseEntity<List<StudentDto>> findAllStudents(){
		List<StudentDto> allStudents = studentService.getAllStudentDtos();
		return new ResponseEntity<List<StudentDto>>(allStudents, HttpStatus.OK);
	}
	
	// find student by id
	@GetMapping("/find/{id}")
	public ResponseEntity<StudentDto> getStudentDto(@PathVariable Long id) throws InvalidStudentIdException{
		StudentDto studentDto = studentService.findStudentDto(id);
		return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
	}
	
	// edit student
	@PutMapping("/edit")
	public ResponseEntity<StudentDto> editStudentDto(@RequestBody StudentDto studentDto) throws InvalidStudentIdException{
		StudentDto editStudentDto = studentService.editStudentDto(studentDto);
		return new ResponseEntity<StudentDto>(editStudentDto, HttpStatus.OK);
	}
	
	// edit specific details of student
	@PatchMapping("/patch")
	public ResponseEntity<StudentDto> patchStudentDto(@RequestBody StudentDto studentDto) throws InvalidStudentIdException{
		StudentDto patchStudentDto = studentService.findStudentDto(studentDto.getId());
		if(studentDto.getRollNo() != null) {
			patchStudentDto.setRollNo(studentDto.getRollNo());
		}
		if(studentDto.getName() != null) {
			patchStudentDto.setName(studentDto.getName());
		}
		if(studentDto.getPhone() != 0) {
			patchStudentDto.setPhone(studentDto.getPhone());
		}
		if(studentDto.getEmail() != null) {
			patchStudentDto.setEmail(studentDto.getEmail());
		}
		studentService.editStudentDto(patchStudentDto);
		return new ResponseEntity<StudentDto>(patchStudentDto, HttpStatus.OK);
	}
	
	// delete student
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StudentDto> deleteStudentDto(@PathVariable Long id) throws InvalidStudentIdException{
		StudentDto studentDto = studentService.findStudentDto(id);
		StudentDto deletedStudent = studentService.delteStudentDto(studentDto);
		return new ResponseEntity<StudentDto>(deletedStudent, HttpStatus.NO_CONTENT);
	}
	
}
