// Interface Property
interface Property {
    double computePrice();
}

// Class Bungalow implementing Property
class Bungalow implements Property {
    String name;
    double constructionArea;
    double landArea;

    Bungalow(String name, double constructionArea, double landArea) {
        this.name = name;
        this.constructionArea = constructionArea;
        this.landArea = landArea;
    }

    @Override
    public double computePrice() {
        double constructionCost = 500 * constructionArea;
        double landCost = 400 * landArea;
        return constructionCost + landCost;
    }
}

// Class Flat implementing Property
class Flat implements Property {
    String name;
    double constructionArea;

    Flat(String name, double constructionArea) {
        this.name = name;
        this.constructionArea = constructionArea;
    }

    @Override
    public double computePrice() {
        double constructionCost = 500 * constructionArea;
        double additionalCost = 200000;
        return constructionCost + additionalCost;
    }
}

// Interface Multiplication
interface Multiplication {
    int multiplication(int a, int b);

    void display();
}

// Class MatrixMultiplication implementing Multiplication
class MatrixMultiplication implements Multiplication {
    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public void display() {
        System.out.println("Matrix Multiplication");
    }
}

// Class IntegerNumberMultiplication implementing Multiplication
class IntegerNumberMultiplication implements Multiplication {
    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public void display() {
        System.out.println("Integer Number Multiplication");
    }
}

// Interface LO
interface LO {
    void lightOn();

    void lightOff();
}

// Class SO implementing LO
class SO {
}

// Class CONE extending SO and implementing LO
class CONE extends SO implements LO {
    @Override
    public void lightOn() {
        System.out.println("Light ON in CONE");
    }

    @Override
    public void lightOff() {
        System.out.println("Light OFF in CONE");
    }
}

// Class CUBE extending SO and implementing LO
class CUBE extends SO implements LO {
    @Override
    public void lightOn() {
        System.out.println("Light ON in CUBE");
    }

    @Override
    public void lightOff() {
        System.out.println("Light OFF in CUBE");
    }
}

// Class LC extending CONE and implementing LO
class LC extends CONE implements LO {
}

// Class LCB extending CUBE and implementing LO
class LCB extends CUBE implements LO {
}

// Interface K1
interface K1 {
    int variable = 1;

    void mK();
}

// Interface K2 extending K1
interface K2 extends K1 {
    void mK();
}

// Interface K3 extending K2
interface K3 extends K2 {
    void mK();
}

// Class U implementing K3
class U implements K3 {
    @Override
    public void mK() {
        System.out.println("Value of variable: " + variable);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Property Interface Usage
        System.out.println("Property Interface Usage");
        Property bungalow = new Bungalow("Bungalow1", 1000, 500);
        Property flat = new Flat("Flat1", 800);
        System.out.println("Bungalow Price: " + bungalow.computePrice());
        System.out.println("Flat Price: " + flat.computePrice());

        // Multiplication Interface Usage
        System.out.println("\nMultiplication Interface Usage");
        Multiplication matrixMultiplication = new MatrixMultiplication();
        Multiplication integerNumberMultiplication = new IntegerNumberMultiplication();
        matrixMultiplication.display();
        System.out.println("Result: " + matrixMultiplication.multiplication(3, 4));
        integerNumberMultiplication.display();
        System.out.println("Result: " + integerNumberMultiplication.multiplication(5, 6));

        // LO Interface Usage
        System.out.println("\nLO Interface Usage");
        LO lc = new LC();
        LO lcb = new LCB();
        lc.lightOn();
        lc.lightOff();
        lcb.lightOn();
        lcb.lightOff();

        // K1, K2, K3 Interface Usage
        System.out.println("\nK1, K2, K3 Interface Usage");
        U uObject = new U();
        uObject.mK();
    }
}
