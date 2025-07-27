package com.summer.library.Dao;

import com.summer.library.Model.Book;
import com.summer.library.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private Connection conn;

    public ArrayList<User> show_User() {
        ArrayList<User> userlist = new ArrayList<>();
        try{
            conn= com.summer.library.Dao.DatabaseConnection.connect();
            String query = "SELECT userId, userName, userContact FROM user";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet userSet = ps.executeQuery();//select gareesi execute vako
            while(userSet.next()){
                User user= new User(userSet.getString("userName"), userSet.getInt("userContact"),userSet.getInt("userId"));
                userlist.add(user);
            }
            return userlist;
        }
        catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public boolean insertUser(User user) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "INSERT INTO user(userName, userContact) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,user.getUserName());
            ps.setInt(2,user.getUserContact());
            int row = ps.executeUpdate();
            if (row>0){
                return true;
            }else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update_User(int userId, int userContact) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "UPDATE user SET userContact = ? WHERE userId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userContact);
            ps.setInt(2, userId);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete_User(int userId) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "DELETE FROM user WHERE userId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    public User getUserInfo(int userId) {
        User user = null;
        try {
            Connection conn = DatabaseConnection.connect();
            String query = "SELECT userid, userName, userContact FROM user where userId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet userSet = ps.executeQuery();
            while (userSet.next()) {
                user = new User(userSet.getString("userName"), userSet.getInt("userContact"),userSet.getInt("userId"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
