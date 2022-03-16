/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import model.User;

/**
 *
 * @author PC
 */
public class UserService {
    private UserDao userDao;
    
    public UserService(){
        userDao = new UserDao();
    }
    
    
    public List<User> getAllUsers() throws SQLException{
         return userDao.getAllUsers();
     }
    
    public void addUser(User user) throws SQLException{
        userDao.addUser(user);
    }
    
    public void deleteUser(int id) throws SQLException{
        userDao.deleteUser(id);
    }
    
    public User getUserById(int id) throws SQLException{
        return userDao.getUserById(id);
    }
    public void updateUser(User user) throws SQLException{
        userDao.updateUser(user);
    }
}
