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
                    "\n 7. Find Contacts with same city \n 8.Sort the contacts by City State Or Zip.\n 10. Exit");
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
//                    AddressBookService.editContact();
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    System.out.println("Enter the first name");
                    String first_name = sc.next();
                    System.out.println("Enter 1 to edit address\nEnter 2 to edit city\nEnter 3 to edit state\nEnter 4 to edit zip" +
                            "\nEnter 5 to edit phone_number\nEnter 3 to edit email");
                    int option2  = sc.nextInt();
                    switch (option2){
                        case 1:
                            System.out.println("Enter the updated address");
                            String address = sc.nextLine();
                            addressBookToDB.updateData("address",address,name,first_name);
                            break;
                        case 2:
                            System.out.println("Enter the updated city");
                            String city = sc.next();
                            addressBookToDB.updateData("city",city,name,first_name);
                            break;
                        case 3:
                            System.out.println("Enter the updated state");
                            String state = sc.next();
                            addressBookToDB.updateData("state",state,name,first_name);
                            break;
                        case 4:
                            System.out.println("Enter the updated zip");
                            int zip = sc.nextInt();
                            addressBookToDB.updateData("zip", String.valueOf(zip),name,first_name);
                            break;
                        case 5:
                            System.out.println("Enter the phone number");
                            long phone_number = sc.nextLong();
                            addressBookToDB.updateData("phone_number", String.valueOf(phone_number),name,first_name);
                            break;
                        case 6:
                            System.out.println("Enter the email address");
                            String email = sc.next();
                            addressBookToDB.updateData("email",email,name,first_name);
                            break;
                        default:
                            System.out.println("Please enter valid option");
                    }
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
                    int opt;
                    System.out.println("\t\nEnter 1: To sort by city:\nEnter 2: To sort by state:\nEnter 3: To sort by zip:");
                    opt = sc.nextInt();
                    switch (opt){
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