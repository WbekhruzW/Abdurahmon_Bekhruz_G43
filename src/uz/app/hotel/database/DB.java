package uz.app.hotel.database;

import uz.app.hotel.service.AdminService;

import java.util.List;

public class DB {
    private static DB db ;
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }


}
