import java.util.Scanner;

public class AddressBookMain {

    /***
     * main method for manipulation
     * @param args - default param(not used)
     */
    public static void main(String[] args) {
        /***
         * PROCEDURE
         * 1. creating addressBook
         * 2. iterating while loop for choice
         */

        /***
         * 1. creating addressBook
         */
        AddressBookService addressBookService = new AddressBookService();
        /***
         * 2. iterating while loop for choice
         */
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("1. Add contact \n2. Edit contact \n3. Show contact\n4. Delete contact" +
                               "5. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    addressBookService.addContact();
                    break;
                case 2 :
                    System.out.print("Enter first name : ");
                    String firstName = sc.next();
                    addressBookService.editByName(firstName);
                    break;
                case 3 :
                    addressBookService.showContact();
                    break;
                case 4 :
                    addressBookService.deleteContact();
                    break;
                case 5 :
                    System.exit(0);
                    break;
                default :
                    break;
            }
        }
    }
}
