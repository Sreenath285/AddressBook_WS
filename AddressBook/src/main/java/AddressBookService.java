import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {

    String firstName, lastName, address, city, state, email, zipCode, phoneNumber;
    List<Person> personList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public String regexPattern;

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
     * @return
     */
    public void addContact() {
        ValidateContact validateContact = new ValidateContact();
        do {
            firstName = readStringInput("Enter first name : ");
        }while (validateContact.validateName(firstName) != true);
        do {
            lastName = readStringInput("Enter last name : ");
        }while (validateContact.validateName(lastName) != true);
        do {
            address = readStringInput("Enter address : ");
        }while (validateContact.validateAddress(address) != true);
        do {
            city = readStringInput("Enter city : ");
        }while (validateContact.validateCity(city) != true);
        do {
            state = readStringInput("Enter state : ");
        }while (validateContact.validateState(state) != true);
        do {
            email = readStringInput("Enter email : ");
        }while (validateContact.validateEmail(email) != true);
        do {
            zipCode = readStringInput("Enter zip code : ");
        }while (validateContact.validateZipCode(zipCode) != true);
        do {
            phoneNumber = readStringInput("Enter phone number : ");
        }while (validateContact.validatePhoneNumber(phoneNumber) != true);
        // creating Person
        Person person = new Person(firstName, lastName, address, city, state, email, zipCode, phoneNumber);
        // adding person to personList
        personList.add(person);
        System.out.println("Successfully added");
    }

    /***
     * created editContact method to edit contact
     * calling findContact method to find the contact by giving user's first name
     */
    public void editContact(Person person) {
        String continueEdit = "";
        do {
            System.out.println("1. Edit first name \n2. Edit last name \n3. Edit address" +
                    "\n4. Edit city \n5. Edit state \n6. Edit email" +
                    "\n7. Edit zip code \n8. Edit phone number");
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    person.setFirstName(readStringInput("Enter first name : "));
                    break;
                case 2 :
                    person.setLastName(readStringInput("Enter last name : "));
                    break;
                case 3 :
                    person.setAddress(readStringInput("Enter address : "));
                    break;
                case 4 :
                    person.setCity(readStringInput("Enter city : "));
                    break;
                case 5 :
                    person.setState(readStringInput("Enter state : "));
                    break;
                case 6 :
                    person.setEmail(readStringInput("Enter email : "));
                    break;
                case 7 :
                    person.setZipCode(readStringInput("Enter zip code : "));
                    break;
                case 8 :
                    person.setPhoneNumber(readStringInput("Enter phone number : "));
                    break;
                default :
                    System.out.println("Invalid input");
                    break;
            }
            System.out.print("Do you want to continue (y/n) : ");
            continueEdit = sc.next();
        }
        while (continueEdit.equalsIgnoreCase("Y"));
    }

    /***
     * created editByName method to search the person by name if available then we can edit the contact
     * @param firstName - passing first name
     */
    public void editByName(String firstName) {
        for (Person person : personList) {
            if (firstName.equals(person.getFirstName())) {
                editContact(person);
            } else {
                System.out.println("Contact not found");
            }
        }
    }

    /***
     * created showContact method to display contact
     */
    public void showContact() {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /***
     * created deleteContact method to delete contact
     */
    public void deleteContact() {
        if(!personList.isEmpty()) {
            for (Person person : personList) {
                if (firstName.equals(person.getFirstName())) {
                    personList.remove(person);
                    System.out.println("Contact deleted");
                    break;
                } else {
                    System.out.println("Contact not found");
                }
            }
        }
    }
}
