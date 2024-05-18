package uz.app.hotel.service;

import uz.app.hotel.database.DB;

public class UserServiceByBekhruz implements UserService{
    DB database = DB.getInstance();
    @Override
    public void service() {

    }

    @Override
    public void showHotels() {
        if (database.hotels.isEmpty()){

        }
    }

    @Override
    public void showReservations() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancelReservation() {

    }

    @Override
    public void rescheduleReservation() {

    }

    @Override
    public void showHistory() {

    }
}
