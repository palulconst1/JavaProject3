package model;

public class MedicFamilie extends Medic {
    public MedicFamilie(){
        super();
    }

    public MedicFamilie(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public String toString(){
        return getMedicID() + " " + getFirstName() + " " + getLastName();
    }

}
