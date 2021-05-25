package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
import model.*;
import java.sql.*;


public class testConnection {


    private Connection DBConnection = null;

    public testConnection() throws SQLException {
        DBConnection = DriverManager.getConnection("jdbc:sqlite:baza1.db");
        String createMadicsTableSql =
                "CREATE TABLE IF NOT EXISTS Medics (" +
                        "medicID INTEGER PRIMARY KEY,"+
                        "\"firstName\"\tTEXT,"+
                        "\"lastName\"\tTEXT" +

                        ")";

        String createCabinetsTableSql =
                "CREATE TABLE IF NOT EXISTS Cabinets (" +
                        "cabinetID INTEGER PRIMARY KEY,"+
                        "\"adresa\"\tTEXT"+

                        ")";

        String createRetetasTableSql =
                "CREATE TABLE IF NOT EXISTS Retetas (" +
                        "reteteID INTEGER PRIMARY KEY,"+
                        "\"clientID\"\tINTEGER,"+
                        "\"pret\"\tINTEGER,"+
                        "\"diagnostic\"\tTEXT"+

                        ")";

        String createProgramaresTableSql =
                "CREATE TABLE IF NOT EXISTS Programares (" +
                        "programareID INTEGER PRIMARY KEY,"+
                        "\"medicID\"\tINTEGER,"+
                        "\"clientID\"\tINTEGER,"+
                        "\"cabinetID\"\tINTEGER,"+
                        "\"retetaID\"\tINTEGER,"+
                        "\"ora\"\tTEXT,"+
                        "\"data\"\tTEXT"+

                        ")";


        try (Statement stmt = DBConnection.createStatement()) {
            stmt.execute(createMadicsTableSql);
            stmt.execute(createCabinetsTableSql);
            stmt.execute(createRetetasTableSql);
            stmt.execute(createProgramaresTableSql);
        }catch(SQLException e){
            System.out.println("Conenction Error: " + e);
        }
    }

    public void addMedic(Medic a) {
        String insertMedicSql =
                "INSERT INTO Medics " +
                        "(medicID, firstName, lastName) " +
                        "VALUES " +
                        "('" + a.getMedicID() + "', '" + a.getFirstName() + "','" + a.getLastName() +"')";



        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertMedicSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert medic into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Medic inserat");

    }

    public void addCabinet(Cabinet a) {
        String insertCabinetSql =
                "INSERT INTO Cabinets " +
                        "(cabinetID, adresa) " +
                        "VALUES " +
                        "('" + a.getCabinetID() + "', '" + a.getAdresa()  +"')";



        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertCabinetSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert cabinet into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cabinet inserat");

    }

    public void addReteta(Reteta a) {
        String insertRetetaSql =
                "INSERT INTO Retetas " +
                        "(reteteID, clientID, pret, diagnostic) " +
                        "VALUES " +
                        "('" + a.getReteteID() + "', '" + a.getClientID() + "', '" + a.getPret() + "', '" + a.getDiagnostic() +"')";



        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertRetetaSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert reteta into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reteta inserata");

    }

    public void addProgramare(Programare a) {
        String insertRetetaSql =
                "INSERT INTO Programares " +
                        "(programareID, medicID, clientID, cabinetID, retetaID, ora, data) " +
                        "VALUES " +
                        "('" + a.getProgramareID() + "', '" + a.getMedicID() + "', '" + a.getClientID() + "', '"
                        + a.getCabinetID() + "', '" + a.getRetetaID() + "', '" + a.getOra() + "', '" + a.getData() +"')";



        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertRetetaSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert programare into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Programare inserata");

    }

