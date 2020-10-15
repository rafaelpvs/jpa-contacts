package com.rafaelpvs.contacts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelpvs.contacts.entities.Phone;
import com.rafaelpvs.contacts.repositories.PhoneRepository;
import com.rafaelpvs.contacts.services.exceptions.ResourceNotFoundException;
@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository repository;
	
	public List<Phone> findAll(){
		return repository.findAll();
	}
	
	public Phone findById(Long id) {
		Optional<Phone> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
