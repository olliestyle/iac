package ru.baib.iac.service;

import ru.baib.iac.dto.ContactDateDTO;
import ru.baib.iac.model.Contact;

import java.util.List;

public interface ContactService {

    ContactDateDTO save(ContactDateDTO contactDateDTO);
    List<ContactDateDTO> findAll();
    void update(ContactDateDTO contactDateDTO);
    void delete(Integer id);
}
