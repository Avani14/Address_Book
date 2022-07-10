package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.databaseconnection.AddressBookToDB;

import java.util.Scanner;

public class AddressBookDriver {
    public static void main(String[] args) {

        System.out.println("---Welcome to Address Book---");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String option;
        AddressBookToDB addressBookToDB = new AddressBookToDB();
        while(true) {
            System.out.println(" ---- MENU ----");
            System.out.println(" 1. Add Address Book\n 2. Add contacts\n 3. Display contacts" +
                    "\n 4. Edit contact\n 5. Delete Contact\n 6. Find Contacts with same state" +
                    "\n 7. Find Contacts with same city \n 8.Sort the contacts by City State Or Zip.\n 9. Exit");
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
//                    AddressBookService.displayByOrder();
                    addressBookToDB.getData();
                    sc.nextLine();
                    System.out.println("Enter the start time");
                    String start_time = sc.nextLine();
                    System.out.println("Enter the end time");
                    String end_time = sc.nextLine();
                    addressBookToDB.getDataByTimeStamp(start_time,end_time);
                    break;
                case "4":
                    AddressBookService.editContact();
                    break;
                case "5":
                    AddressBookService.deleteContact();
                    break;
                case "6":
                    System.out.println("Enter the state: ");
                    String state = sc.next();
                    AddressBookService.findSameStateContacts(state);
                    break;
                case "7":
                    System.out.println("Enter the city: ");
                    String city = sc.next();
                    AddressBookService.findSameCityContacts(city);
                    break;
                case "8":
                    int option2;
                    System.out.println("\t\nEnter 1: To sort by city:\nEnter 2: To sort by state:\nEnter 3: To sort by zip:");
                    option2 = sc.nextInt();
                    switch (option2){
                        case 1 : AddressBookService.sortByCity();
                            break;
                        case 2 : AddressBookService.sortByCity();
                            break;
                        case 3:AddressBookService.sortByZip();
                            break;
                    }
                    break;
                case "9":
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Please enter a valid choice: ");
            }

        }


    }
}