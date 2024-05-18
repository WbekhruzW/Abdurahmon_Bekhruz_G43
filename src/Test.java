
import uz.app.hotel.Util;
import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Role;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AuthService;
import uz.app.hotel.service.UserServiceByBekhruz;

import java.util.Objects;

public class Test implements AuthService {
    public static void main(String[] args) {
        User user = new User("admin","admin","admin",Role.ADMIN);
        DB.getInstance().users.add(user);
        while (true){
            switch (Util.getInt("""
                    1.signUp
                    2.LogIn
                    """)){
                case 1->Test.service1().signUp();
                case 2->Test.service1().Login();
            }
        }
    }
    public DB db = DB.getInstance();
    @Override
    public void signUp() {
        String name = Util.getLine("Ismingizni kiriting: ");
        String pass = Util.getLine("Password kirit");
        User user  = new User(name,Util.getLine("Username:"),pass,Role.USER);
        db.currentUser = user;
        db.users.add(user);
        System.out.println("Tabrikliman sign up qldin");
    }

    @Override
    public void Login() {
        String name = Util.getLine("Ismingizni kiriting: ");
        String pass = Util.getLine("Password kirit");
        for (int i = 0; i < db.users.size(); i++) {
            if (Objects.equals(db.users.get(i).getName(), name) && Objects.equals(db.users.get(i).getPassword(), pass)){
                db.currentUser = db.users.get(i);
                if (db.currentUser.getRole() == Role.USER){
                    UserServiceByBekhruz bekhruz = UserServiceByBekhruz.service1();
                    bekhruz.main();
                }
                else {

                }
            }
        }
    }
    private static Test test;
    public static Test service1() {
        if (test == null)
            test= new Test();
        return test;
    }
}
