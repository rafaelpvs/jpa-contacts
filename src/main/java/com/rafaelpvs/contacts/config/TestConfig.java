package com.rafaelpvs.contacts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafaelpvs.contacts.entities.Contact;
import com.rafaelpvs.contacts.entities.Phone;
import com.rafaelpvs.contacts.repositories.ContactRepository;
import com.rafaelpvs.contacts.repositories.PhoneRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Contact cont1 = new Contact(null, "Fulado de Tal", "99999999999");
		Contact cont2 = new Contact(null, "Sicrano de Tal", "88888888888");
		
		
		Phone phon1 = new Phone(null, "55", "71", "999999999", 1,  1, cont1);
		
		contactRepository.saveAll(Arrays.asList(cont1, cont2));
		phoneRepository.save(phon1);
	}

}
