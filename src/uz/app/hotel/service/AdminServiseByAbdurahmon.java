package uz.app.hotel.service;

import uz.app.hotel.Util;
import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Location;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class AdminServiseByAbdurahmon implements AdminService
{
    static DB database = DB.getInstance();



    @Override
    public void service() {

    }

    @Override
    public void addHotel() {
        Hotel hotel = new Hotel();
        Hotel hotel1 = editAndAdd(hotel);
        if(hotel1 == null) {
            return;
        }
        database.hotels.add(hotel1);
        System.out.println("New hotel added !");
    }

    @Override
    public void showHotel() {
        String id = Util.getLine("Enter hotel id = >");
        Hotel hotel = database.show(id);
        System.out.println(hotel);
    }

    @Override
    public void showHotels() {
        database.showAll().forEach((hotel) -> System.out.println(hotel));
    }

    @Override
    public void editHotel() {

    }

    @Override
    public void deleteHotel() {

    }

    @Override
    public void showUsers() {

    }

    @Override
    public void showReservationHistory() {

    }

    @Override
    public void calcelReservation() {

    }

    @Override
    public void reserveForUser() {

    }

    public Hotel editAndAdd(Hotel hotel) {
        String name = Util.getLine("Enter hotel name = >");
        Location[] locations = Location.values();
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i+1) + ") " + locations[i]);
        }
        int index = Util.getInt("Enter location = >")-1;
        try{
            Objects.checkIndex(index,locations.length);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect index ");
            return null;
        }
        Location location = locations[index];
        int floors = Util.getInt("Enter floors = > ");
        int roomCount = Util.getInt("Enter room count = >");

        hotel = new Hotel(name,location,floors,roomCount);
        return hotel;
    }
}
