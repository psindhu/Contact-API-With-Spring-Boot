package com.solstice.api.contact.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.solstice.api.contact.entity.Contact;

public interface IContactDAO {
    List<Contact> getAllContacts();
    void deleteAllContacts();
    void deleteContactByID(Long id);

} 
