import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {

    List<Person> personList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /***
     * created readLongInput method to read long input
     * @param message - passing input message
     * @return - returning input
     */
    public long readLongInput(String message) {
        System.out.print(message);
        long longInput = sc.nextLong();
        return  longInput;
    }

    /***
     * created readStringInput method to read long input
     * @param inputMsg - passing input message
     * @return - returning input
     */
    public String readStringInput(String inputMsg) {
        System.out.print(inputMsg);
        String stringInput = sc.next();
        return  stringInput;
    }

    /***
     * created addPerson method to enter contact details from user
     */
    public void addPerson() {
        String firstName = readStringInput("Enter first name : ");
        String lastName = readStringInput("Enter last name : ");
        String address = readStringInput("Enter address : ");
        String city = readStringInput("Enter city : ");
        String state = readStringInput("Enter state : ");
        String email = readStringInput("Enter email : ");
        long phoneNumber = readLongInput("Enter phone number : ");
        long zipCode = readLongInput("Enter zip code : ");
        // creating Person
        Person person =new Person(firstName, lastName, address, city, state, email, phoneNumber, zipCode);
        // adding person to personList
        personList.add(person);
        System.out.println("Successfully added");
    }

    /***
     * created showPerson to display person
     */
    public void showPerson() {
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
