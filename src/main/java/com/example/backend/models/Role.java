package com.example.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    public enum Type { JAILOR, TOWN_INVESTIGATIVE, TOWN_KILLING, TOWN_PROTECTIVE, GODFATHER, MAFIOSO, TOWN_SUPPORT, RANDOM_MAFIA, NEUTRAL_EVIL, NEUTRAL_KILLING; }

    @Id
    String name;

    Type type;

    public Role(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}