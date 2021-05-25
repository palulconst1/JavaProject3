package Main;


import model.*;
import service.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.*;
import java.sql.*;
public class Main {





    public static void main(String[] args) throws IOException,SQLException {

//      Etapa 3

        testConnection a = new testConnection();
//        Medic x = new Medic("Andrei", "Popescu");
//        Cabinet y = new Cabinet("alb");
//        Reteta z = new Reteta(1, 2, "boala");
//        Programare b = new Programare(1, 1, 1, 1, "10:10", "11.11.2021");
//        a.addMedic(x);
//        a.addCabinet(y);
//        a.addReteta(z);
//        a.addProgramare(b);

//        Medic c = new Medic("Andrei2", "Popescu2");
//        c.setMedicID(2);
//        a.addMedic(c);
//        System.out.println(a.getMedics());
//        a.deleteMedic(2);
//        System.out.println(a.getMedics());
//        a.updateMedic(1);
//        System.out.println(a.getMedics());

//        Cabinet c = new Cabinet("test");
//        c.setCabinetID(2);
//        a.addCabinet(c);
//        System.out.println(a.getCabinets());
//        a.deleteCabinet(2);
//        System.out.println(a.getCabinets());
//        a.updateCabinet(1);
//        System.out.println(a.getCabinets());


//        Reteta c = new Reteta(1, 2, "test");
//        c.setReteteID(2);
//        a.addReteta(c);
//        System.out.println(a.getRetetas());
//        a.deleteReteta(2);
//        System.out.println(a.getRetetas());
//        a.updateReteta(1);
//        System.out.println(a.getRetetas());

//        Programare c = new Programare(1, 2, 1, 1, "testora", "testdata");
//        c.setProgramareID(2);
//        a.addProgramare(c);
//        System.out.println(a.getProgramares());
//        a.deleteProgramare(2);
//        System.out.println(a.getProgramares());
//        a.updateProgramare(1);
//        System.out.println(a.getProgramares());

//        Etapa 1
//        Scanner myObj = new Scanner(System.in);
//        int ok = 1;
//        while(ok == 1) {
//            System.out.println("Introduceti optiunea dorita: ");
//            System.out.println("Introduceti Medici: 1");
//            System.out.println("Introduceti Clienti: 2");
//            System.out.println("Introduceti Retete: 3");
//            System.out.println("Introduceti Cabinete: 4");
//            System.out.println("Introduceti Programari: 5");
//            System.out.println("Oprire: 6");
//            System.out.println("Optiune: ");
//            int opt = Integer.parseInt(myObj.nextLine());
//            switch (opt) {
//                case 1:
//                    MedicService medicService = new MedicService();
//                    medicService.displayMedics();
//                    break;
//                case 2:
//                    ClientService clientService = new ClientService();
//                    clientService.displayClients();
//                    break;
//                case 3:
//                    RetetaService retetaService = new RetetaService();
//                    retetaService.displayRetete();
//                    retetaService.displaySortedRetete();
//                    break;
//                case 4:
//                    CabinetService cabinetService = new CabinetService();
//                    cabinetService.displayCabinets();
//                    break;
//                case 5:
//                    ProgramareService programareService = new ProgramareService();
//                    programareService.displayProgramares();
//                    break;
//                case 6:
//                    ok = 0;
//                    break;
//            }
//        }

//        Etapa 2
//        final MedicService medicService = MedicService.getInstance();
//        final MedicService2 medicService2 = MedicService2.getInstance();
//        medicService2.saveMedics();
//        System.out.println(medicService.getMedics());
//
//        final ClientService clientService = ClientService.getInstance();
//        final ClientService2 clientService2 = ClientService2.getInstance();
//        clientService2.saveClients();
//        System.out.println(clientService.getClients());
//
//        final CabinetService cabinetService = CabinetService.getInstance();
//        final CabinetService2 cabinetService2 = CabinetService2.getInstance();
//        cabinetService2.saveCabinets();
//        System.out.println(cabinetService.getCabinets());
//
//        final ProgramareService programareService = ProgramareService.getInstance();
//        final ProgramareService2 programareService2 = ProgramareService2.getInstance();
//        programareService2.saveProgramares();
//        System.out.println(programareService.getProgramares());
//
//        final RetetaService retetaService = RetetaService.getInstance();
//        final RetetaService2 retetaService2 = RetetaService2.getInstance();
//        retetaService2.saveRetetas();
//        System.out.println(retetaService.getRetetas());

    }
}
