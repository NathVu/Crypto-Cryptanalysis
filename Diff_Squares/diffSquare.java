import java.util.*;

public class diffSquare{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the number\n");
        int x = input.nextInt();
        int primeOfX = (int)Math.ceil(Math.sqrt(x));
        System.out.println(primeOfX);
        double test = 0.0;
        for(int i = 0; i < x; i++) {
            test = Math.sqrt(Math.pow((primeOfX),2) - x);
            if((Math.ceil(test) - test < .000000001) || (test - Math.floor(test) <=0.000000001)){
                System.out.println("\nA is: " + primeOfX + "\nB is: " + test + "\n");
                break;
            }
            primeOfX++;
        }
        System.out.println("\nFactors of: " + x + " are " + (primeOfX - test) + " and " + (primeOfX + test));
    }

}
