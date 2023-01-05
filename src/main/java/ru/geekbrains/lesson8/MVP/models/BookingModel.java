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
     * ������������ �������
     *
     * @param reservationDate ���� ������������
     * @param tableNo         ����� �������
     * @param name            ���
     * @return ����� ������������
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {        //����� ��������������
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findAny();
        if (table.isPresent()) {                                                 // ���� ������ ������ ���������
            Reservation reservation = new Reservation(reservationDate, name);    // ����� ������ ��������������
            table.get().getReservations().add(reservation);// ��������� � ��������� �������� ������� ��������������
            return reservation.getId();                                 //����� ���������� ������� ����� �������
        }
        throw new RuntimeException("������������ ����� �������.");
    }

    /**
     * ������ ������������ �������
     *
     * @param oldReservation  ����� ������� ��� ������
     * @param reservationDate ���� ������������
     * @param tableNo         ����� �������
     * @param name            ���
     * @return ����� ���������������
     */

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) { //����� ������ �������

/*
        if (oldReservation == reservationNo) {                                      // ���� ��������� ����� ������� ��������� � ���������
        reservations.remove(reservations.toArray()[oldReservations]);              // ������� ��������� ������ �� ������ �������� (�� �������)
        return oldReservation;                                                    //����� ���������� ����� ������� �������
        }
        */
         throw new RuntimeException("������������ ����� ������.");              //��� �� ������ ���� ������ ������� ��� � ������
    }


}
