package com.laptevn;

public class Bank {
    private long id;
    private String name;

    public Bank() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Bank{id=%s, name='%s'}", id, name);
    }
}