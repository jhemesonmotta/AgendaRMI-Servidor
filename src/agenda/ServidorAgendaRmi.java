package agenda;
import java.rmi.Naming;

public class ServidorAgendaRmi {
    public static void main(String[] args) {
        try {     
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry pronto.");
        } catch (Exception e) {
                    System.out.println("Exception starting RMI registry:");
        }
                
        try{			
                AgendaActions s = new AgendaActions();
                Naming.rebind("AgendaCRUD", s); 
        }catch (Exception e){
                System.err.println("Erro: "+ e.getMessage() );	
                System.exit(0);
        }
    }
}
