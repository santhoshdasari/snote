package com.sermon.mynote.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sermon.mynote.domain.Organization;
import com.sermon.mynote.repository.OrganizationRepository;
import com.sermon.mynote.service.OrganizationService;

@Service("organizationService")
@Repository
@Transactional
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Transactional(readOnly=true)
	public List<Organization> findChurchesByOrganization(){
		
		return Lists.newArrayList(organizationRepository.findChurchesByUser());
		
	}

}
