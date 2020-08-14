/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PADMA
 */
public class ThogaKade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Try CURD operations mySql database
        
        ThogaKade thogakade=new ThogaKade();
        
        try {
//            thogakade.insertCustomer();
//            thogakade.updateCustomer();
            thogakade.showAllCustomer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThogaKade.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class is invalid");
        } catch (SQLException ex) {
            Logger.getLogger(ThogaKade.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sql error");
        }
        
        
    }
    public void insertCustomer() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade","root","");
        String sql="INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setString(1, "CC01");
        pstm.setString(2,"Padme");
        pstm.setString(3,"Galle");
        pstm.setInt(4,20000);
        pstm.execute();
    }
    
    public void updateCustomer() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root","");
        String sql="UPDATE customer SET name=?, address=?, salary=? WHERE id=? ";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setString(1, "Gnananpriya");
        pstm.setString(2,"Gampaha");
        pstm.setInt(3,25000);
        pstm.setString(4, "CC01");
        pstm.executeUpdate();
    }
    
    public void showAllCustomer() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root","");
        String sql="SELECT * FROM customer";
        Statement stmt=connection.createStatement();
        ResultSet resultSet= stmt.executeQuery(sql);
        
        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+"  "+ resultSet.getString(2)+"  "+ resultSet.getString(3)+" "+resultSet.getString(4));
                    
        }
        
    }
    
}
