package com.solstice.api.contact.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.solstice.api.contact.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	List<Contact> searchContactsByEmailorPhone(@Param("value") String value);

	List<Contact> searchContactsByCityOrState(@Param("value") String value);

}
