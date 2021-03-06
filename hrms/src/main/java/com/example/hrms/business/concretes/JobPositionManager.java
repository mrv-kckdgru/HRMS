package com.example.hrms.business.concretes;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPositionManager implements JobPositionService {

	private final JobPositionDao jobPositionDao;	
	
	
	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.existsByPosition(jobPosition.getPosition())==false) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon başarılı bir şekilde eklendi.");
		}
		return new ErrorResult("Pozisyon eklenemedi, lütfen farklı bir pozisyon ismi deneyiniz!!!");		
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}
	
	
}