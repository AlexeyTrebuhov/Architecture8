package ru.geekbrains.lesson8.MVP.presenters;

import ru.geekbrains.lesson8.MVP.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     * @return номер бронирования
     */
    int reservationTable (Date reservationDate, int tableNo, String name);

    /**
     * Разбронирование столика
     *
     * @param oldReservation  номер для разбронирования ( сравниваем с reservationNo)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя
     * @return номер бронирования
     */
    int changeReservationTable (int oldReservation, Date reservationDate, int tableNo, String name);
}
 // Тут все нормально