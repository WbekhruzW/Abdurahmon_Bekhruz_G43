package uz.app.hotel.service;

public interface UserService {
    UserServiceByBekhruz service();
    void showHotels();
    void showReservations();
    void reserve();
    void cancelReservation();
    void rescheduleReservation();
    void showHistory();
}
