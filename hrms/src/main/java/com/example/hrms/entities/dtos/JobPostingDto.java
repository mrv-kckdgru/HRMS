package com.example.hrms.entities.dtos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hrms.entities.concretes.City;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	//isimlendirmeye dikkat et
	private int id;
	private int numberOfPosition;
	private Date applicationDeadline;
	private Boolean status;	
	private Date releaseDate;			
	private JobPosition jobPositionPosition;	
	private Employer employerCompanyName;
}
