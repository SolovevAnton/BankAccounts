package com.solovev;

import java.text.ParseException;

/*Class for testing purposes*/
public class Test {

    static public void main(String args[])  throws ParseException {
    BankAccount[] accounts= {
            new BankAccount(1,2,"anton",10,"12.11.2022",5),
            new BankAccount(-1,-2,"anna",-10,"1.1.2022",-5)
    };

    for (BankAccount b : accounts){
        System.out.println(b);
    }
    }
}
