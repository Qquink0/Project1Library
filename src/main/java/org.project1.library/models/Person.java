package org.project1.library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int person_id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String person_name;
    @Min(value = 1900, message = "Age should be greater than 1900")
    private int person_year;

    public Person() {
    }

    public Person(int person_id, String person_name, int person_year) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_year = person_year;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public int getPerson_year() {
        return person_year;
    }

    public void setPerson_year(int person_year) {
        this.person_year = person_year;
    }
}
