package ru.baib.iac.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Contact {

    private Integer id;
    private String name;
    private String number;
    private LocalDateTime created;

    public Contact() {

    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String name, String number, LocalDateTime created) {
        this.name = name;
        this.number = number;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id)
                && Objects.equals(name, contact.name)
                && Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name='" + name + '\'' + ", number='"
                + number + '\'' + ", created=" + created + '}';
    }
}
