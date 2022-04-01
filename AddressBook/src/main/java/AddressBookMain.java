public class AddressBookMain {

    /***
     * main method for manipulation
     * @param args - default param(not used)
     */
    public static void main(String[] args) {
        /***
         * PROCEDURE
         * 1. created addressBookService object
         * 2. calling addPerson and showPerson methods
         */
        System.out.println("Welcome to Address Book System");
        /***
         * 1. created addressBookService object
         */
        AddressBookService addressBookService = new AddressBookService();
        /***
         * 2. calling addPerson and showPerson methods
         */
        addressBookService.addPerson();
        addressBookService.showPerson();
    }
}
