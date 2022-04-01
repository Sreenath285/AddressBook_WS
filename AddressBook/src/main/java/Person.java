public class Person {

    private String firstName, lastName, address, city, state, email, type;
    private long zipCode, phoneNumber;
    
    public Person(String firstName, String lastName, String address,
                  String city, String state, String email,
                  String type, long zipCode, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.type = type;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }
}
