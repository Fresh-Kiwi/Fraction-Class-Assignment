import java.util.Scanner;

class FractionDriver {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Fraction f = new Fraction("10/");
        System.out.println(f.getNum());
        System.out.println(f.getDenom());
        System.out.println(f.toString());
        System.out.println(f.toDouble());
    }
}