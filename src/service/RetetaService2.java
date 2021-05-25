package service;

import model.Reteta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class RetetaService2 {
    private static final String PATH = "src/data/Reteta.csv";
    private static final String HEADER = "reteteID,clientID,pret,diagnostic";
    private  static RetetaService2 instance;

    private RetetaService2(){}

    public static RetetaService2 getInstance(){
        if(instance == null)
            instance = new RetetaService2();
        return instance;
    }
    public final Set<Reteta> loadRetetas() throws IOException {
        final Set<Reteta> retetas = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                retetas.add(new Reteta(Integer.parseInt(fields[1]),Integer.parseInt(fields[2]),fields[3]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded retetas",new Timestamp(System.currentTimeMillis()));
        return retetas;
    }

    public void saveRetetas() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Reteta> retetas = RetetaService.getInstance().getRetetas();
        for(final Reteta reteta:retetas){

            writer.append(String.valueOf(reteta.getReteteID())).append(",");
            writer.append(String.valueOf(reteta.getClientID())).append(",");
            writer.append(String.valueOf(reteta.getPret())).append(",");
            writer.append(String.valueOf(reteta.getDiagnostic())).append(",");
            writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved retetas",new Timestamp(System.currentTimeMillis()));
    }
}
