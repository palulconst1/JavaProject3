package service;

import model.*;
import java.util.*;
import repositories.*;
import java.io.IOException;
import java.sql.Timestamp;

import java.util.*;


public class RetetaService {
    private List<Reteta> retete = new ArrayList<Reteta>();
    private static RetetaService instance;
    private final RetetaRepo retetaRepo;

    public RetetaService() throws IOException {
        retetaRepo = new RetetaRepo();
        initializeRetete();
    }

    public static RetetaService getInstance() throws IOException {
        if(instance == null)
            instance = new RetetaService();
        return instance;
    }

    public Set<Reteta> getRetetas() throws IOException {
        AuditService.getInstance().log("Requested retetas",new Timestamp(System.currentTimeMillis()));
        return retetaRepo.getRetetas();
    }

    public boolean add(final Reteta reteta) throws IOException {
        AuditService.getInstance().log("Added reteta",new Timestamp(System.currentTimeMillis()));
        return retetaRepo.add(reteta);
    }

    public boolean remove(final int id) throws IOException {
        AuditService.getInstance().log("Removed a reteta",new Timestamp(System.currentTimeMillis()));
        return retetaRepo.remove(id);
    }

    public void displayRetete()    {
        System.out.println(Arrays.toString(retete.toArray()));
    }

    public void displaySortedRetete()    {
        Collections.sort(retete, new SortPret());
        System.out.println(Arrays.toString(retete.toArray()));
    }

    private void initializeRetete() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nr Retete: ");
        int nr = Integer.parseInt(myObj.nextLine());
        for(int i = 0; i < nr; i++) {
            System.out.println("ID Client: ");
            int id = Integer.parseInt(myObj.nextLine());
            System.out.println("Pret: ");
            int pret = Integer.parseInt(myObj.nextLine());
            System.out.println("Diagnostic: ");
            String diagnostic = myObj.nextLine();
            Reteta r = new Reteta(id, pret, diagnostic);
            retete.add(r);
            addReteta(r);
        }
    }

    public boolean addReteta(Reteta reteta) throws IOException {
        AuditService.getInstance().log("Added reteta",new Timestamp(System.currentTimeMillis()));
        return retetaRepo.add(reteta);
    }

    public boolean removeReteta(int id) throws IOException {
        AuditService.getInstance().log("Removed reteta",new Timestamp(System.currentTimeMillis()));
        return retetaRepo.remove(id);
    }
}
