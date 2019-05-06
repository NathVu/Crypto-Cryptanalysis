import java.util.*;
import java.math.BigInteger;

//Reminder:adapt for BigIntegers - read in strings and convert with cunstructor
public class pollard{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int initMod, initB, initBase = 1;
        System.out.println("\nPlease Enter the Modulus\n");
        initMod = input.nextInt();
        //This is any B chosen by the user, we want the number to be "B smooth"
        System.out.println("\nPlease Enter the B\n");
        initB = input.nextInt();
        BigInteger Mod = BigInteger.valueOf(initMod);
        BigInteger Fact = BigInteger.valueOf(factorial(initB));
        BigInteger Base = BigInteger.valueOf(initBase);
        int answer = 0;
        do{
            Base = Base.add(BigInteger.valueOf(1));
            answer = pollard(Mod, Fact, Base).intValue();
        } while(euclid(initMod,answer-1)==1);
        System.out.println("\nA factor of " + initMod + " is " + euclid(initMod,answer-1));
        System.out.println("The base is " + Base.intValue() + " and the B is " + initB);

    }

    public static int euclid(int a, int b){
        if(b==0)
            return a;
        if(b==1)
            return b;
        return euclid(b,a%b);
    }

    public static BigInteger pollard(BigInteger Mod, BigInteger BFact, BigInteger Base){
        return Base.modPow(BFact,Mod);

    }

    public static int factorial(int a) {
        if(a == 1)
            return 1;
        return a * factorial(a-1);
    }
}
