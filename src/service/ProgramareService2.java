package service;

import model.Programare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class ProgramareService2 {
    private static final String PATH = "src/data/Programare.csv";
    private static final String HEADER = "programareID,medicID,clientID,cabinetID,retetaID,ora,data";
    private  static ProgramareService2 instance;

    private ProgramareService2(){}

    public static ProgramareService2 getInstance(){
        if(instance == null)
            instance = new ProgramareService2();
        return instance;
    }
    public final Set<Programare> loadProgramares() throws IOException {
        final Set<Programare> programares = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                programares.add(new Programare(Integer.parseInt(fields[1]),Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),Integer.parseInt(fields[4]),fields[5],fields[6]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded programares",new Timestamp(System.currentTimeMillis()));
        return programares;
    }

    public void saveProgramares() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Programare> programares = ProgramareService.getInstance().getProgramares();
        for(final Programare programare:programares){

            writer.append(String.valueOf(programare.getProgramareID())).append(",");
            writer.append(String.valueOf(programare.getMedicID())).append(",");
            writer.append(String.valueOf(programare.getClientID())).append(",");
            writer.append(String.valueOf(programare.getCabinetID())).append(",");
            writer.append(String.valueOf(programare.getRetetaID())).append(",");
            writer.append(String.valueOf(programare.getOra())).append(",");
            writer.append(String.valueOf(programare.getData())).append(",");
            writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved programares",new Timestamp(System.currentTimeMillis()));
    }
}
