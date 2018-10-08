package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Patient{
    private String lastName;
    private String firstName;
    int ssn = 0;
    
    public Patient(String firstName, String lastName, int ssn){
	this.firstName = firstName;
	this.lastName = lastName;
	this.ssn = ssn;
    }
    
    public Patient(int firstName, int lastName, int ssn){
	this.firstName = "" + firstName;
	this.lastName = "" + lastName;
	this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof Patient){
            return ((Patient)obj).getSsn() == this.getSsn();
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " (" + this.ssn + ")";
    }
    
    public static void main(String[] args) {
	List<Patient> pList = new ArrayList<Patient>();
	IntStream.range(0, 10).forEach(x-> pList.add(new Patient(x, x, x)));
	pList.stream().sorted((x, y) -> x.getLastName().compareTo(y.getLastName())).forEach(System.out::println);
    }
}
