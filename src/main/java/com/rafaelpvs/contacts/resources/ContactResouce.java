package com.rafaelpvs.contacts.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpvs.contacts.entities.Contact;
import com.rafaelpvs.contacts.services.ContactService;


@RestController
@RequestMapping("/contacts")
public class ContactResouce {
	
	@Autowired
	private ContactService service;
	
	@GetMapping
	public ResponseEntity<List<Contact>> findAll(){
		List<Contact> contacts = service.findAll();
		return ResponseEntity.ok().body(contacts);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Contact> findById(@PathVariable Long id) {
		Contact contact = service.findById(id);
		return ResponseEntity.ok().body(contact);
	}
	
}
