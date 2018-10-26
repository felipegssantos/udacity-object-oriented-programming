public class Main {
    public static void main(String [] args){
        ContactsManager myContactsManager = new ContactsManager();
        Contact firstContact = new Contact("Joe Doe", "joedoe@j.com", "123456");
        myContactsManager.addContact(firstContact);
        Contact secondContact = new Contact("Moe Koe", "moekoe@j.com", "684135");
        myContactsManager.addContact(secondContact);
        Contact thirdContact = new Contact("Poe Yoe", "joedoe@j.com", "685421");
        myContactsManager.addContact(thirdContact);
        Contact searchedContact = myContactsManager.searchContact("Joe Doe");
        System.out.println(searchedContact.phoneNumber);
    }
}
