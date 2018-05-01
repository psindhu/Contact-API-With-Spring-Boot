package com.solstice.api.contact.controller;


import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solstice.api.contact.entity.Contact;
import com.solstice.api.contact.service.ContactService;
 
@RestController
@RequestMapping("api")
public class ContactController {
 
    public static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    
 
    @Autowired
    ContactService contactService; 
 
    // -------------------Retrieve All Contacts---------------------------------------------
 
    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> listAllContacts() {
		logger.debug("-----------");
        List<Contact> users = contactService.findAllContacts();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contact>>(users, HttpStatus.OK);
    }
 
    
 
    // ------------------- Delete All Contacts-----------------------------
 
    @RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteAllContacts() {
        logger.info("Deleting All Users");
 
        contactService.deleteAllContacts();
        return new ResponseEntity<Contact>(HttpStatus.OK);
    }
    
 // ------------------- Delete By Contact ID-----------------------------
    
	@DeleteMapping("delete/{id}")
    public ResponseEntity<Contact> deleteContactByID(@PathVariable("id") Long id) {
        logger.info("Deleting Users by Id");
 
        contactService.deleteContactByID(id);
        return new ResponseEntity<Contact>(HttpStatus.OK);
    }
	
	@GetMapping("search/{value}")
    public ResponseEntity<List<Contact>> searchContactsByEmail(@PathVariable("value") String value) {
 
		Iterable<Contact> contacts =  contactService.searchContactsByEmailorPhone(value);
		List<Contact> contactList = new ArrayList<>();
		for (Contact contact : contacts) {
			contactList.add(contact);
		}
        return new ResponseEntity<List<Contact>>(contactList, HttpStatus.OK);
    }
 
	@GetMapping(value = "retrieve/{value}")
    public ResponseEntity<List<Contact>> searchContactsByCity(@PathVariable("value") String value) {
 
        Iterable<Contact> contacts = contactService.searchContactsByCityOrState(value);
        List<Contact> contactList = new ArrayList<>();
		for (Contact contact : contacts) {
			contactList.add(contact);
		}
        return new ResponseEntity<List<Contact>>(contactList, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Contact addContact(@RequestBody Contact contact) {
		System.out.println("In hererrr~~~~~~~~~~SS");
		contact = contactService.addContact(contact);
		return contact;
	}
	
	@GetMapping("contact/{id}")
	public Contact addContact(@PathVariable("id") String id) {
		System.out.println("In hererrr~~~~~~~~~~SS");
		Contact contact = contactService.getContactById(new Long(id));
		return contact;
	}
}