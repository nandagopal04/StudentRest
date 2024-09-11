package com.chs.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chs.converter.StudentConverter;
import com.chs.dto.StudentDto;
import com.chs.entity.Student;
import com.chs.exception.InvalidStudentIdException;
import com.chs.repository.StudentRepository;
import com.chs.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	StudentConverter studentConverter;
	
	@Override
	public List<StudentDto> getAllStudentDtos(){
		List<Student> allStudents = studentRepository.findAll();
		List<StudentDto> allStudentDtos = allStudents
				.stream()
				.map(studentConverter::convertStudentToStudentDto)
				.collect(Collectors.toList());
		return allStudentDtos;
	}
	
	@Transactional
	@Override
	public StudentDto saveStudentDto(StudentDto studentDto) {
		Student student = studentConverter.convertStudentDtoToStudent(studentDto);
		studentRepository.save(student);
		return studentConverter.convertStudentToStudentDto(student);
	}

	@Override
	public StudentDto findStudentDto(Long id) throws InvalidStudentIdException {
		Optional<Student> optStudent = studentRepository.findById(id);
		if(!optStudent.isPresent()) {
			throw new InvalidStudentIdException("No Student exitsts with the given ID: "+id);
		}
		StudentDto studentDto = studentConverter.convertStudentToStudentDto(optStudent.get());
		return studentDto;
	}

	@Transactional
	@Override
	public StudentDto editStudentDto(StudentDto studentDto) throws InvalidStudentIdException {
		Student student = studentConverter.convertStudentDtoToStudent(studentDto);
		if(!studentRepository.existsById(student.getId())) {
			throw new InvalidStudentIdException("Invalid Student details. Pleas provide only existing student details");
		}
		StudentDto savedStudentDto = studentConverter.convertStudentToStudentDto(studentRepository.save(student));
		return savedStudentDto;
	}

	@Transactional
	@Override
	public StudentDto delteStudentDto(StudentDto studentDto) throws InvalidStudentIdException {
		Student student = studentConverter.convertStudentDtoToStudent(studentDto);
		if(!studentRepository.existsById(student.getId())) {
			throw new InvalidStudentIdException("Invalid Student details. Pleas provide only existing student details");
		}
		StudentDto deletedStudentDto = studentConverter.convertStudentToStudentDto(student);
		studentRepository.delete(student);
		return deletedStudentDto;
	}
}
