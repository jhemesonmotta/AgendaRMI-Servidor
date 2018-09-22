package agenda;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgendaActions extends UnicastRemoteObject implements IAgendaActions{
    private Date data;
    final private Calendar calendar;
    ArrayList<Pessoa> pessoas = new ArrayList();
    
    public AgendaActions() throws RemoteException {
        super();
        calendar = new GregorianCalendar();
    }

    @Override
    public String AtualizarDataHora() throws RemoteException {
        String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return dataHora;
    }

    @Override
    public String InserirContato(String nome, String telefone) throws RemoteException {
        try{
            Pessoa pessoa = new Pessoa(nome, telefone);
            pessoas.add(pessoa);
            return "200";
        }
        catch(Exception ex){
            return "500: " + ex.getMessage();
        }
    }

    @Override
    public String ImprimirContatos() throws RemoteException {
        return pessoas.toString();
    }
}
