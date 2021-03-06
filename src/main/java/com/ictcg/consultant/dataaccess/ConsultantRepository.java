package com.ictcg.consultant.dataaccess;

import java.util.Collection;

public interface ConsultantRepository {
	
	Collection<ConsultantEntity> findAll();
	
	ConsultantEntity findById(Integer id);
	
	void save(ConsultantEntity consultantEntity);
	
	void delete(ConsultantEntity consultantEntity);
}
