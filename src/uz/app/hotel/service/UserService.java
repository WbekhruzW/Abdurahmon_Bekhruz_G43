package uz.app.hotel.service;

public interface UserService {
    UserServiceByBekhruz service();
    boolean showHotels();
    void showReservations();
    void reserve();
    void cancelReservation();
    void rescheduleReservation();
    void showHistory();
}
