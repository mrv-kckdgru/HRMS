package com.example.hrms.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.FavoriteJobPosting;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.EducationAddDto;
import com.example.hrms.entities.dtos.FavoriteJobPostingAddDto;
import com.example.hrms.entities.dtos.JobExperienceAddDto;
import com.example.hrms.entities.dtos.JobPostingAddDto;
import com.example.hrms.entities.dtos.LanguageAddDto;
import com.example.hrms.entities.dtos.TechnologyAddDto;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(jobPostingAddDtoMap);	
		modelMapper.addMappings(educationAddDtoMap);	
		modelMapper.addMappings(jobExperienceAddDtoMap);	
		modelMapper.addMappings(technologyAddDtoMap);
		modelMapper.addMappings(languageAddDtoMap);
		modelMapper.addMappings(favoriteJobPostingAddDtoMap);
		return modelMapper;
	}
	
	private final PropertyMap<JobPostingAddDto, JobPosting> jobPostingAddDtoMap = new PropertyMap<JobPostingAddDto, JobPosting>(){
		protected void configure() {
			map(source.getCityId(), destination.getCity().getId());
			map(source.getJobPositionId(), destination.getJobPosition().getId());
			map(source.getWorkingTimeId(), destination.getWorkingTime().getId());
			map(source.getWorkingTypeId(), destination.getWorkingType().getId());
			map(source.getEmployerId(), destination.getEmployer().getId());
		}
	};	
	
	private final PropertyMap<EducationAddDto, Education> educationAddDtoMap = new PropertyMap<EducationAddDto, Education>(){
		protected void configure() {
			map(source.getGraduateTypeId(), destination.getGraduateType().getId());		
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
	
	private final PropertyMap<JobExperienceAddDto, JobExperience> jobExperienceAddDtoMap = new PropertyMap<JobExperienceAddDto, JobExperience>(){
		protected void configure() {
			map(source.getJobPositionId(), destination.getJobPosition().getId());		
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
	
	private final PropertyMap<TechnologyAddDto, Technology> technologyAddDtoMap = new PropertyMap<TechnologyAddDto, Technology>(){
		protected void configure() {			
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
	
	private final PropertyMap<LanguageAddDto, Language> languageAddDtoMap = new PropertyMap<LanguageAddDto, Language>(){
		protected void configure() {			
			map(source.getResumeId(), destination.getResume().getId());		
		}
	};	
		
	
	private final PropertyMap<FavoriteJobPostingAddDto, FavoriteJobPosting> favoriteJobPostingAddDtoMap = new PropertyMap<FavoriteJobPostingAddDto, FavoriteJobPosting>(){
		protected void configure() {
			map(source.getCandidateId(), destination.getCandidate().getId());
			map(source.getJobPostingId(), destination.getJobPosting().getId());
		}
	};	
	
	
}
