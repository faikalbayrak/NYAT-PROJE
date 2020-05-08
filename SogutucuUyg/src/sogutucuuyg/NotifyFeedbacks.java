
package sogutucuuyg;

import java.util.ArrayList;
import java.util.List;

public class NotifyFeedbacks implements ITransactions{
    
    private final List<IFeedbacks> observerList = new ArrayList<>();
    private final String message = "Soğutucu Açıldı";
    private final String message1 = "Soğutucu Kapatıldı";
    @Override
    public void addObserver(IFeedbacks observer) {
        observerList.add(observer); 
    }
    
    
    
    @Override
    public void sogutucuAcik() {
        observerList.forEach((observer) -> {
            observer.notify(message);          
        });
    }
    @Override
     public void sogutucuKapali() {
         observerList.forEach((observer) -> {
             observer.notify(message1); 
        });
    }
    
}
