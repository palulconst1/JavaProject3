package service;

import model.*;
import repositories.*;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class ClientService2 {
    private static final String PATH = "src/data/Client.csv";
    private static final String HEADER = "clientID,firstName,lastName,age,weight,height";
    private  static ClientService2 instance;

    private ClientService2(){}

    public static ClientService2 getInstance(){
        if(instance == null)
            instance = new ClientService2();
        return instance;
    }
    public final Set<Client> loadClients() throws IOException {
        final Set<Client> clients = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                clients.add(new Client(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Double.parseDouble(fields[5])));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded clients",new Timestamp(System.currentTimeMillis()));
        return clients;
    }

    public void saveClients() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Client> clients = ClientService.getInstance().getClients();
        for(final Client client:clients){

            writer.append(String.valueOf(client.getClientID())).append(",");
            writer.append(String.valueOf(client.getFirstName())).append(",");
            writer.append(String.valueOf(client.getLastName())).append(",");
            writer.append(String.valueOf(client.getAge())).append(",");
            writer.append(String.valueOf(client.getWeight())).append(",");
            writer.append(String.valueOf(client.getHeight())).append(",");
            writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved clients",new Timestamp(System.currentTimeMillis()));
    }

}
