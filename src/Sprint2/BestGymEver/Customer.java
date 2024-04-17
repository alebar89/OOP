package Sprint2.BestGymEver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Customer {
    private String socialSecurityNumber;
    private String name;
    private String dateOfPayment;

    public Customer(String socialSecurityNumber, String name, String dateOfPayment) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.dateOfPayment = dateOfPayment;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    private LocalDate stringToDate() {
        return LocalDate.parse(getDateOfPayment(), DateTimeFormatter.ofPattern ("yyyy-MM-dd")).plusYears( 1 );
    }

    public boolean hasValidSubscription() {
        return stringToDate().isAfter(LocalDate.now());
    }

    public String toString() {
        return getSocialSecurityNumber() + ", " + getName() + ", " + LocalDate.now().format(ofPattern("yyyy-MM-dd"));
    }
}
