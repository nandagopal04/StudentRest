package com.chs.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.chs.dto.StudentDto;
import com.chs.entity.Student;

@Configuration
public class StudentConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	public StudentDto convertStudentToStudentDto(Student student) {
		StudentDto studentDto = modelMapper.map(student, StudentDto.class);
		return studentDto;
	}
	
	public Student convertStudentDtoToStudent(StudentDto studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		return student;
	}
}
