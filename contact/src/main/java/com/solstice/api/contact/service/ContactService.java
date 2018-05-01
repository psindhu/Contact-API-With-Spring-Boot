package com.solstice.api.contact.service;

import java.util.List;

import com.solstice.api.contact.entity.Contact;

public interface ContactService {
	
	
	List<Contact> findAllContacts();
	
	void deleteAllContacts();
	
	void deleteContactByID(Long id);
	
	Contact addContact(Contact contact);
	
	Contact getContactById(Long id);
	
	Iterable<Contact> searchContactsByEmailorPhone(String value);
	
	Iterable<Contact> searchContactsByCityOrState(String value);

	
}