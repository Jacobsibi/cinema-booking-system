package Cinema;

/**
 * @author jacob.s
 */
public class Customer {
    
    int id;
    String firstName;
    String lastName;
    String emailAddress;
    String phoneNo;

    public Customer(int id, String fName, String lName, String emailAddress, String phoneNo) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
    }
    
    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void printCustomer() {
        System.out.print(lastName + " " + firstName);
        System.out.println(emailAddress + ", " + phoneNo);
    }
}
