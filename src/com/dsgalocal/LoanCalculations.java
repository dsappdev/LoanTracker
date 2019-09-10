
package com.dsgalocal;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Doug
 */
public class LoanCalculations {
    
    int NUMBER_OF_DAYS_IN_YEAR = 365;
    
    /**
     * Calculates the difference between the current date and the 
     * date the last payment was made.
     * 
     * @param lastPymntDate
     * @return long value for the number of days since the last
     *         payment was made.
     */
    public long calculateDaysSinceLastPayment(LocalDate lastPymntDate) {
        return ChronoUnit.DAYS.between(ZonedDateTime.now(), lastPymntDate);
    }
    
    /**
     * Calculates the amount of interest which has accrued 
     * since the last payment. NOTE: any fraction should
     * always round down.
     * 
     * @param loan 
     * @return 
     */
    public double calculateInterestAccrued(Loan loan) {        
        return (loan.principalBalance * loan.interestRate / NUMBER_OF_DAYS_IN_YEAR) * 
                calculateDaysSinceLastPayment(loan.lastPaymentDate);        
    }
    
    // apply payment
    public void applyPayment(Loan loan) {
        double currentInterest = 0.0d;
        double principalPaid = 0.0d;
        while(loan.principalBalance > 0) {            
            currentInterest = calculateInterestAccrued(loan);

            if(loan.principalBalance >= loan.monthlyPayment && loan.principalBalance >= loan.monthlyPayment) {
               principalPaid = loan.monthlyPayment - currentInterest;
            } else if(loan.principalBalance < loan.monthlyPayment) {
                loan.paymentAmount = loan.principalBalance + currentInterest;
            } else {
               principalPaid = loan.principalBalance + currentInterest;
            }
        }
    }
    
    
    
}
