package model;

public class Cabinet {
    private static int numberCabinets = 0;
    private int cabinetID;
    private String adresa;

    public Cabinet() {
        numberCabinets++;
        cabinetID = numberCabinets;
    }

    public Cabinet(String adresa)
    {
        numberCabinets++;
        cabinetID = numberCabinets;
        this.adresa = adresa;
    }

    public void setCabinetID(int x){ this.cabinetID = x; }

    public int getCabinetID(){
        return cabinetID;
    }

    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    public String getAdresa(){
        return adresa;
    }

    @Override
    public String toString()    {
        return this.cabinetID + " " + this.adresa;
    }

}
