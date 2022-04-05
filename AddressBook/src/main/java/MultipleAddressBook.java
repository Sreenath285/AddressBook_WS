import java.util.*;
import java.util.stream.Collectors;

public class MultipleAddressBook {

    Map<String, AddressBookService> multipleAddressBookMap = new HashMap<>();
    Map<String, Person> personMap = new HashMap<String, Person>();
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

    /***
     * created sortAddressBook method to sort by name, city, state and zip
     * @param sortingChoice - passing choice
     */
    public void sortAddressBook(int sortingChoice){
        List<Person> sortedContactList;
        for (String i : multipleAddressBookMap.keySet()) {
            Map<String, Person> contactList = multipleAddressBookMap.get(i).multipleAddressBook.personMap;

            switch(sortingChoice) {

                case 1: sortedContactList = contactList.values()
                                                       .stream()
                                                       .sorted((firstPerson, secondPerson) -> firstPerson.getFirstName().compareTo(secondPerson.getFirstName()))
                                                       .collect(Collectors.toList());
                    printSortedList(sortedContactList);
                    break;

                case 2: sortedContactList = contactList.values()
                                                        .stream()
                                                        .sorted((firstPerson, secondPerson) -> firstPerson.getCity().compareTo(secondPerson.getCity()))
                                                        .collect(Collectors.toList());
                    printSortedList(sortedContactList);
                    break;

                case 3: sortedContactList = contactList.values()
                                                        .stream()
                                                        .sorted((firstPerson, secondPerson) -> firstPerson.getState().compareTo(secondPerson.getState()))
                                                        .collect(Collectors.toList());
                    printSortedList(sortedContactList);
                    break;

                case 4: sortedContactList = contactList.values()
                                                        .stream()
                                                        .sorted((firstPerson, secondPerson) -> Long.valueOf(firstPerson.getZipCode()).compareTo(Long.valueOf(secondPerson.getZipCode())))
                                                        .collect(Collectors.toList());
                    printSortedList(sortedContactList);
                    break;
            }

        }
    }

    /***
     * created printSortedList method to print sorted list
     * @param sortedContactList - passing sortedContactList
     */
    public void printSortedList(List<Person> sortedContactList) {
        System.out.println("------ Sorted Address Book ------");
        Iterator iterator = sortedContactList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}
