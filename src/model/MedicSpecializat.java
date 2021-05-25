package model;

public class MedicSpecializat extends Medic {

    private String specializare;

    public MedicSpecializat(){
        super();
    }

    public MedicSpecializat(String firstName, String lastName, String specializare){
        super(firstName, lastName);
        this.specializare = specializare;
    }

    public String getSpecializare(){
        return specializare;
    }

    public void setSpecializare(String specializare){
        this.specializare = specializare;
    }

    @Override
    public String toString(){
        return getMedicID() + " " + getFirstName() + " " + getLastName() + " " + specializare;
    }

}
