package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.ContactForm;

public interface ContactService {
	
	public String saveContact(ContactForm contactForm);
	
	public List<ContactForm> findAllContacts();
	
	public ContactForm editContact(Integer id);
	
	public List<ContactForm> deleteContact(Integer id);

	
}
