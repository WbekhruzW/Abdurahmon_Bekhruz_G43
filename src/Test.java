import uz.app.hotel.service.AdminService;
import uz.app.hotel.service.AdminServiseByAbdurahmon;

public class Test {
    public static void main(String[] args) {
        AdminServiseByAbdurahmon service = new AdminServiseByAbdurahmon();
        service.addHotel();
        service.showHotels();
        service.addHotel();
        service.showHotels();
    }
}
