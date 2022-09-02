package ru.baib.iac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baib.iac.model.Contact;
import ru.baib.iac.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        return new ResponseEntity<>(
                contactService.save(contact),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Contact contact) {
        contactService.update(contact);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }

}
