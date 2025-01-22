import java.util.ArrayList;
import java.util.Scanner;


public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    // Getter to create ArrayList
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Adds contacts to arrayList that keeps contacts all together
    public void addContact(Person newContact) {
        contacts.add(newContact);
    }

    // Prints contacts in arrayList, in whatever order it is modified to
    public void printContacts() {
        for (Person count : contacts) {
            System.out.println(count);
        }
        System.out.print("\n");
    }

    // Swap function because it repeats in all of the sort functions
    public void change(int j) {
        // Use temporary variable to swap index value and index + 1 value
        Person temp = contacts.get(j);
        contacts.set(j, contacts.get(j + 1));
        contacts.set(j+ 1, temp);
    }

    // Sort function using bubble sort
    public void sort(int sortBy) {
        int length = contacts.size();
        // If sortBy = 0, sort is comparing the first name of each contact, sorting them by alphabetical order
        if (sortBy == 0) {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < (length - i - 1); j++) {
                    // CompareTo compares two strings lexicographically
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        change(j);
                    }
                }
            }
        }
        // If sortBy = 1, sort is comparing the last name of each contact, sorting them by alphabetical order
        else if (sortBy == 1) {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < (length - i - 1); j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        change(j);
                    }
                }
            }
        }
        // If sortIf = 2, sort is comparing the phone of each contact, sorting them by smallest to largest number
        else {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < (length - i - 1); j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        change(j);
                    }
                }
            }
        }
    }

    // Searching if the user input of a first name is a contact in the contact list
    public Person searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            // Using .equals to compare two strings
            if (firstName.equals(contacts.get(i).getFirstName())) {
                return contacts.get(i);
            }
        }
        // If the user's inputted first name is not in the list, print a statement to tell user
        System.out.println(firstName + " is not in the list.");
        return null;
    }

    // Searching if the user input of a last name is a contact in the contact list
    public Person searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (lastName.equals(contacts.get(i).getLastName())) {
                return contacts.get(i);
            }
        }
        System.out.println(lastName + " is not in the list.");
        return null;
    }

    // Searching if the user input of a phoneNumber is a contact in the contact list
    public Person searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
                return contacts.get(i);
            }
        }
        System.out.println("#" + phoneNumber + " is not in the list.");
        return null;
    }

    // Printing the list of contacts if they are Student objects
    public void listStudents() {
        String listS = "";
        for (int i = 0; i < contacts.size(); i++) {
            // Use instanceof to determine the object type of the contact
            if (contacts.get(i) instanceof Student) {
                listS += contacts.get(i) + " \n";
            }
        }
        System.out.println(listS);
    }

    // 0-8 of the possible options that a user can pick
    public void pickOption() {
        System.out.println("Menu: " + "\n" + "1. Add Contact \n" +
                "2. List All Contacts By First Name\n" +
                "3. List All Contacts By Last Name\n" +
                "4. List All Contacts By Phone Number\n" +
                "5. List All Students\n" +
                "6. Search By First Name\n" +
                "7. Search By Last Name\n" +
                "8. Search by Phone Number\n" +
                "0. Exit");
    }

    // Main intel of the class
    public void run() {
        System.out.println("Welcome to ContactList." + "\n"
                + "Please pick from the following menu options.");
        pickOption();
        // Create scanner and ask for user input to start making a contactList
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        // When the user doesn't enter 0 (exit button), then continue to ask user for pickOption() function
        while (!(userInput.equals("0"))) {
            if (userInput.equals("1")) {
                // Asking user what object they want to make
                System.out.println("Select a type of contact to add: " + "\n" +
                        "1. Student" + "\n"
                        + "2. Coach");
                // If they want to make a student, use Student class that extends Person
                if (s.nextLine().equals("1")) {
                    System.out.println("Please fill in the following information. " + "\n" +
                            "first name: ");
                    String firstName = s.nextLine();
                    System.out.println("last name: ");
                    String lastName = s.nextLine();
                    System.out.println("phone number: ");
                    String phoneNumber = s.nextLine();
                    System.out.println("grade: ");
                    int grade = s.nextInt();
                    s.nextLine();
                    // Using polymorphism, object type is a student, but reference type is a person so all persons
                    //can be grouped in an arrayList
                    Person newPerson = new Student(firstName, lastName, phoneNumber, grade);
                    addContact(newPerson);
                }
                else {
                    System.out.println("Please fill in the following information. " + "\n" +
                            "first name: ");
                    String firstName = s.nextLine();
                    System.out.println("last name: ");
                    String lastName = s.nextLine();
                    System.out.println("phone number: ");
                    String phoneNumber = s.nextLine();
                    System.out.println("sport: ");
                    String sport = s.nextLine();
                    // If they want to make a coach, use Coach class that extends Person
                    Person newPerson = new Coach(firstName, lastName, phoneNumber, sport);
                    addContact(newPerson);
                }
            }
            else if (userInput.equals("2")) {
                // Listing all contacts by sort = 0; firstName
                sort(0);
                printContacts();
            }
            else if (userInput.equals("3")) {
                // Listing all contacts by sort = 1; lastName
                sort(1);
                printContacts();
            }
            else if (userInput.equals("4")) {
                // Listing all contacts by sort = 2; phoneNumber
                sort(2);
                printContacts();
            }
            else if (userInput.equals("5")) {
                listStudents();

            }
            else if (userInput.equals("6")) {
                // Searching firstName of user input in contact list
                System.out.println("Enter a name: ");
                String name = s.nextLine();
                System.out.println(searchByFirstName(name) + "\n");
            }
            else if (userInput.equals("7")) {
                // Searching lastName of user input in contact list
                System.out.println("Enter a name: ");
                String name = s.nextLine();
                System.out.println(searchByLastName(name) + "\n");

            }
            else if (userInput.equals("8")) {
                // Searching phoneNumber of user input in contact list
                System.out.println("Enter a phone number: ");
                String phoneNumber = s.nextLine();
                System.out.println(searchByPhoneNumber(phoneNumber) + "\n");
            }
            // Re-ask user for pickOption() because they haven't entered 0 yet
            pickOption();
            userInput = s.nextLine();
        }
    }
}
