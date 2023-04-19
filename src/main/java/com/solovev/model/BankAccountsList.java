package com.solovev.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TODO, done: комментарии лишние убрать, документируемые комментарии сделать над методами и комментарии

/**
 * Class stores all bank accounts. Also, they can be sorted;
 * duplicates allowed
 */
public class BankAccountsList {
    private final ArrayList<BankAccount> accounts;

    public BankAccountsList(BankAccount... accounts) {
        this.accounts = Arrays
                .stream(accounts)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Method sorts bank accounts based on natural order
     */
    public void sort() {
        accounts.sort(null);
    }

    /**
     * method sorts accounts by given comparator
     */
    public void sort(Comparator<BankAccount> comparator) {
        accounts.sort(comparator);
    }

    /**
     * methods that search account for given numberOfAccount, Name, or creation date.
     *
     * @return List<BankAccount> consisting of all found accounts, or empty collection if nothing was found
     */
    public List<BankAccount> search(long numberOfAccount) {
        return search(b -> b.getNUM() == numberOfAccount);
    }

    public List<BankAccount> search(Date dateOfCreation) {
        return search(b -> b.getDATE().equals(dateOfCreation));
    }

    public List<BankAccount> search(String lastName) {
        return search(b -> b.getLastName().equals(lastName));
    }

    /**
     * helper method to return List of bank accounts based on the given Predicate
     *
     * @return sorted List of bank accounts
     */
    private List<BankAccount> search(Predicate<BankAccount> type) {
        return accounts
                .stream()
                .filter(type)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountsList that = (BankAccountsList) o;

        return Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return accounts != null ? accounts.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BankAccountsList{" +
                "accounts=" + accounts +
                '}';
    }
}
