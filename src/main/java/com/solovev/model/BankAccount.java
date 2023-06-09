package com.solovev.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BankAccount implements Comparable<BankAccount> {

    private final long NUM;
    private int code;
    private String lastName;

    private double deposit;
    /**
     * date of account opening
     */
    private final Date DATE;
    /**
     * rate of return in %
     */
    private double rate;

    public BankAccount(long num, int code, String lastName, double initialDeposit, String dateOfOpening, double rateOfReturn) throws ParseException {
        this.NUM = num;
        this.code = code;
        setLastName(lastName);
        this.deposit = initialDeposit;
        if (dateOfOpening == null) {
            throw new NullPointerException("Date cant be null");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.DATE = dateFormat.parse(dateOfOpening);
    }

    /**
     * Method to compare Bank Accounts. Comparing is done first by number, then by date then by name
     *
     * @param other the object to be compared.
     * @return > then 0 if this is > then other
     */
    @Override
    public int compareTo(BankAccount other) {
        return Comparator.comparing(BankAccount::getNUM)
                .thenComparing(BankAccount::getDATE)
                .thenComparing(BankAccount::getLastName)
                .compare(this, other);
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "NUM=" + NUM +
                ", code=" + code +
                ", lastName='" + lastName + '\'' +
                ", deposit=" + deposit +
                ", date=" + DATE +
                ", rate=" + rate +
                '}';
    }

    public long getNUM() {
        return NUM;
    }

    public Date getDATE() {
        return DATE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("Last Name cant be null");
        }
        this.lastName = lastName;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (getNUM() != that.getNUM()) return false;
        if (getCode() != that.getCode()) return false;
        if (Double.compare(that.getDeposit(), getDeposit()) != 0) return false;
        if (Double.compare(that.getRate(), getRate()) != 0) return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        return getDATE() != null ? getDATE().equals(that.getDATE()) : that.getDATE() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getNUM() ^ (getNUM() >>> 32));
        result = 31 * result + getCode();
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        temp = Double.doubleToLongBits(getDeposit());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getDATE() != null ? getDATE().hashCode() : 0);
        temp = Double.doubleToLongBits(getRate());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
