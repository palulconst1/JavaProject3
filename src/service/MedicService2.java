package service;

import model.*;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class MedicService2 {
    private static final String PATH = "src/data/Medic.csv";
    private static final String HEADER = "medicID,firstName,lastName,specializare, rank";
    private  static MedicService2 instance;

    private MedicService2(){}

    public static MedicService2 getInstance(){
        if(instance == null)
            instance = new MedicService2();
        return instance;
    }

    public final Set<Medic> loadMedics() throws IOException {
        final Set<Medic> medics = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(PATH));

        String line;
        reader.readLine();
        while((line = reader.readLine()) != null){
            final String[] fields = line.split("\\s*,");
            if(fields.length > 0){
                if("null".equals(fields[3]) && "null".equals(fields[4]))
                    medics.add(new MedicFamilie(fields[1],fields[2]));
                else if("null".equals(fields[3]))
                    medics.add(new MedicSpecializat(fields[1],fields[2],fields[4]));
                else
                    medics.add(new MedicSpecializat(fields[1],fields[2],fields[3]));
            }
        }

        reader.close();
        AuditService.getInstance().log("Loaded medics",new Timestamp(System.currentTimeMillis()));
        return medics;
    }

    public void saveMedics() throws IOException {
        FileWriter writer = new FileWriter(PATH);
        writer.write(HEADER + "\n");
        final Set<Medic> medics = MedicService.getInstance().getMedics();
        for(final Medic medic:medics){

            writer.append(String.valueOf(medic.getMedicID())).append(",");
            writer.append(String.valueOf(medic.getFirstName())).append(",");
            writer.append(String.valueOf(medic.getLastName())).append(",");
            if(medic.getClass() == MedicSpecializat.class)
                writer.append(String.valueOf(((MedicSpecializat) medic).getSpecializare())).append("\n");
            else if(medic.getClass() == MedicMilitar.class)
                writer.append(String.valueOf(((MedicMilitar) medic).getRank())).append("\n");
            else
                writer.append("null\n");

        }
        writer.flush();
        writer.close();
        AuditService.getInstance().log("Saved doctors",new Timestamp(System.currentTimeMillis()));
    }
}
