package ru.baib.iac.service;

import org.springframework.stereotype.Service;
import ru.baib.iac.model.Contact;
import ru.baib.iac.repository.ContactRepository;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void update(Contact contact) {
        contactRepository.update(contact);
    }

    public void delete(Integer id) {
        contactRepository.delete(id);
    }
}
