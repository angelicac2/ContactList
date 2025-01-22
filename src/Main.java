import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //something
        ArrayList<Person> contacts = new ArrayList<Person>();
        ContactList contactList = new ContactList(contacts);
        contactList.run();
    }
}