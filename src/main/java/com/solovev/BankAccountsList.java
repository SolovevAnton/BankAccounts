package com.solovev;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*Class stores all bank accounts. Also, they can be sorted
* duplicates allowed*/
public class BankAccountsList {
    /*Collection to store bank accounts*/
    private ArrayList<BankAccount> accounts;
    /*
    * List of Comparators used to sort the collection
    * These comparators are described like constants
    * later cam be put in Map?? or ENUM??
    * */
    static public final Comparator<BankAccount> BY_NUM = Comparator.comparing(BankAccount::getNUM);
    static public final Comparator<BankAccount> BY_NAME = Comparator.comparing(BankAccount::getLastName);
    static public final Comparator<BankAccount> BY_DATE = Comparator.comparing(BankAccount::getDATE);
    /*Comparator used to sort by all fields in the order: Num, Date, Name
    * */
    static public final Comparator<BankAccount> BY_ALL = BY_NUM.thenComparing(BY_DATE).thenComparing(BY_NAME);
   /*if null appears as a BankAccount object it is just thrown away*/
    public BankAccountsList(BankAccount...accounts){
        this.accounts = Arrays
                .stream(accounts)
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*method sorts accounts by given comparator*/
    public void sort(Comparator<BankAccount> comparator){
        accounts.sort(comparator);
    }
    /*methods that search account for given numberOfAccount, Name, or creation date.
    * @return List<BankAccount> consisting of all found accounts, or empty collection if nothing was found*/
    public List<BankAccount> search(long numberOfAccount){
        return searchFor(b-> b.getNUM() == numberOfAccount);
    }
    public List<BankAccount> search(Date dateOfCreation){
        return searchFor(b-> b.getDATE().equals(dateOfCreation));
    }
    public List<BankAccount> search(String lastName){
        return searchFor(b-> b.getLastName().equals(lastName));
    }
    /*helper method to return List of bank accounts based on the given Predicate*/
    private List<BankAccount> searchFor(Predicate<BankAccount> type){
        return accounts
                .stream()
                .filter(type)
                .collect(Collectors.toList());
    }
    public ArrayList<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        if(accounts == null) { throw new NullPointerException("accounts can't be null");}
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "BankAccountsList{" +
                "accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountsList that = (BankAccountsList) o;

        return getAccounts() != null ? getAccounts().equals(that.getAccounts()) : that.getAccounts() == null;
    }

    @Override
    public int hashCode() {
        return getAccounts() != null ? getAccounts().hashCode() : 0;
    }
}
