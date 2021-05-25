package model;

import java.util.*;

public class Medic {
    private static int numberMedics = 0;
    private int medicID;
    private String firstName;
    private String lastName;

    public Medic() {
        numberMedics++;
        medicID = numberMedics;
    }

    public Medic(String firstName, String lastName)
    {
        numberMedics++;
        medicID = numberMedics;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setMedicID(int x){ this.medicID = x; }

    public int getMedicID(){
        return medicID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString()    {
        return this.firstName + " " + this.lastName;
    }

}

