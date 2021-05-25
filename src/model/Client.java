package model;

public class Client {
    private static int numberClients = 0;
    private final int clientID;
    private String firstName;
    private String lastName;
    private int age;
    private  int weight;
    private double height;

    public Client(){
        numberClients ++;
        clientID = numberClients;
    }

    public Client(String firstName, String lastName, int age, int weight, double height){
        numberClients++;
        clientID = numberClients;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;

    }

    public int getClientID(){
        return clientID;
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

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    @Override
    public String toString()    {
        return this.firstName + " " + this.lastName + " " + this.clientID + " " + this.age + " " + this.height + " " + this.weight;
    }

}
