package com.microservice.fibonicci.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fiboniccis")
public class Fibonicci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int frequent;
    private String result;

    public Fibonicci() {
    }

    public Fibonicci(int id, int number, String result, int frequent) {

        this.id = id;
        this.number = number;
        this.result = result;
        this.frequent = frequent;
    }

    public int getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getFrequent() {
        return this.frequent;
    }

    public void setFrequent(int frequent) {
        this.frequent = frequent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.result);
        hash = 79 * hash + Objects.hashCode(this.frequent);
        hash = 79 * hash + this.number;
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fibonicci{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", result=").append(result);
        sb.append(", frequent=").append(frequent);
        sb.append('}');
        return sb.toString();
    }
}