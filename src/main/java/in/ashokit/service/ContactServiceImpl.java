package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entity.Contact;
import in.ashokit.reposiotory.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(ContactForm contactForm) {
		Contact entity = new Contact();
		BeanUtils.copyProperties(contactForm, entity);
		entity.setActiveSw("Y");
		Contact contact = contactRepository.save(entity);
		if (contact != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> findAllContacts() {
		List<ContactForm> formList = new ArrayList<>();
		List<Contact> entityList = contactRepository.findAll();
		for(Contact entity : entityList) {
			ContactForm formObj = new ContactForm();
			BeanUtils.copyProperties(entity, formObj);
			formList.add(formObj);
		}
		return formList;
	}

	@Override
	public ContactForm editContact(Integer id) {
		
		Optional<Contact> findById = contactRepository.findById(id);
		if(findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm formObj = new ContactForm();
			BeanUtils.copyProperties(entity, formObj);
			return formObj;
		}
		
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer id) {
		contactRepository.deleteById(id);
//		return findAllContacts();
		
		List<ContactForm> formList = new ArrayList<>();
		List<Contact> entityList = contactRepository.findAll();
		for(Contact entity : entityList) {
			ContactForm formObj = new ContactForm();
			BeanUtils.copyProperties(entity, formObj);
			formList.add(formObj);
		}
		return formList;
		
	}

}
