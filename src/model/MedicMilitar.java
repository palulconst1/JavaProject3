package model;

public class MedicMilitar extends Medic {

    private String rank;

    public MedicMilitar(){
        super();
    }

    public MedicMilitar(String firstName, String lastName, String rank){
        super(firstName, lastName);
        this.rank = rank;
    }

    public String getRank(){
        return rank;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    @Override
    public String toString(){
        return getMedicID() + " " + getFirstName() + " " + getLastName() + " " + rank;
    }

}
