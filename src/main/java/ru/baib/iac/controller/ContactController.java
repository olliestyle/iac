package ru.baib.iac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baib.iac.dto.ContactDateDTO;
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
    public List<ContactDateDTO> findAll() {
        return contactService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ContactDateDTO> create(@RequestBody ContactDateDTO contactDateDTO) {
        return new ResponseEntity<>(
                contactService.save(contactDateDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody ContactDateDTO contactDateDTO) {
        contactService.update(contactDateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }

}
