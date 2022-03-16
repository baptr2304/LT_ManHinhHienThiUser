/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author PC
 */
public class UserDao {
    public List<User> getAllUsers() throws SQLException{
        List<User> users = new ArrayList<User>();
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM USERS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUserName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavorites(rs.getString("FAVORITES"));
                user.setRole(rs.getString("ROLE"));
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
     public User getUserById(int id) throws SQLException{
        
        
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUserName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavorites(rs.getString("FAVORITES"));
                user.setRole(rs.getString("ROLE"));
                
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(User user) throws SQLException{
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO USERS( ID,NAME, PHONE, USERNAME, PASSWORD, ABOUT, FAVORITES, ROLE)"+"VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, user.getId());
             preparedStatement.setString(2, user.getName());
             preparedStatement.setString(3, user.getPhone());
             preparedStatement.setString(4, user.getUserName());
             preparedStatement.setString(5, user.getPassword());
             preparedStatement.setString(6, user.getAbout());
             preparedStatement.setString(7, user.getFavorites());
             preparedStatement.setString(8, user.getRole());
             
             int rs = preparedStatement.executeUpdate();
             System.out.println("da them thanh cong");
             System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
        
     public void updateUser(User user) throws SQLException{
         Connection connection = JDBCConnection.getJDBCConnection();
         
         String sql = "UPDATE Users SET NAME = ?, PHONE = ?,USERNAME = ?,PASSWORD = ?, ABOUT = ?,"
                 + "FAVORITES = ?,ROLE = ? WHERE ID = ?";
         try {           
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

             
             preparedStatement.setString(1, user.getName());
             preparedStatement.setString(2, user.getPhone());
             preparedStatement.setString(3, user.getUserName());
             preparedStatement.setString(4, user.getPassword());
             preparedStatement.setString(5, user.getAbout());
             preparedStatement.setString(6, user.getFavorites());
             preparedStatement.setString(7, user.getRole());
             preparedStatement.setInt(8, user.getId());
             
             int rs = preparedStatement.executeUpdate();
             System.out.println(rs);

         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
    public void deleteUser(int id) throws SQLException{
         Connection connection = JDBCConnection.getJDBCConnection();
         
         String sql = "delete from Users where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt((1), id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
//    public static void main(String[] args) throws SQLException{
//        UserDao dao = new UserDao();
//      User user = new User(2,"B","789", "B", "789", "student","read book", "no");
// //      dao.addUser(user);
////       dao.edit(ql);
////       dao.del(2);
// //        System.out.println("=>"+dao.getQuanLyByMaTaiLieu(3));
// 
//       dao.updateUser(user);
//    }
}
