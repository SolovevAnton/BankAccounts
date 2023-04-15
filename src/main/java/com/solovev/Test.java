package com.solovev;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;

/*Class for testing purposes*/
public class Test {

    static public void main(String args[])  throws ParseException {
    BankAccount[] accounts= {
            new BankAccount(1,2,"anton",10,"1.1.2022",5),
            new BankAccount(1,2,"anton",10,"1.1.2022",5),
            new BankAccount(-1,-2,"anna",-10,"12.12.2022",-5),
            new BankAccount(1,2,"AnnaLate",1,"13.12.2022",-5)
    };
        Comparator[] comparators ={
                BankAccountsList.BY_NUM,
                BankAccountsList.BY_DATE,
                BankAccountsList.BY_NAME,
                BankAccountsList.BY_ALL
        };
    BankAccountsList acc= new BankAccountsList(accounts);

    for (Comparator c : comparators) {
        acc.sort(c);
        System.out.println(acc + "\n");
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    System.out.println(acc.search(-1));
    System.out.println(acc.search(5l));
    System.out.println(acc.search(dateFormat.parse("12.12.2022")));
    System.out.println(acc.search(dateFormat.parse("5.12.1999")));
    System.out.println(acc.search("anton"));
    System.out.println(acc.search("Anton"));


    }
}
