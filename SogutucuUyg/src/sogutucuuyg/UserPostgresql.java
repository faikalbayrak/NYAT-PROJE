
package sogutucuuyg;

//import com.sun.jdi.connect.spi.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserPostgresql implements IUserPostgresql{
    
    private static UserPostgresql instance = null;
    
    
    public synchronized static UserPostgresql getInstance()
    {
        // eğer daha önce örnek oluşturulmamış ise sınıfın tek örneğini oluştur
        if(instance == null)
        {
            instance  = new UserPostgresql();
        }
        return instance;
    }
    
    @Override
    public Connection Connect(){
       Connection connect=null;
  
        try {
            connect=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Sogutucu","postgres", "BANABAKSANA54");
            if (connect != null)
                JOptionPane.showMessageDialog(null, "Connected to Database !");
            else
                JOptionPane.showMessageDialog(null, "Connection Failed");

        } catch (Exception e) {
            e.getMessage();
        }
        return connect;
    }

    @Override
    public User Scan(String username, String pass) {
        
        System.out.println("Kullanici Araniyor...");
        User kullanici=null;

      
        Connection connect=this.Connect();
        try{
            try (Statement stmt = connect.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM tbl where username='" + username + "' ;");
                rs=stmt.executeQuery("SELECT * FROM tbl where password='" + pass+ "' ;");
                //***** Bağlantı sonlandırma *****
                connect.close();
                
                String username1;
                String pass1;
                while(rs.next())
                {
                    username1=rs.getString("username");
                    pass1=rs.getString("password");
                    kullanici=new User(username1, pass1);
                    
                }
                
                rs.close();
            }
        } 
        catch (SQLException e) {
            e.getMessage();
        }

        return kullanici;
    }
    
}
