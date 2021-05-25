package repositories;

import model.*;
import service.*;

import java.io.IOException;
import java.util.*;

public class ClientRepo {
    private final Set<Client> clients;
    public ClientRepo() throws IOException {
        clients = ClientService2.getInstance().loadClients();
    }
    public Set<Client> getClients(){
        return Collections.unmodifiableSet(clients);
    }

    public boolean add(final Client patient){
        return clients.add(patient);
    }

    public boolean remove(final int id){
        final Client client = getClientByID(id);
        if(client == null)
            return false;
        return clients.remove(client);
    }

    public Client getClientByID(int id) {
        for(final Client client:clients){
            if(client.getClientID() == id)
                return client;
        }
        return null;
    }
}
