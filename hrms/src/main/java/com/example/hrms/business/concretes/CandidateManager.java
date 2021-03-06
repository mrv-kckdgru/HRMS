package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.JobPosting;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Veriler listelendi");
	}
	@Override
	public Result add(Candidate candidate) {		
		//if(userDao.existsByEmail(candidate.getEmail())==true && candidateDao.existsByNationalNumber(candidate.getNationalNumber())==true && candidate.getPassword()==candidate.getPasswordRepeat()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde eklendi");			
		//}
		//return new ErrorResult("Şifre ve şifre tekrar uyuşmuyor veya aynı email daha önceden eklenmiş veya TC Kimlik Numarası daha önceden eklenmiş!!!");		
		
	}
	
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id), "Veri listelendi");
	}
	
	
	@Override
	public Result update(Candidate candidate) {
		System.out.println(candidate.getFirstName());
		//if(candidate.getPassword() == candidate.getPasswordRepeat()) {
			Candidate updateCandidate = this.candidateDao.getById(candidate.getId());
			updateCandidate.setFirstName(candidate.getFirstName());
			updateCandidate.setLastName(candidate.getLastName());
			updateCandidate.setDateOfBirth(candidate.getDateOfBirth());
			updateCandidate.setEmail(candidate.getEmail());
			updateCandidate.setNationalNumber(candidate.getNationalNumber());
			updateCandidate.setPassword(candidate.getPassword());
			this.candidateDao.save(updateCandidate);
			return new SuccessResult("Güncelleme işlemi başarılı bir şekilde gerçekleştirildi.");
		//}
		
		//return new ErrorResult("Şifreler uyuşmuyor!");
	}
}
