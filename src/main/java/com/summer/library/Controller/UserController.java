package com.summer.library.Controller;

import com.summer.library.Dao.UserDao;
import com.summer.library.Model.Book;
import com.summer.library.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserDao userDao;
    {
        try {
            userDao = new UserDao();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/Users")
    public boolean insertUser(@RequestBody User user){
        return userDao.insertUser(user);
    }

    @PutMapping("/Users")
    public boolean updateUser(@RequestParam int userId, @RequestParam int userContact){
        return userDao.update_User(userId,userContact);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@RequestParam int userId){
        if (userDao.delete_User(userId)){
            return "Delete successful";
        }else {
            return "Delete unsuccessful";
        }
    }

    @GetMapping("/{userId}")
    public User oneUser(@PathVariable int userId){
        return userDao.getUserInfo(userId);
    }

    @GetMapping("/Users")
    public ArrayList<User> showUser() {
        return userDao.show_User();
    }
}
