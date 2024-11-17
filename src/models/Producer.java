package models;

public class Producer {
    private String firstName;
    private String lastName;

    public Producer() {
    }

    public Producer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFullName();
    };


    @Override
    public String toString() {
        return "Producer" +
                "\nFirst name " + firstName + '\'' +
                "Last name " + lastName ;
    }



}
