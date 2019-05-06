import java.util.*;
import java.math.BigInteger;
import javafx.util.Pair;


public class Weiner{
    static ArrayList<Fraction> frac = new ArrayList<Fraction>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the exponent and then the modulus");
        BigInteger exponent = BigInteger.valueOf(input.nextInt());
        BigInteger mod = BigInteger.valueOf(input.nextInt());
        Fraction work = new Fraction(exponent,mod);
        Pair<BigInteger,BigInteger> flag = new Pair<>(BigInteger.valueOf(0),BigInteger.valueOf(0));
        do{
            flag = work.expandedFrac();
            System.out.println("Here");
            BigInteger K = flag.getKey();
            BigInteger D = flag.getValue();
            BigInteger C = testC(exponent,mod,K,D);
            flag = findRoot(mod,C);
        }while(flag.getValue().intValue()==0);
        System.out.println("The Roots for " + mod + " are " + flag.getKey() + " and " + flag.getValue());

    }

    public static Fraction testKD(ArrayList<Fraction> frac){
        BigInteger K, C, D;
        Fraction temp = new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(1));
        for(int i = frac.size(); i > 0; i--) {
            temp.equals(frac.get(i-1).divide(temp));
            System.out.println("I am here");
        }
        return temp;
    }

    public static BigInteger testC(BigInteger exp, BigInteger mod, BigInteger k, BigInteger d/*boolean works*/) {
        double test = ((exp.doubleValue()*d.doubleValue()) - 1)/k.intValue();
        if(!((Math.ceil(test) - test < .000000001) || (test - Math.floor(test) <=0.000000001))){
            //works = false;
            return BigInteger.valueOf(0);
        }
        //works = true;
        return(BigInteger.valueOf((int)test));
    }

    public static Pair<BigInteger, BigInteger> findRoot(BigInteger mod, BigInteger C) {
        Pair<BigInteger,BigInteger> fail = new Pair<>(BigInteger.valueOf(0),BigInteger.valueOf(0));
        double a = 1;
        double b = -(mod.doubleValue()-C.doubleValue()+1);
        double c = mod.doubleValue();
        double posTest = (-b+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
        if(!((Math.ceil(posTest) - posTest < .000000001) || (posTest - Math.floor(posTest) <=0.000000001))){
            return fail;
        }
        double negTest = (-b+Math.sqrt(Math.pow(b,2)-(4*a*c)))/(2*a);
        if(!((Math.ceil(negTest) - negTest < .000000001) || (negTest - Math.floor(negTest) <=0.000000001))){
            return fail;
        }
        int root1 = (int)posTest;
        int root2 = (int)negTest;
        if(root1 * root2 == mod.intValue()){
            Pair<BigInteger,BigInteger> success = new Pair<>(BigInteger.valueOf(root1),BigInteger.valueOf(root2));
            return success;
        }
        return fail;
    }
}
