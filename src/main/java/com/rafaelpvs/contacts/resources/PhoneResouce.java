package com.rafaelpvs.contacts.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpvs.contacts.entities.Phone;
import com.rafaelpvs.contacts.services.PhoneService;


@RestController
@RequestMapping("/phones")
public class PhoneResouce {
	
	@Autowired
	private PhoneService service;
	
	@GetMapping
	public ResponseEntity<List<Phone>> findAll(){
		List<Phone> phones = service.findAll();
		return ResponseEntity.ok().body(phones);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Phone> findById(@PathVariable Long id) {
		Phone phone = service.findById(id);
		return ResponseEntity.ok().body(phone);
	}
	
}
