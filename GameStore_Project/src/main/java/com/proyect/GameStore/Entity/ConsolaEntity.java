package com.proyect.GameStore.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="consola")
public class ConsolaEntity {

    @Id
    private Integer console_id;

    private String name;

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

