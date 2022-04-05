import java.util.*;

public class MultipleAddressBook {

    Map<String, AddressBookService> multipleAddressBookMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    /***
     * created addAddressBook method to add a new address book
     */
    public void addAddressBook () {
        System.out.print("Enter address book name : ");
        String addressBookName = sc.next();
        if (multipleAddressBookMap.containsKey(addressBookName)) {
            System.out.println("Address book already exists");
        }
        else {
            AddressBookService addressBookService = new AddressBookService();
            multipleAddressBookMap.put(addressBookName, addressBookService);
            multipleAddressBookMap.get(addressBookName).getList();
        }
    }

    /***
     * created existingAddressBook method to get existing address book
     */
    public void existingAddressBook() {
        System.out.print("Enter address book name : ");
        String existingAddressBookName = sc.next();
        if (multipleAddressBookMap.get(existingAddressBookName) == null) {
            System.out.println("There is no address book with the given name");
        }
        else {
            multipleAddressBookMap.get(existingAddressBookName).getList();
        }
    }

    /***
     * created showAddressBook method to show address book contacts
     */
    public void showAddressBook() {
        for (String name : multipleAddressBookMap.keySet()) {
            System.out.println(name);
            System.out.println(multipleAddressBookMap.get(name).personList);
        }
    }

    /***
     * created searchByCity method to search person by city
     */
    public void searchByCity() {
        System.out.print("Enter city to search person : ");
        String cityName = sc.next();
        for (String i : multipleAddressBookMap.keySet()) {
            List<Person> personList = multipleAddressBookMap.get(i).personList;
            personList.stream()
                      .filter(person -> person.getCity().equals(cityName))
                      .forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /***
     * created searchByState method to search person by state
     */
    public void searchByState() {
        System.out.print("Enter state to search person : ");
        String state = sc.next();
        for (String i : multipleAddressBookMap.keySet()) {
            List<Person> personList = multipleAddressBookMap.get(i).personList;
            personList.stream()
                    .filter(person -> person.getCity().equals(state))
                    .forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /***
     * created displayPeopleByRegion method display person by region
     * @param addressBookMap - passing hashmap
     */
    public void displayPeopleByRegion(HashMap<String, ArrayList<Person>> addressBookMap) {
        List<Person> personList;
        for (String name : addressBookMap.keySet()) {
            System.out.println("People residing in : " + name);
            personList = addressBookMap.get(name);
            for (Person person : personList) {
                System.out.println(person);
            }
        }
    }

    /***
     * created countPeopleByRegion method to display number of person in the city or state
     * @param listToDisplay - passing hash map
     */
    public void countPeopleByRegion(HashMap<String, ArrayList<Person>> listToDisplay) {
        System.out.print("Enter the name of the region : ");
        String regionName = sc.next();
        long countPeople = listToDisplay.values().stream()
                .map(region -> region.stream().filter(person -> person.getState().equals(regionName)
                                                      || person.getCity().equals(regionName)))
                .count();
        System.out.println("Number of People residing in " + regionName +" are : " + countPeople);
    }
}
