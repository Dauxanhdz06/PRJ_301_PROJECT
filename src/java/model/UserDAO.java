/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class UserDAO extends MyDAO{
    public User getUser(String Username, String Password){
        User user;
        xSql = "select * from [User] where username = '" + Username + "' and [password] = '" + Password + "'";
        try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int userid;
            String name, usern, pass, phone, address, email, avatar;
            int roleID;
            while (rs.next()){
                userid = rs.getInt("UserID");
                name = rs.getString("Name");
                usern = rs.getString("Username");
                pass = rs.getString("Password");
                phone = rs.getString("phone");
                address = rs.getString("address");
                email = rs.getString("mail");
                avatar = rs.getString("avatar");
                roleID = rs.getInt("roleid");
                user = new User(userid, name, usern, pass, phone, address, email, avatar, roleID);
                return user;
            }
            rs.close();
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
//    public int getMaxID(){
//        xSql = "select top 1 UserID from User1 order by UserID desc";
//        try{
//            ps = con.prepareStatement(xSql);
//            rs = ps.executeQuery();
//            int id;
//            while(rs.next()){
//                User user = new User();
//                id = rs.getInt("UserID");
//                return id;
//            }
//            rs.close();
//            ps.close();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return 0;
//    }
    
    public void createNewAccountUser(String Name, String Username, String Password, String Phone, String Email){
//        int id = getMaxID() + 1;
        xSql = "insert into [User] ([name],username,[password],phone,address,mail,avatar,roleID)"
                + "values (?,?,?,?,null,?,null,null)";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, Name);
            ps.setString(2, Username);
            ps.setString(3, Password);
            ps.setString(4, Phone);
            ps.setString(5, Email);
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public User getAccountByUser(String user){
        xSql = "Select * from [User] where username = '" + user + "'";
        try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int userid;
            String name, usern, pass, phone, address, email, avatar;
            int roleID;
            while(rs.next()){
                User user1 = new User();
                userid = rs.getInt("UserID");
                name = rs.getString("Name");
                usern = rs.getString("Username");
                pass = rs.getString("Password");
                phone = rs.getString("phone");
                address = rs.getString("address");
                email = rs.getString("mail");
                avatar = rs.getString("avatar");
                roleID = rs.getInt("roleid");
                user1 = new User(userid, name, usern, pass, phone, address, email, avatar, roleID);
                return user1;
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        UserDAO userdao = new UserDAO();
//        userdao.createNewAccountUser("Hoàng","Nguyen", "123456", "0904240146", "anhhoangthu1463@gmail.com");
//        userdao.getAccountByUser("NguyenHoang");
    }
}
