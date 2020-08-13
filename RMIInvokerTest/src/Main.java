import com.spirit.PersonService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {

        String url = "rmi://127.0.0.1:8888/PersonService";
        try {
            PersonService personService = (PersonService) Naming.lookup(url);
            System.out.println(personService.getPerson());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
