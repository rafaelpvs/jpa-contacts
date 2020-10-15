package com.rafaelpvs.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelpvs.contacts.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
