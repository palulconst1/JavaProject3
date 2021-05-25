package service;

import model.*;
import java.util.*;
import repositories.*;
import java.io.IOException;
import java.sql.Timestamp;

public class ClientService {
    private Set<Client> clients = new HashSet<Client>();
    private static ClientService instance;
    private final ClientRepo clientRepo;

    public ClientService() throws IOException {
        clientRepo = new ClientRepo();
        initializeClients();
    }

    public static ClientService getInstance() throws IOException {
        if(instance == null)
            instance = new ClientService();
        return instance;
    }

    public Set<Client> getClients() throws IOException {
        AuditService.getInstance().log("Requested clients",new Timestamp(System.currentTimeMillis()));
        return clientRepo.getClients();
    }

    public boolean add(final Client client) throws IOException {
        AuditService.getInstance().log("Added client",new Timestamp(System.currentTimeMillis()));
        return clientRepo.add(client);
    }

    public boolean remove(final int id) throws IOException {
        AuditService.getInstance().log("Removed a client",new Timestamp(System.currentTimeMillis()));
        return clientRepo.remove(id);
    }

    public void displayClients()    {
        System.out.println(Arrays.toString(clients.toArray()));
    }
    private void initializeClients() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nr Clienti: ");
        int n = Integer.parseInt(myObj.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nume: ");
            String nume = myObj.nextLine();
            System.out.println("Prenume: ");
            String prenume = myObj.nextLine();
            System.out.println("varsta: ");
            int varsta = Integer.parseInt(myObj.nextLine());
            System.out.println("greutate: ");
            int greutate = Integer.parseInt(myObj.nextLine());
            System.out.println("inaltime: ");
            double inaltime = Double.parseDouble((myObj.nextLine()));
            Client c = new Client(prenume, nume, varsta, greutate, inaltime);
            clients.add(c);
            addClient(c);
        }
    }

    public boolean addClient(Client client) throws IOException {
        AuditService.getInstance().log("Added client",new Timestamp(System.currentTimeMillis()));
        return clientRepo.add(client);
    }

    public boolean removeClient(int id) throws IOException {
        AuditService.getInstance().log("Removed client",new Timestamp(System.currentTimeMillis()));
        return clientRepo.remove(id);
    }

}
