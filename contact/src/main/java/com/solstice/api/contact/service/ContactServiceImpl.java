package com.solstice.api.contact.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.assertj.core.internal.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.solstice.api.contact.controller.ContactController;
import com.solstice.api.contact.dao.IContactDAO;
import com.solstice.api.contact.entity.Contact;
import com.solstice.api.contact.repository.ContactRepository;


@Service("contactService")
public class ContactServiceImpl implements ContactService{
	
		
	@Autowired
	private IContactDAO contactDAO;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAllContacts() {
		return contactDAO.getAllContacts();
	}
	
	@Override
	public void deleteAllContacts(){
		contactDAO.deleteAllContacts();
	}

	@Override
	public void deleteContactByID(Long id) {
		contactDAO.deleteContactByID(id);
		
	}
	
	@Override
	public List<Contact> searchContactsByEmailorPhone(String value) {
		Iterable<Contact> list = contactRepository.searchContactsByEmailorPhone("%" + value.trim().replace(" ", "%") + "%");
		List<Contact> contacts = new ArrayList<>();
		for (Contact contact : list) {
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public List<Contact> searchContactsByCityOrState(String value) {
		Iterable<Contact> list = contactRepository.searchContactsByCityOrState("%" + value.trim().replace(" ", "%") + "%");
		List<Contact> contacts = new ArrayList<>();
		for (Contact contact : list) {
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public Contact addContact(Contact contact) {
		contact = contactRepository.save(contact);
		return contact;
				
	}
	
	@Override
	public Contact getContactById(Long id) {
		Optional<Contact> list = contactRepository.findById(id);
		return list.get();
	}

}
