
package sogutucuuyg;

import java.util.Random;
import javax.swing.JOptionPane;

public class User implements IFeedbacks{
    
   private String username;
    private String pass;
    private ITransactions observable;
    Random random=new Random();
    
    public int Sicaklik()
    {
      int sicaklik=random.nextInt(40);
      System.out.println("Sicaklik ="+sicaklik+"°C");
      return sicaklik;
    }
    
    public User(){}
 
         
    @Override
    public void notify(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    
    public User(String username,String pass)
    {
    this.username=username;
    this.pass=pass;
    }
    public String getUsername()
    {
    return username;
    }
    public String getPass()
    {
    return pass;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPass(String pass)
    {
    this.pass=pass;
    }
    
}
