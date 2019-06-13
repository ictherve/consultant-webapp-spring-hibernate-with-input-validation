package com.ictcg.consultant.service;

import java.util.Collection;

import com.ictcg.consultant.model.Consultant;

public interface ConsultantService {

	Collection<Consultant> findAll();
	
	Consultant findById(Integer id);
	
	void save(Consultant consultant);
	
	void delete(Integer id);
}
