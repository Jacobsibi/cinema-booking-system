package Cinema;

/**
 * @author jacob.s
 */
public class Customer {
    
    int id;
    String firstName;
    String lastName;
    String emailAddress;
    int phoneNo;

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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void printCustomer() {
        System.out.print(lastName + " " + firstName);
        System.out.println(emailAddress + ", " + phoneNo);
    }
}
