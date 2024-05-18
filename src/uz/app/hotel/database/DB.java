package uz.app.hotel.database;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AdminService;
import uz.app.hotel.service.AdminServiseByAbdurahmon;
import uz.app.hotel.service.HotelService;
import uz.app.hotel.service.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DB implements HotelService, ReservationService {

    public List<Hotel> hotels = new ArrayList<>();
    public List<Reservation> reservations = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    public User currentUser;
  
    private static DB db ;
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }


    @Override
    public void add(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override
    public Hotel show(String id) {
        for (Hotel hotel : hotels) {
            if(hotel.getId().equals(id)) return hotel;
        }
        return null;
    }

    @Override
    public List<Hotel> showAll() {
        return hotels;
    }

    @Override
    public boolean edit(String id, Hotel hotel) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        reservations.add(reservation);
        return true;
    }

    @Override
    public Reservation showReservation(String id) {
        return null;
    }

    @Override
    public List<Reservation> showReservationByUser(String id) {
        return List.of();
    }

    @Override
    public List<Reservation> showReservationByHotel(String id) {
        return List.of();
    }

    @Override
    public boolean cancelReservation(String id) {
        return false;
    }

    @Override
    public boolean finishReservation(String id, LocalDate date) {
        return false;
    }

    @Override
    public boolean rescheduleReservation(String id, LocalDate from, LocalDate to) {
        return false;
    }
}
