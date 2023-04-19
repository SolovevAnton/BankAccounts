package com.solovev;

import com.solovev.model.BankAccount;
import com.solovev.model.BankAccountsList;

import java.text.ParseException;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    //TODO, done компараторы вынести в места где они используются
    /*
     * List of Comparators used to sort the collection
     */
    static public final Comparator<BankAccount> BY_NUM = Comparator.comparing(BankAccount::getNUM);
    static public final Comparator<BankAccount> BY_NAME = Comparator.comparing(BankAccount::getLastName);
    static public final Comparator<BankAccount> BY_DATE = Comparator.comparing(BankAccount::getDATE);

    static public void main(String[] args) throws ParseException {
        BankAccount[] accounts = {
                new BankAccount(1, 2, "anton", 10, "1.1.2022", 5),
                new BankAccount(1, 2, "anton", 10, "1.1.2022", 5),
                new BankAccount(-1, -2, "anna", -10, "12.12.2022", -5),
                new BankAccount(1, 2, "AnnaLate", 1, "13.12.2022", -5)
        };
        List<Comparator<BankAccount>> comparators = List.of(
                BY_NUM,
                BY_DATE,
                BY_NAME
        );
        BankAccountsList acc = new BankAccountsList(accounts);

        for (Comparator<BankAccount> c : comparators) {
            acc.sort(c);
            System.out.println(acc + "\n");
        }
        acc.sort(null);
        acc.sort();
        System.out.println(acc+"\n");


        //TODO, done если в метод сортировки подать вместо компаратора null, то тогда сортировка может идти методом compareTo

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println(acc.search(-1));
        System.out.println(acc.search(5L));
        System.out.println(acc.search(dateFormat.parse("12.12.2022")));
        System.out.println(acc.search(dateFormat.parse("5.12.1999")));
        System.out.println(acc.search("anton"));
        System.out.println(acc.search("Anton"));


    }
}
