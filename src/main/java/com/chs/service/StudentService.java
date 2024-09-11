package com.chs.service;

import java.util.List;

import com.chs.dto.StudentDto;
import com.chs.exception.InvalidStudentIdException;

public interface StudentService {
	
	StudentDto saveStudentDto(StudentDto studentDto);
	StudentDto findStudentDto(Long id) throws InvalidStudentIdException;
	List<StudentDto> getAllStudentDtos();
	StudentDto editStudentDto(StudentDto studentDto) throws InvalidStudentIdException;
	StudentDto delteStudentDto(StudentDto studentDto) throws InvalidStudentIdException;
	
}
