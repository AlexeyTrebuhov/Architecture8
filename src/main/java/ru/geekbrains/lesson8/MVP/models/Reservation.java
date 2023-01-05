package ru.geekbrains.lesson8.MVP.models;

import java.util.Date;
public class Reservation {
    private static int counter;


    private int id; // уникальный номер резерва//
    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Reservation( Date date, String name) {

        //this.id = id;
        this.date = date;
        this.name = name;

    }

}

// тут все нормально.
