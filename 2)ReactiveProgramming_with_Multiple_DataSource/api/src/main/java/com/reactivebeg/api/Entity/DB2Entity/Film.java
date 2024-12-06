package com.reactivebeg.api.Entity.DB2Entity;

import org.springframework.data.annotation.Id;

public class Film {

    @Id
    private Integer id;
    private String filmname;
    private Integer year;

    public Film() {
    }

    public Film(Integer id, String filmname, Integer year) {
        this.id = id;
        this.filmname = filmname;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
