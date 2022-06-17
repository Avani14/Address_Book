package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookDriver {
    public static void main(String[] args) {

        System.out.println("---Welcome to Address Book---");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String option;
        while(true) {
            System.out.println(" ---- MENU ----");
            System.out.println(" 1. Add Address Book\n 2. Add contacts\n 3. Display contacts\n 4. Edit contact\n 5. Delete Contact\n 6. Exit");
            option = sc.next();

            switch (option) {

                case "1":
                    AddressBookService.addAddressBook();
                    break;
                case "2":
                    String addressBook;
                    System.out.println("Enter the address book:");
                    addressBook = sc.next();
                    AddressBookService.addContact(addressBook);
                    break;
                case "3":
                    AddressBookService.display();
                    break;
                case "4":
                    AddressBookService.editContact();
                    break;
                case "5":
                    AddressBookService.deleteContact();
                    break;
                case "6":
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Please enter a valid choice: ");
            }

        }


    }
}