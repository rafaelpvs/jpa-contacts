package com.rafaelpvs.contacts.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpvs.contacts.entities.Phone;
import com.rafaelpvs.contacts.repositories.PhoneRepository;
import com.rafaelpvs.contacts.services.exceptions.DatabaseException;
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
	public Phone insert(Phone obj) {
		repository.save(obj);
		return obj;
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Phone update(Long id, Phone obj) {
		
		try {			
			Phone entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Phone entity, Phone obj) {
		entity.setDdi(obj.getDdi());
		entity.setDdd(obj.getDdd());
		entity.setContact(obj.getContact());
		entity.setNumber(obj.getNumber());
		entity.setHierarchy(obj.getHierarchy());
		entity.setMarker(obj.getMarker());
	}
}
