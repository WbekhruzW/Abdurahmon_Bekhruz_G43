import uz.app.hotel.Util;
import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Role;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AuthService;
import uz.app.hotel.service.UserServiceByBekhruz;

import java.util.Objects;

public class Test implements AuthService {
    public static void main(String[] args) {
        
    }
    public DB db = DB.getInstance();
    @Override
    public void signUp() {
        String name = Util.getLine("Ismingizni kiriting: ");
        String pass = Util.getLine("Password kirit");
        User user  = new User(name,Util.getLine("Username:"),pass,roleManage(name,pass));
        db.currentUser = user;
        db.users.add(user);
        System.out.println("Tabrikliman sign up qldin");
        if (user.getRole() == Role.USER){
            UserServiceByBekhruz bekhruz = UserServiceByBekhruz.service1();
            bekhruz.main();
        }
    }
    private Role roleManage(String username,String pass){
        if (Objects.equals(username, "admin") && Objects.equals(pass,"admin")){
            return Role.ADMIN;
        }
        return Role.USER;
    }

    @Override
    public void Login() {
        String name = Util.getLine("Ismingizni kiriting: ");
        String pass = Util.getLine("Password kirit");
        for (int i = 0; i < db.users.size(); i++) {
            if (Objects.equals(db.users.get(i).getName(), name) && Objects.equals(db.users.get(i).getPassword(), pass)){
                db.currentUser = db.users.get(i);
                if (db.users.get(i).getRole() == Role.USER){
                    UserServiceByBekhruz bekhruz = UserServiceByBekhruz.service1();
                    bekhruz.main();
                }
                else {

                }
            }
        }
    }
}
