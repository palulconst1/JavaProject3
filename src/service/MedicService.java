package service;

import model.*;

import java.io.IOException;
import java.util.*;
import java.sql.Timestamp;
import repositories.MedicRepo;


public final class MedicService {

    private static MedicService instance;
    private final MedicRepo medicRepo;
    private Set<Medic> medics = new HashSet<Medic> ();

    public MedicService() throws IOException {
        medicRepo = new MedicRepo();
        initializeMedics();
    }

    public static MedicService getInstance() throws IOException {
        if(instance == null)
            instance = new MedicService();
        return instance;
    }

    public void displayMedics()    {
        System.out.println(Arrays.toString(medics.toArray()));
    }

    private void initializeMedics() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nr Medici: ");
        int n = Integer.parseInt(myObj.nextLine());
        for(int i = 0; i < n; i++) {
            System.out.println("Tip medic: 1-medic 2-familie 3-specializat 4-militar");
            int tip = Integer.parseInt(myObj.nextLine());
            System.out.println("Nume: ");
            String nume = myObj.nextLine();
            System.out.println("prenume: ");
            String prenume = myObj.nextLine();

            switch(tip) {
                case 1:
                    Medic medic1 = new Medic(prenume, nume);
                    medics.add(medic1);
                    addMedic(medic1);
                    break;
                case 2:
                    MedicFamilie medic2 = new MedicFamilie(prenume, nume);
                    medics.add(medic2);
                    addMedic(medic2);
                    break;
                case 3:
                    System.out.println("specializare: ");
                    String special = myObj.nextLine();
                    MedicSpecializat medic3 = new MedicSpecializat(prenume, nume, special);
                    medics.add(medic3);
                    addMedic(medic3);
                    break;
                case 4:
                    System.out.println("Rank: ");
                    String rank = myObj.nextLine();
                    MedicMilitar medic4 = new MedicMilitar(prenume, nume, rank);
                    medics.add(medic4);
                    addMedic(medic4);
                    break;
            }
        }
    }

    public Set<Medic> getMedics() throws IOException {
        AuditService.getInstance().log("Requested medics",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getMedics();
    }

    public boolean addMedic(Medic medic) throws IOException {
        AuditService.getInstance().log("Added medic",new Timestamp(System.currentTimeMillis()));
        return medicRepo.add(medic);
    }

    public boolean removeMedic(int medicID) throws IOException {
        AuditService.getInstance().log("Removed medic",new Timestamp(System.currentTimeMillis()));
        return medicRepo.remove(medicID);
    }

    public Medic getMedicById(int medicID) throws IOException {
        AuditService.getInstance().log("Requested medics by id",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getMedicByID(medicID);
    }

    public Set<Medic> getMedicsByFirstName(String firstName) throws IOException {
        AuditService.getInstance().log("Requested medics by first name",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getMedicsByFirstName(firstName);
    }

    public Set<Medic> getMedicsByLastName(String lastName) throws IOException {
        AuditService.getInstance().log("Requested medics by last name",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getMedicsByLastName(lastName);
    }

    public Set<Medic> getFamilyDoctors() throws IOException {
        AuditService.getInstance().log("Requested family medics",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getFamilyMedics();
    }

    public Set<Medic> getSpecialistDoctors() throws IOException {
        AuditService.getInstance().log("Requested specialist medics",new Timestamp(System.currentTimeMillis()));
        return medicRepo.getSpecialistMedics();
    }

    public boolean setDoctorFirstName(int idNo, String firstName) throws IOException {
        AuditService.getInstance().log("Requested change first name of a medics",new Timestamp(System.currentTimeMillis()));
        return medicRepo.setMedicFirstName(idNo, firstName);
    }

    public boolean setDoctorLastName(int idNo, String lastName) throws IOException {
        AuditService.getInstance().log("Requested change last name of a medics", new Timestamp(System.currentTimeMillis()));
        return medicRepo.setMedicLastName(idNo, lastName);
    }


}
