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

import com.rafaelpvs.contacts.entities.Phone;
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
	
	@PostMapping
	public ResponseEntity<Phone> insert(@RequestBody Phone obj){
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
	public ResponseEntity<Phone> update(@PathVariable Long id,@RequestBody Phone obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
