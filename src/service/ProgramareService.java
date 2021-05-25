package service;

import model.*;
import java.util.*;
import repositories.*;
import java.io.IOException;
import java.sql.Timestamp;

public class ProgramareService {
    private Set<Programare> programares = new HashSet<Programare>();
    private static ProgramareService instance;
    private final ProgramareRepo programareRepo;

    public ProgramareService() throws IOException {
        programareRepo = new ProgramareRepo();
        initializepPogramares();
    }

    public static ProgramareService getInstance() throws IOException {
        if(instance == null)
            instance = new ProgramareService();
        return instance;
    }

    public Set<Programare> getProgramares() throws IOException {
        AuditService.getInstance().log("Requested programares",new Timestamp(System.currentTimeMillis()));
        return programareRepo.getProgramares();
    }

    public boolean add(final Programare programare) throws IOException {
        AuditService.getInstance().log("Added programare",new Timestamp(System.currentTimeMillis()));
        return programareRepo.add(programare);
    }

    public boolean remove(final int id) throws IOException {
        AuditService.getInstance().log("Removed a programare",new Timestamp(System.currentTimeMillis()));
        return programareRepo.remove(id);
    }

    public void displayProgramares()    {
        System.out.println(Arrays.toString(programares.toArray()));
    }
    private void initializepPogramares() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nr Retete: ");
        int n = Integer.parseInt(myObj.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("id medic: ");
            int medic = Integer.parseInt(myObj.nextLine());
            System.out.println("id client: ");
            int client = Integer.parseInt(myObj.nextLine());
            System.out.println("id cabinet: ");
            int cabinet = Integer.parseInt(myObj.nextLine());
            System.out.println("id reteta: ");
            int reteta = Integer.parseInt(myObj.nextLine());
            System.out.println("ora: ");
            String ora = myObj.nextLine();
            System.out.println("data: ");
            String data = myObj.nextLine();
            Programare p = new Programare(medic, client, cabinet, reteta, ora, data);
            programares.add(p);
            addProgramare(p);
        }
    }

    public boolean addProgramare(Programare programare) throws IOException {
        AuditService.getInstance().log("Added programare",new Timestamp(System.currentTimeMillis()));
        return programareRepo.add(programare);
    }

    public boolean removeProgramare(int id) throws IOException {
        AuditService.getInstance().log("Removed programare",new Timestamp(System.currentTimeMillis()));
        return programareRepo.remove(id);
    }
}
