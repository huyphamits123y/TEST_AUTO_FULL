package className;

public class Person {
    private String firstName;
    private String lastName;
    private Double due;
    public Person(String firstName, String lastName, Double due){
        this.firstName = firstName;
        this.lastName = lastName;
        this.due = due;
    }
    public Person(){}

    public String getFullName(){
        return firstName + " " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getDue() {
        return due;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDue(Double due) {
        this.due = due;
    }
}
