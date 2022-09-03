package ru.baib.iac.service;

import org.springframework.stereotype.Service;
import ru.baib.iac.dto.ContactDateDTO;
import ru.baib.iac.repository.ContactRepository;
import ru.baib.iac.util.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final Mapper mapper;

    public ContactServiceImpl(ContactRepository contactRepository, Mapper mapper) {
        this.contactRepository = contactRepository;
        this.mapper = mapper;
    }

    public ContactDateDTO save(ContactDateDTO contactDateDTO) {
        return mapper.toContactDateDTO(contactRepository.save(mapper.toContact(contactDateDTO)));
    }

    public List<ContactDateDTO> findAll() {
        return contactRepository.findAll().stream().map(mapper::toContactDateDTO).collect(Collectors.toList());
    }

    public void update(ContactDateDTO contactDateDTO) {
        contactRepository.update(mapper.toContact(contactDateDTO));
    }

    public void delete(Integer id) {
        contactRepository.delete(id);
    }
}
