package ru.geekbrains.lesson8.MVP.presenters;

import ru.geekbrains.lesson8.MVP.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получить список всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) { // метод имплементирован из ViewObserver
        int reservationNo = model.reservationTable(reservationDate, tableNo, name); // получаем и сохраняем номер резерва
        printReservationTableResult(reservationNo);

    }
    protected void printReservationTableResult(int reservationNo){ // в метод передаем номер резерва
        view.printReservationTableResult(reservationNo); // печать номера резерва (метод для передачи в BoockingView)
    }

       @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) { // метод имплементирован из ViewObserver
        int changeReservationTableNo = oldReservation;                 // получаем и сохраняем номер резерва ( он же oldReservation)
        printChangeReservationTableResult(changeReservationTableNo);
    }
    protected void printChangeReservationTableResult(int changeReservationNo){    // в метод передаем номер отменяемого резерва
        view.printChangeReservationTableResult(changeReservationNo);   // печать номера отменяемого резерва (метод для передачи в BoockingView)
    }

}
// тут все нормально