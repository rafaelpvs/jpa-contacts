package com.rafaelpvs.contacts.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafaelpvs.contacts.entities.Contact;
import com.rafaelpvs.contacts.entities.Email;
import com.rafaelpvs.contacts.entities.Phone;
import com.rafaelpvs.contacts.entities.enums.Hierarchy;
import com.rafaelpvs.contacts.entities.enums.Marker;
import com.rafaelpvs.contacts.repositories.ContactRepository;
import com.rafaelpvs.contacts.repositories.EmailRepository;
import com.rafaelpvs.contacts.repositories.PhoneRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private EmailRepository emailRepository;
 	
	@Override
	public void run(String... args) throws Exception {
		Contact cont1 = new Contact(null, "Fulado de Tal", "99999999999");
		Contact cont2 = new Contact(null, "Sicrano de Tal", "88888888888");
		
		Phone phon1 = new Phone(null, "55", "71", "999999999", Hierarchy.PRIMARY,  Marker.CELLPHONE, cont1);
		Phone phon2 = new Phone(null, "55", "71", "888888888", Hierarchy.SECONDARY,  Marker.RESIDENTIAL, cont1);
		Phone phon3 = new Phone(null, "55", "71", "888888888", Hierarchy.PRIMARY,  Marker.CELLPHONE, cont2);
		Phone phon4 = new Phone(null, "55", "71", "888888888", Hierarchy.SECONDARY,  Marker.WORK, cont2);
		Phone phon5 = new Phone(null, "55", "71", "888888888", Hierarchy.SECONDARY,  Marker.RESIDENTIAL, cont2);
		
		Email email1  = new Email(null, "fulano_tal@gmail.com", Hierarchy.PRIMARY, cont1);
		Email email2  = new Email(null, "fulano_tal@hotmail.com", Hierarchy.SECONDARY, cont1);
		Email email3  = new Email(null, "sicrano_tal@gmail.com", Hierarchy.PRIMARY, cont2);
		Email email4  = new Email(null, "sicrano_tal@hotmail.com", Hierarchy.SECONDARY, cont2);
		contactRepository.saveAll(Arrays.asList(cont1, cont2));
		phoneRepository.saveAll(Arrays.asList(phon1, phon2, phon3, phon4, phon5));
		emailRepository.saveAll(Arrays.asList(email1, email2, email3, email4));
		
	}

}
