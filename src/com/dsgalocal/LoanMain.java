
package com.dsgalocal;

import java.io.IOException;
import java.util.HashMap;


/**
 * Demonstrates the LoanReader reads the loan information and 
 * relays it back to the user.
 * 
 * @author Doug
 */
public class LoanMain {
    
    public static void main(String[] args) throws IOException {
        
        LoanReader lr = new LoanReader();
        HashMap<Integer, Loan> myLoans = 
                lr.readLoanData("src/com/dsgalocal/SampleLoanData.txt");
        
        System.out.println(myLoans.get(1).toString());
        System.out.println(myLoans.get(2).toString());
        System.out.println(myLoans.get(3).toString());
        System.out.println(myLoans.get(4).toString());
        
    }
}
