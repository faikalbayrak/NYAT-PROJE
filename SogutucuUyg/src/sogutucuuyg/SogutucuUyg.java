
package sogutucuuyg;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class SogutucuUyg {

    
    public static void main(String[] args) {
        
        Scanner girdiAl = new Scanner(System.in);

        
        String username=null;
        User user=null;
        String  pass= null;
        int cevap;
      
        UserPostgresql use=UserPostgresql.getInstance();
        use.Connect();
        User userr=new User();
        NotifyFeedbacks nov=new NotifyFeedbacks();
        nov.addObserver(userr);
       
          
        
        System.out.println("<<<<<<<<<<<<<<<<<<<<Sogutucu Arayuzune Hosgeldiniz>>>>>>>>>>>>>>>>>>>>");

        System.out.println("Kullanici Adi ve Sifrenizi Giriniz");
       
        System.out.print("Kullanici Adi:"); 
        username=girdiAl.nextLine();
         
        System.out.print("Sifre:"); 
        pass=girdiAl.nextLine();
        
        user=use.Scan(username,pass);
        if(user!=null)
        {          
            System.out.println("Kullanici Doğrulandı ! ");
            System.out.println("");
            System.out.println("");
            System.out.println("ISLEM MERKEZI");
            
                  
            gidilecekYer: do {
            System.out.println("|-------------------|");
            System.out.println("| 1.Sicaklik Goster |");
            System.out.println("|                   |");
            System.out.println("| 2.Sogutucu Ac     |");
            System.out.println("|                   |");
            System.out.println("| 3.Sogutucu Kapa   |");
            System.out.println("|-------------------|");
            System.out.println("");
           
            System.out.print("Lutfen Bir Islem Seciniz:");  
                cevap=girdiAl.nextInt();
              
            switch(cevap)
            {
              case 1:
                  userr.Sicaklik();
                  break;
              case 2:
                     nov.sogutucuAcik();
                 
                 break;
                 case 3:
                     nov.sogutucuKapali();
                     break;
                     default:
                         System.out.println("Hatali Seçim Yaptiniz !");
                      break;
            }
            System.out.println("Devam Etmek istiyor musunuz ? (e/h)");
            String character1=girdiAl.next();
            char character2 = character1.charAt(0);
 
            if(character2=='e'||character2=='E')
                continue gidilecekYer; 
            else
                System.out.println("Sistemden Çikis Yapildi");
            break;
            
 
            } while(true);
           
        }
        
        else
            System.out.println("Kullanici Adi veya Sifre yanlis");

      
        
        
    }
    
}
