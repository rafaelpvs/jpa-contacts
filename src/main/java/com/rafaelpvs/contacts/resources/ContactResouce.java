package com.rafaelpvs.contacts.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		Contact obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Contact> insert(@RequestBody Contact obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contact> update(@PathVariable Long id,@RequestBody Contact obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
