// Importing necessary packages
import java.util.Date;
import java.text.SimpleDateFormat;

// Package: tents
package tents;

// Abstract class Tent
abstract class Tent {
    String name;

    Tent(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Tent Name: " + name);
    }
}

// Interface WaterProof
interface WaterProof {
}

// Subclass TentA
class TentA extends Tent {
    TentA(String name) {
        super(name);
    }
}

// Subclass TentB implementing WaterProof
class TentB extends Tent implements WaterProof {
    TentB(String name) {
        super(name);
    }
}

// Subclass TentC
class TentC extends Tent {
    TentC(String name) {
        super(name);
    }
}

// Subclass TentD implementing WaterProof
class TentD extends Tent implements WaterProof {
    TentD(String name) {
        super(name);
    }
}

// Class facilities.Baby
package facilities;

import java.util.Date;
import java.text.SimpleDateFormat;

// Class Baby in the package facilities
public class Baby {
    String name;
    Date dateOfBirth;
    Date bcgDate;
    Date polioDropsDate;

    // Constructor to construct the Baby object
    public Baby(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

        // Finding BCG and Polio Drops dates from the date of birth
        long bcgTime = dateOfBirth.getTime() + (60L * 24 * 60 * 60 * 1000);
        bcgDate = new Date(bcgTime);

        long polioTime = dateOfBirth.getTime() + (45L * 24 * 60 * 60 * 1000);
        polioDropsDate = new Date(polioTime);
    }

    // Method to display baby details
    public void displayDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Baby Details:");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + sdf.format(dateOfBirth));
        System.out.println("Date for BCG Injection: " + sdf.format(bcgDate));
        System.out.println("Date for Polio Drops: " + sdf.format(polioDropsDate));
    }

    // Main program
    public static void main(String[] args) {
        // Creating a baby object and displaying its details
        Date dateOfBirth = new Date(); // Replace this with the actual date of birth
        Baby baby = new Baby("Baby1", dateOfBirth);
        baby.displayDetails();
    }
}
