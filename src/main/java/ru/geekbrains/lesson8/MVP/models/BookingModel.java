package ru.geekbrains.lesson8.MVP.models;

import ru.geekbrains.lesson8.MVP.presenters.Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }


    /**
     * Ѕронирование столика
     *
     * @param reservationDate дата бронировани€
     * @param tableNo         номер столика
     * @param name            им€
     * @return номер бронировани€
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {        //ћетод резервировани€
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findAny();
        if (table.isPresent()) {                                                 // если столик указан корректно
            Reservation reservation = new Reservation(reservationDate, name);    // новый объект резервировани€
            table.get().getReservations().add(reservation);// добавл€ем в коллекцию резервов текущее резервирование
            return reservation.getId();                                 //метод возвращает клиенту номер резерва
        }
        throw new RuntimeException("Ќекорректный номер столика.");
    }

    /**
     * —н€тие бронировани€ столика
     *
     * @param oldReservation  номер резерва дл€ сн€ти€
     * @param reservationDate дата бронировани€
     * @param tableNo         номер столика
     * @param name            им€
     * @return номер разбронировани€
     */

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) { //ћетод сн€ти€ резерва

/*
        if (oldReservation == reservationNo) {                                      // если снимаемый номер резерва совпадает с имеющимс€
        reservations.remove(reservations.toArray()[oldReservations]);              // удал€ем выбранный резерв из списка резервов (по индексу)
        return oldReservation;                                                    //метод возвращает номер сн€того резерва
        }
        */
         throw new RuntimeException("Ќекорректный номер заказа.");              //это на случай если номера резерва нет в списке
    }


}
