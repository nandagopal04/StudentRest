package com.chs.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6921203581815637838L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "roll_no")
	private String rollNo;
	private String name;
	@Column(name="ph_no")
	private Long phone;
	private String email;
	
}
