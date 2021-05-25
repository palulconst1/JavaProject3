package service;

import model.*;
import java.util.*;
import repositories.*;
import java.io.IOException;
import java.sql.Timestamp;

public class CabinetService {
    private Set<Cabinet> cabinets = new HashSet<Cabinet> ();
    private static CabinetService instance;
    private final CabinetRepo cabinetRepo;

    public CabinetService() throws IOException {
        cabinetRepo = new CabinetRepo();
        initializeCabinets();
    }

    public static CabinetService getInstance() throws IOException {
        if(instance == null)
            instance = new CabinetService();
        return instance;
    }

    public Set<Cabinet> getCabinets() throws IOException {
        AuditService.getInstance().log("Requested cabinets",new Timestamp(System.currentTimeMillis()));
        return cabinetRepo.getCabinets();
    }

    public boolean add(final Cabinet cabinet) throws IOException {
        AuditService.getInstance().log("Added cabinet",new Timestamp(System.currentTimeMillis()));
        return cabinetRepo.add(cabinet);
    }

    public boolean remove(final int id) throws IOException {
        AuditService.getInstance().log("Removed a cabinet",new Timestamp(System.currentTimeMillis()));
        return cabinetRepo.remove(id);
    }

    public void displayCabinets()    {
        System.out.println(Arrays.toString(cabinets.toArray()));
    }
    private void initializeCabinets() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nr Cabinete: ");
        int n = Integer.parseInt(myObj.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Adresa: ");
            String adresa = myObj.nextLine();
            Cabinet c = new Cabinet(adresa);
            cabinets.add(c);
            addCabinet(c);
        }
    }

    public boolean addCabinet(Cabinet cabinet) throws IOException {
        AuditService.getInstance().log("Added cabinet",new Timestamp(System.currentTimeMillis()));
        return cabinetRepo.add(cabinet);
    }

    public boolean removeCabinet(int id) throws IOException {
        AuditService.getInstance().log("Removed cabinet",new Timestamp(System.currentTimeMillis()));
        return cabinetRepo.remove(id);
    }

}
