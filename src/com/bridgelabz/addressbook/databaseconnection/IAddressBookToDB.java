package com.bridgelabz.addressbook.databaseconnection;

public interface IAddressBookToDB {
    void getData();
    void getDataByTimeStamp(String start_time,String end_time);
}
