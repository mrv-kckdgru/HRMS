package com.example.hrms.entities.dtos;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyAddDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="description")
	@NotBlank(message = "Açıklama alanı boş geçilemez!")
	private String description;
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
}
