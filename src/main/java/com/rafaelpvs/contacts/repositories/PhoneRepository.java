package com.rafaelpvs.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelpvs.contacts.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
