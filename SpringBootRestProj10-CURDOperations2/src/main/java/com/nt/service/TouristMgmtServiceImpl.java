package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Tourist;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	 @Autowired
	private ITouristRepo   touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
	       int idVal=touristRepo.save(tourist).getTid();
		return "Tourist is registered  having the id value ::"+idVal;
	}

	@Override
	public List<Tourist> fetchAllTOurist() {
			List<Tourist> list=touristRepo.findAll();
		return list;
	}

	
}
