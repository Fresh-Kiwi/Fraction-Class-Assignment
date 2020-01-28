public class Fraction {
    private int num;
    private int den;
    
    //Constructors
    public Fraction() {
        System.out.println("No parameters found, setting fraction to '1/1'.");
        this.num = 1;
        this.den = 1;
    }

    public Fraction(int num, int den) {
        this.num = num;
        
        if (den == 0) {
            System.out.println("Error, divided by zero. Setting denominator to '1'.");
            this.den = 1;
        } else {
            this.den = den;
        }
    }
    
    public Fraction(String f) {
        int slashIndex = -1;
        f = f.trim();
        
        if (f.length() >= 3) {
            if (f.indexOf("/") != -1) {
                if (f.indexOf("/") == f.lastIndexOf("/")) {
                    boolean errorFound = false;
                    for (int i = 0; i < f.length(); i++) {
                        if (Character.isDigit(f.charAt(i)) == false && f.charAt(i) != '/') {
                            errorFound = true;
                        }
                    }
                    if (errorFound == false) {
                        if (f.indexOf("/") != 0 || f.indexOf("/") != f.length() - 1) {
                            slashIndex = f.indexOf("/");
                        } else {
                            System.out.println("Error, no numbers found before or after '/'.");
                            slashIndex = -1;
                        }
                    } else {
                        System.out.println("Error, non-digit character found in string.");
                        slashIndex = -1;
                    }
                } else {
                    System.out.println("Error, more than one '/' was found.");
                    slashIndex = -1;
                }
            } else {
                System.out.println("Error, no '/' found.");
                slashIndex = -1;
            }
        } else {
            System.out.println("Error, string is less than 3 characters long.");
            slashIndex = -1;
        }
        
        if (slashIndex != -1) {
            this.num = Integer.parseInt(f.substring(0, slashIndex));
            if (Integer.parseInt(f.substring(slashIndex + 1, f.length())) != 0) {
                this.den = Integer.parseInt(f.substring(slashIndex + 1, f.length()));
            } else {
                System.out.println("Error, divided by zero. Setting denominator to '1'.");
                this.den = 1;
            }
        } else {
            System.out.println("Setting fraction to '1/1'.");
            this.num = 1;
            this.den = 1;
        }
    }
    
    public Fraction(Fraction f) {
        System.out.println("Making copy of fraction: '" + f + "'.");
        this.num = num;
        this.den = den;
    }
    //Constructors
    
    //Accessor Methods
    public int getNum() {
        return this.num;
    }
    
    public int getDenom() {
        return this.den;
    }
    
    public String toString() {
        String s = this.num + "/" + this.den;
        return s;
    }
    
    public double toDouble() {
        double d = (double)this.num / (double)this.den;
        return d;
    }
    //Accessor Methods
    
    //Mutator Methods
    public void reduce() {
        int d = 1;
        
        while (d <= Math.min(this.num, this.den)) {
            if (this.num % d == 0 && this.den % d == 0) {
                this.num = this.num/d;
                this.den = this.den/d;
                d = 1;
            }
            d++;
        }
    }
    
    public void setNum(int n) {
        this.num = n;
    }
    
    public void setDenom(int d) {
        if (d != 0) {
            this.den = d;
        } else {
            System.out.println("Error, divided by zero. Denominator will remain the same.");
        }
    }
    //Mutator Methods
    
    //Static Methods
    public Fraction multiply(Fraction f1, Fraction f2) {
        int tnum = 1;
        int tden = 1;
        
        tnum = f1.num * f2.num;
        tden = f1.den * f2.den;
        
        return new Fraction(tnum, tden);
    }
    
    public Fraction divide(Fraction f1, Fraction f2) {
        int tnum = 1;
        int tden = 1;
        
        tnum = f1.num * f2.den;
        tden = f1.den * f2.num;
        
        return new Fraction(tnum, tden);
    }
    
    public Fraction add(Fraction f1, Fraction f2) {
        int tnum = 1;
        int tden = 1;
        
        tden = f1.den * f2.den;
        tnum = (f1.num * f2.den) + (f2.num * f1.den);
        
        return new Fraction(tnum, tden);
    }
    
    public Fraction subtract(Fraction f1, Fraction f2) {
        int tnum = 1;
        int tden = 1;
        
        tden = f1.den * f2.den;
        tnum = (f1.num * f2.den) - (f2.num * f1.den);
        
        return new Fraction(tnum, tden);
    }
    //Static Methods
    
    //Helper Methods
    
    //Currently broken, send help :(
    public int GCF(int n1, int n2) {
        int t = n1 - n2;
        
        while (n1 != t) {
            t = n1 - n2;
        }
        
        return 1;
    }
    //Currently broken, send help :(
    
    //Helper Methods
}
