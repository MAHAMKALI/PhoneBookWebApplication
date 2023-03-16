package com.iThelp.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iThelp.phonebook.Entities.Contact;
import com.iThelp.phonebook.service.ContactService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@ApiOperation("This operation is used to store new contact")
	@PostMapping("/save")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
		Contact contact1 = contactService.addContact(contact);
		return new ResponseEntity<>(contact1,HttpStatus.CREATED);
	}
	
	@ApiOperation("This operation is used to get contact using id")
	@GetMapping("/contact")
	public ResponseEntity<Contact> getContact(@RequestParam("id") String id){
		Contact contact = contactService.getContact(Integer.parseInt(id));
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	@ApiOperation("This operation is used to get all contacts")
	@GetMapping("/all")
	public ResponseEntity<List<Contact>> allContacts(){
		return new ResponseEntity<>(
				contactService.getAllContacts(),
				HttpStatus.OK
				);
	}
	
	@ApiOperation("This operation is used to update existing contact")
	@PutMapping("/update")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		
		return new ResponseEntity<>(
				contactService.updateContact(contact),
				HttpStatus.OK
				);
	}
	
	@ApiOperation("This operation is used to delete contact using id")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") String id){
		
		return new ResponseEntity<>(
				contactService.deleteContact(Integer.parseInt(id)),
				HttpStatus.OK
				);
	}
}
