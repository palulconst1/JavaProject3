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

public class CabinetService2 {

    private static final String PATH = "src/data/Cabinet.csv";
    private static final String HEADER = "cabinetID,adresa";
    private  static CabinetService2 instance;

    private CabinetService2(){}

    public static CabinetService2 getInstance(){
        if(instance == null)
            instance = new CabinetService2();
        return instance;
    }
    public final Set<Cabinet> loadCabinets() throws IOException {
        final Set<Cabinet> cabinets = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                cabinets.add(new Cabinet(fields[1]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded cabinets",new Timestamp(System.currentTimeMillis()));
        return cabinets;
    }

    public void saveCabinets() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Cabinet> cabinets = CabinetService.getInstance().getCabinets();
        for(final Cabinet cabinet:cabinets){

            writer.append(String.valueOf(cabinet.getCabinetID())).append(",");
            writer.append(String.valueOf(cabinet.getAdresa())).append(",");
            writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved clients",new Timestamp(System.currentTimeMillis()));
    }

}
