package com.solovev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
    /*unique account number*/
    private final long NUM;
    private int code;
    private String lastName;
    /*
    * deposit in euros*/
    private double deposit;
    /*date of account opening */
    private final Date DATE;
    /*
    rate of return in %
    */
    private double rate;
    public BankAccount(long num, int code, String lastName, double initialDeposit, String dateOfOpening, double rateOfReturn) throws ParseException {
        this.NUM = num;
        this.code = code;
        this.lastName = lastName;
        this.deposit = initialDeposit;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.DATE = dateFormat.parse(dateOfOpening);
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
        if()
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
