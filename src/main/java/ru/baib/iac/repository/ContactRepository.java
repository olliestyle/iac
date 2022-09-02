package ru.baib.iac.repository;

import ru.baib.iac.model.Contact;

import java.util.List;

public interface ContactRepository {

    Contact save(Contact contact);
    List<Contact> findAll();
    void update(Contact contact);
    void delete(Integer id);
}
