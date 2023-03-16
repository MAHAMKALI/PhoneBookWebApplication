package com.iThelp.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iThelp.phonebook.Entities.Contact;
import com.iThelp.phonebook.repositories.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo repo;
	
	public Contact addContact(Contact contact) {
		contact.setActiveSw("Y");
		return repo.save(contact);
	}
	
	public List<Contact> getAllContacts(){
		
		return repo.findByActiveSw("Y");
	}
	
	public Contact getContact(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}
	
	public String updateContact(Contact contact) {
		if(repo.findById(contact.getId()).isPresent()) {
			contact.setActiveSw("Y");
			repo.save(contact);
			return "Record has updated";
		}
		return "No record found to update";
	}
	
	public String deleteContact(int id) {
		if(repo.findById(id).isPresent()) {
			Contact contact = repo.findById(id).get();
			contact.setActiveSw("N");
			repo.save(contact);
			return "Contact has deleted";
		}
		return "No record found to delete";
	}
}
