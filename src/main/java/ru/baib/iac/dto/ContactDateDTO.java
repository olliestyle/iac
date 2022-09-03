package ru.baib.iac.dto;

public class ContactDateDTO {

    private Integer id;
    private String name;
    private String number;
    private String created;

    public ContactDateDTO() {
    }

    public ContactDateDTO(Integer id, String name, String number, String created) {
        this.id = id;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
