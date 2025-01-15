import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    //add contacts
    public void addContact(Person newContact) {
        contacts.add(newContact);
    }

    //print contacts
    public void printContacts() {
        //idk if this works
        for (Person count : contacts) {
            System.out.println(count);
        }
    }

    /*
    1. Add Contact
    2. List All Contacts By First Name
    3. List All Contacts By Last Name
    4. List All Contacts By Phone Number
    5. List All Students
    6. Search By First Name
    7. Search By Last Name
    8. Search by Phone Number
    0. Exit
    */

    //sort
    public void sort(int sortBy) {


    }
}
