package com.ictcg.consultant.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ictcg.consultant.dataaccess.ConsultantEntity;
import com.ictcg.consultant.dataaccess.ConsultantRepository;
import com.ictcg.consultant.model.Consultant;

@Service
public class ConsultantServiceImpl implements ConsultantService{

	@Autowired
	private ConsultantRepository consultantRepository;
	
	@Autowired
	private ModelMapper converter;

	@Override
	public Collection<Consultant> findAll() {
		
		return consultantRepository.findAll()
				.stream()
				.map(consultantEntity -> converter.map(consultantEntity, Consultant.class))
				.collect(Collectors.toList());
	}

	@Override
	public Consultant findById(Integer id) {
		return converter.map(consultantRepository.findById(id), Consultant.class);
	}

	@Override
	public void save(Consultant consultant) {
		consultantRepository.save(converter.map(consultant, ConsultantEntity.class));
	}

	@Override
	public void delete(Consultant consultant) {
		consultantRepository.delete(converter.map(consultant, ConsultantEntity.class));
	}
	
	
}
