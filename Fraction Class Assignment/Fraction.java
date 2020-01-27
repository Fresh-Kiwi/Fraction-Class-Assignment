public class Fraction {
    private int den;
    private int num;
    
    public Fraction() {
        this.num = 1;
        this.den = 1;
    }

    public Fraction(int num, int den) {
        this.num = num;
        if (den == 0) {
            System.out.println("Error, divided by zero.");
            den = 1;
        } else {
            this.den = den;
        }
    }
    
    public Fraction(String f) {
        if (f.indexOf("/") != -1) {
            if (f.indexOf("/") == f.lastIndexOf("/")) {
                int slashIndex = f.indexOf("/");
            } else {
                System.out.println("Error, more than one '/' was found.");
            }
        } else {
            System.out.println("Error, no '/' found.");
        }
    }
}
