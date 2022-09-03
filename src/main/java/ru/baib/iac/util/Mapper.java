package ru.baib.iac.util;

import org.springframework.stereotype.Component;
import ru.baib.iac.dto.ContactDateDTO;
import ru.baib.iac.model.Contact;

import java.time.format.DateTimeFormatter;

@Component
public class Mapper {

    public ContactDateDTO toContactDateDTO(Contact contact) {
        ContactDateDTO contactDateDTO = new ContactDateDTO();
        contactDateDTO.setId(contact.getId());
        contactDateDTO.setName(contact.getName());
        contactDateDTO.setNumber(contact.getNumber());
        contactDateDTO.setCreated(contact.getCreated().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
        return contactDateDTO;
    }

    public Contact toContact(ContactDateDTO contactDateDTO) {
        Contact contact = new Contact();
        contact.setName(contactDateDTO.getName());
        contact.setNumber(contactDateDTO.getNumber());
        return contact;
    }
}
