package com.example.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resumes")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedln_link")
	private String linkedlnLink;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="description")
	private String description;
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
	
	@Column(name="status")
	private boolean status=true;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name="candidate_id", referencedColumnName="id", nullable = false)
	private Candidate candidate;
	
	@OneToMany(mappedBy="resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy="resume", cascade=CascadeType.ALL)
	private List<Technology> technologies;
	
	@OneToMany(mappedBy="resume", cascade=CascadeType.ALL)
	private List<Education> education;
	
	@OneToMany(mappedBy="resume", cascade=CascadeType.ALL)
	private List<JobExperience> jobExperiences;
}
