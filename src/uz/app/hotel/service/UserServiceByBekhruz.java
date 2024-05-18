package uz.app.hotel.service;

import uz.app.hotel.Util;
import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.Role;

import java.time.LocalDate;

public class UserServiceByBekhruz implements UserService{
    DB database = DB.getInstance();
    public  void main(){
        while (true){
            switch (Util.getInt("""
                1.showHotels
                2.showReservation
                3.reserve
                4.cancelReservation
                5.reshouldReservation
                6.ShowHistory
                """)){
                case 1->{showHotels();}
                case 2->{showReservations();}
                case 3->{reserve();}
                case 4->{cancelReservation();}
                case 5->{rescheduleReservation();}
                case 6->{showHistory();}
                default -> {
                    System.out.println("Error");
                    return;
                }
            }
        }
    }
    private static UserServiceByBekhruz userServiceByBekhruz;
    @Override
    public UserServiceByBekhruz service() {
        return null;
    }
    public static UserServiceByBekhruz service1() {
        if (userServiceByBekhruz == null)
            userServiceByBekhruz= new UserServiceByBekhruz();
        return userServiceByBekhruz;
    }

    @Override
    public boolean showHotels() {
        if (database.hotels.isEmpty()){
            System.out.println("Uzur lekn hali Hotella yoq!");
            return true;
        }
        int i = 1;
        for (Hotel h : database.hotels) {
            System.out.println(i + ". " + h);
            i++;
        }
        return false;
    }

    @Override
    public void showReservations() {
        if (database.reservations.isEmpty()){
            System.out.println("Uzur lekn hali Hotella yoq!");
        }
        int i = 1;
        for (Reservation h : database.reservations) {
            System.out.println(i + ". " + h);
            i++;
        }
    }


    @Override
    public void reserve() {
        if (showHotels()){
            return;
        }
        Hotel hotel = database.hotels.get(Util.getInt("Qaysi hotelda qomoxchisiz?"));
        Reservation reservation = new Reservation(database.currentUser,hotel,Util.getInt(hotel.getFloors() + "Qaysi floorda?"),Util.getInt(hotel.getRoomsCount() + "Qaysi roomda?"),LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon kelasan?")),LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon ketasan?")));
        database.reservations.add(reservation);
        System.out.println("Sani hotelimizda kutb qolamz)");
    }

    @Override
    public void cancelReservation() {
        for (int i = 0; i < database.reservations.size(); i++) {
            if (database.reservations.get(i).getUser() == database.currentUser){
                System.out.println(i + ". " + database.reservations.get(i));
            }
            else {
                System.out.println("San hali hotelga yozilmagansan. nimani cancel qimoxchisan?");
            }
            database.reservations.remove(Util.getInt("Qaysi birini cancel qlasan?"));
            System.out.println("Tabrikliman cancel qldin");
        }
    }

    @Override
    public void rescheduleReservation() {
        if (database.reservations.isEmpty()){
            return;
        }
        if (database.currentUser.getRole() == Role.USER) {
            for (int i = 0; i < database.reservations.size(); i++) {
                if (database.reservations.get(i).getUser() == database.currentUser) {
                    System.out.println(i + ". " + database.reservations.get(i));
                } else {
                    System.out.println("San hali hotelga yozilmagansan. nimani ozgartirmoxchisan qimoxchisan?");
                }
            }
            Reservation res = database.reservations.get(Util.getInt("Qaysi birini reshule qlasan?"));
            if (res.isReshuled()){
                System.out.println("Siz uje buni reshould qibogansz!");
                return;
            }
            res.setStartDate(LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon kelasan?")));
            res.setEndDate(LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon ketasan?")));
            res.setReshuled(true);
            System.out.println("Tabrikliman reshould qildiz qldin");
        }if (database.currentUser.getRole() == Role.ADMIN) {
            for (int i = 0; i < database.reservations.size(); i++) {
                System.out.println(i + ". " + database.reservations.get(i));
            }
            Reservation res = database.reservations.get(Util.getInt("Qaysi birini reshule qlasan?"));
            res.setStartDate(LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon kelasan?")));
            res.setEndDate(LocalDate.parse(Util.getLine("Data ni '0000-00-00' tarzda kiriting || Qachon ketasan?")));
            System.out.println("Tabrikliman reshould qildiz qldin");
        }
    }

    @Override
    public void showHistory() {
        showReservations();
    }
}