    public List<Medic> getMedics() {
        String getSql = "SELECT * FROM Medics";
        try (Statement stmt = DBConnection.createStatement()) {
            ArrayList<Medic> medics = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getSql);
            while (result.next()) {
                Medic medic = new Medic(
                        result.getString("firstName"),
                        result.getString("lastName"));
                medic.setMedicID(result.getInt("medicID"));
                medics.add(medic);
            }
            return medics;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cabinet> getCabinets() {
        String getSql = "SELECT * FROM Cabinets";
        try (Statement stmt = DBConnection.createStatement()) {
            ArrayList<Cabinet> cabinets = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getSql);
            while (result.next()) {
                Cabinet cabinet = new Cabinet(
                        result.getString("adresa"));
                cabinet.setCabinetID(result.getInt("cabinetID"));
                cabinets.add(cabinet);
            }
            return cabinets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reteta> getRetetas() {
        String getSql = "SELECT * FROM Retetas";
        try (Statement stmt = DBConnection.createStatement()) {
            ArrayList<Reteta> retetas = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getSql);
            while (result.next()) {
                Reteta reteta = new Reteta(
                        result.getInt("clientID"),
                        result.getInt("pret"),
                        result.getString("diagnostic"));
                reteta.setReteteID(result.getInt("reteteID"));
                retetas.add(reteta);
            }
            return retetas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Programare> getProgramares() {
        String getSql = "SELECT * FROM Programares";
        try (Statement stmt = DBConnection.createStatement()) {
            ArrayList<Programare> programares = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getSql);
            while (result.next()) {
                Programare programare = new Programare(
                        result.getInt("medicID"),
                        result.getInt("clientID"),
                        result.getInt("cabinetID"),
                        result.getInt("retetaID"),
                        result.getString("ora"),
                        result.getString("data"));
                programare.setProgramareID(result.getInt("programareID"));
                programares.add(programare);
            }
            return programares;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMedic(int id) {

        String deleteSql = "DELETE FROM Medics WHERE medicID = " + id;

        try (Statement stmt = DBConnection.createStatement()) {
            int deletedMedic = stmt.executeUpdate(deleteSql);
            if (deletedMedic != 1) {
                throw new SQLException("Failed to delete medic into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCabinet(int id) {

        String deleteSql = "DELETE FROM Cabinets WHERE cabinetID = " + id;

        try (Statement stmt = DBConnection.createStatement()) {
            int deletedCabinet = stmt.executeUpdate(deleteSql);
            if (deletedCabinet != 1) {
                throw new SQLException("Failed to delete cabinet into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteReteta(int id) {

        String deleteSql = "DELETE FROM Retetas WHERE reteteID = " + id;

        try (Statement stmt = DBConnection.createStatement()) {
            int deletedReteta = stmt.executeUpdate(deleteSql);
            if (deletedReteta != 1) {
                throw new SQLException("Failed to delete reteta into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteProgramare(int id) {

        String deleteSql = "DELETE FROM Programares WHERE programareID = " + id;

        try (Statement stmt = DBConnection.createStatement()) {
            int deletedProgramare = stmt.executeUpdate(deleteSql);
            if (deletedProgramare != 1) {
                throw new SQLException("Failed to delete programare into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateMedic(int x) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Prenume nou: ");
        String str1 = myObj.nextLine();
        System.out.println("Nume nou: ");
        String str2 = myObj.nextLine();

        String updateMedicSql =
                "update Medics set firstName='"+ str1
                        + "', lastName='"+ str2
                        +"' WHERE medicID='"+ x +"'  ";


        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(updateMedicSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to update medic into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateCabinet(int x) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Adresa noua: ");
        String str1 = myObj.nextLine();

        String updateCabinetSql =
                "update Cabinets set adresa='"+ str1
                        +"' WHERE cabinetID='"+ x +"'  ";


        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(updateCabinetSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to update cabinet into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateReteta(int x) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Client id nou: ");
        String str1 = myObj.nextLine();
        System.out.println("Pret nou: ");
        String str2 = myObj.nextLine();
        System.out.println("Diagnostic nou: ");
        String str3 = myObj.nextLine();

        String updateRetetaSql =
                "update Retetas set clientID='"+ str1
                        + "', pret='"+ str2
                        + "', diagnostic='"+ str3
                        +"' WHERE reteteID='"+ x +"'  ";


        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(updateRetetaSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to update reteta into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateProgramare(int x) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Medic id nou: ");
        String str1 = myObj.nextLine();
        System.out.println("Client id nou: ");
        String str2 = myObj.nextLine();
        System.out.println("Cabinet id nou: ");
        String str3 = myObj.nextLine();
        System.out.println("Reteta id nou: ");
        String str4 = myObj.nextLine();
        System.out.println("Ora noua: ");
        String str5 = myObj.nextLine();
        System.out.println("Data noua: ");
        String str6 = myObj.nextLine();

        String updateProgramareSql =
                "update Programares set medicID='"+ str1
                        + "', clientID='"+ str2
                        + "', cabinetID='"+ str3
                        + "', retetaID='"+ str4
                        + "', ora='"+ str5
                        + "', data='"+ str6
                        +"' WHERE programareID='"+ x +"'  ";


        try (Statement stmt = DBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(updateProgramareSql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to update programarea into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

