package uz.app.hotel.database;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class DB {

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


}
