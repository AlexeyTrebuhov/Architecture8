package ru.geekbrains.lesson8.MVP.views;

import ru.geekbrains.lesson8.MVP.models.Table;
import ru.geekbrains.lesson8.MVP.presenters.View;
import ru.geekbrains.lesson8.MVP.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * @param tables столики
     */
    public void showTables(Collection<Table> tables){
        for (Table table: tables){
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие пользователя (пользователь нажал на кнопку бронирования), бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){  //метод резервирования столика
        observer.onReservationTable(reservationDate, tableNo, name); // наблюдатель вызывает на себе метод onReservationTable
    }

    public void printReservationTableResult(int reservationNo){
        System.out.printf("Столик успешно забронирован. Номер вашей брони #%d\n", reservationNo);
    }


    /**
     * Действие пользователя (пользователь нажал на кнопку ОТМЕНЫ бронирования), снятие бронирования столика
     * TODO: ДОМАШНЯЯ РАБОТА: Доработать метод changeReservationTable, протянуть возможность изменения
     * резерва столика на уровне компонент BookingPresenter и BookingModel
     * @param reservationDate дата, которую нужно разбронировать
     * @param tableNo номер столика, который нужно разбронировать
     * @param name имя, на которое был забронирован столик
     */


    // метод снятия резерва. Здесь oldReservation = reservationNo ( клиент уже имеет номер, который нужно отменить)
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){ //метод отмены резервирования столика
        observer.onChangeReservationTable(oldReservation,reservationDate,tableNo, name);  // наблюдатель вызывает на себе метод onChangeReservationTable
    }

    public void printChangeReservationTableResult(int changeReservationNo){
        System.out.println("Столик разбронирован. ID снятого резерва " + changeReservationNo + ". Надеемся на новый заказ\n");

    }
}
// тут все нормально