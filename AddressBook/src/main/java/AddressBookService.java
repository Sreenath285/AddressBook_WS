import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {

    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private static final String EMAIL_PATTERN = "^[a-z0-9]{3,}+([_+-.][a-z0-9]{3,}+)*@[a-z0-9]+.[a-z]{2,3}+(.[a-z]{2,3}){0,1}$";
    private static final String ADDRESS_PATTERN = "^[A-Za-z0-9]{5,}$";
    private static final String CITY_PATTERN = "^[A-Za-z]{2,}$";
    private static final String STATE_PATTERN = "^[A-Za-z]{2,}$";
    private static final String ZIP_PATTERN = "^[0-9]{6}$";
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]{10}$";


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
        while(true) {
            String firstName = readStringInput("Enter first name : ");
            if (firstName.matches(NAME_PATTERN)) {
            }
            else {
                System.out.println("Enter valid first name");
                System.exit(0);
            }
            String lastName = readStringInput("Enter last name : ");
            if (lastName.matches(NAME_PATTERN)) {
            }
            else {
                System.out.println("Enter valid last name");
                System.exit(0);
            }
            String address = readStringInput("Enter address : ");
            if (address.matches(ADDRESS_PATTERN)) {
            }
            else {
                System.out.println("Enter valid address");
                System.exit(0);
            }
            String city = readStringInput("Enter city : ");
            if (city.matches(CITY_PATTERN)) {
            }
            else {
                System.out.println("Enter valid city");
                System.exit(0);
            }
            String state = readStringInput("Enter state : ");
            if (state.matches(STATE_PATTERN)) {
            }
            else {
                System.out.println("Enter valid state");
                System.exit(0);
            }
            String email = readStringInput("Enter email : ");
            if (email.matches(EMAIL_PATTERN)) {
            }
            else {
                System.out.println("Enter valid email");
                System.exit(0);
            }
            String zipCode = readStringInput("Enter zip code : ");
            if (zipCode.matches(ZIP_PATTERN)) {
            }
            else {
                System.out.println("Enter valid first name");
                System.exit(0);
            }
            String phoneNumber = readStringInput("Enter phone number : ");
            if (phoneNumber.matches(PHONE_NUMBER_PATTERN)) {
            }
            else {
                System.out.println("Enter valid phone number");
                System.exit(0);
            }
            // creating Person
            Person person =new Person(firstName, lastName, address, city, state, email, zipCode, phoneNumber);
            // adding person to personList
            personList.add(person);
            System.out.println("Successfully added");
        }
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
        System.out.print("Enter the first name to delete : ");
        String dName = sc.next();
        if (personList.size() > 0) {
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getFirstName().equalsIgnoreCase(dName)) {
                    personList.remove(i);
                    System.out.println("Contact deleted");
                    System.out.println(personList);
                    break;
                }
            }
            System.out.println("Contact not found");
        } else {
            System.out.println("Empty AddressBook");
        }
    }
}
