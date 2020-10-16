package com.rafaelpvs.contacts.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpvs.contacts.entities.Contact;
import com.rafaelpvs.contacts.repositories.ContactRepository;
import com.rafaelpvs.contacts.services.exceptions.DatabaseException;
import com.rafaelpvs.contacts.services.exceptions.ResourceNotFoundException;
@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repository;
	
	public List<Contact> findAll(){
		return repository.findAll();
	}
	
	public Contact findById(Long id) {
		Optional<Contact> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Contact insert(Contact obj) {
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
	
	public Contact update(Long id, Contact obj) {
		
		try {			
			Contact entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Contact entity, Contact obj) {
		entity.setName(obj.getName());
		entity.setSobre_nome(obj.getSobre_nome());
	}
}
