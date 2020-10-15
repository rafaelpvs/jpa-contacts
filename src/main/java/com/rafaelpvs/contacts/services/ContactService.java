package com.rafaelpvs.contacts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelpvs.contacts.entities.Contact;
import com.rafaelpvs.contacts.repositories.ContactRepository;
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
}
