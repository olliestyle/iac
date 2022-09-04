package ru.baib.iac.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContactDateDTO {

    private Integer id;
    @NotNull(message = "field name mustn't be null")
    @NotBlank(message = "field name mustn't be blank")
    private String name;
    @NotNull(message = "field number mustn't be null")
    @NotBlank(message = "field number mustn't be blank")
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
