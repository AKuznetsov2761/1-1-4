package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Nicola","Miyatovich",(byte) 52);
        userService.saveUser("Mike","Joker",(byte) 31);
        userService.saveUser("Nelli","Vetrova",(byte) 17);
        userService.saveUser("Svetlana","Gordeeva",(byte) 37);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
