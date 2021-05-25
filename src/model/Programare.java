package model;

public class Programare {
    private static int numberProgramari = 0;
    private int programareID;
    private int medicID;
    private int clientID;
    private int cabinetID;
    private int retetaID;
    private String ora;
    private String data;

    public Programare(){
        numberProgramari ++;
        programareID = numberProgramari;
    }

    public Programare(int medicID, int clientID, int cabinetID, int retetaID, String ora, String data){
        numberProgramari++;
        programareID = numberProgramari;
        this.retetaID = retetaID;
        this.medicID = medicID;
        this.clientID = clientID;
        this.cabinetID = cabinetID;
        this.ora = ora;
        this.data = data;
    }

    public void setProgramareID(int x){this.programareID = x;}

    public int getProgramareID(){
        return programareID;
    }

    public int getClientID(){
        return clientID;
    }

    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public int getRetetaID(){
        return retetaID;
    }

    public void setRetetaID(int retetaID){
        this.retetaID = retetaID;
    }

    public int getMedicID(){
        return medicID;
    }

    public void setMedicID(int medicID){
        this.medicID = medicID;
    }

    public int getCabinetID(){
        return cabinetID;
    }

    public void setCabinetID(int cabinetID){
        this.cabinetID = cabinetID;
    }

    public String getOra(){
        return ora;
    }

    public void setOra(String ora){
        this.ora = ora;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    @Override
    public String toString()    {
        return this.clientID + " " + this.cabinetID + " " + this.medicID + " " + this.retetaID + " " + this.ora + " " + this.data;
    }

}
