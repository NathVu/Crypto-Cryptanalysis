import java.math.BigInteger;
import java.util.*;
import javafx.util.Pair;
//A Class that can hold BigInteger fractions and has methods for those fractions
public class Fraction {
    private BigInteger numerator;
    private BigInteger denominator;
    private ArrayList<Fraction> frac = new ArrayList<Fraction>();

    //the default constructor
    public Fraction(){}

    //the constructor for the Fraction class, it accepts 2 BigIntegers and
    //takes the GCD of them to simplify them, then sets the numerator and
    //denominator
    public Fraction(BigInteger a, BigInteger b){
        numerator = a;
        denominator = b;
        frac.add(this);
    }

    public Pair<BigInteger, BigInteger> expandedFrac(){
        int a = frac.size();
        BigInteger tempNum = this.getNumerator().divide(BigInteger.valueOf((int)Math.pow(10,a)));
        BigInteger tempDenom = this.getDenominator().divide(BigInteger.valueOf((int)Math.pow(10,a)));
        Fraction temp = new Fraction(tempNum,tempDenom);
        frac.add(temp);
        for(int i = a; i > 0; i--) {
            temp = frac.get(i-1).divide(temp);
        }
        System.out.println(a);
        Pair<BigInteger,BigInteger> ret = new Pair<>(temp.getNumerator(), temp.getDenominator());
        return ret;

    }

    //returns the numerator of this object
    public BigInteger getNumerator(){
        return this.numerator;
    }

    //returns the denominator of this object
    public BigInteger getDenominator() {
        return this.denominator;
    }

    //sets the numerator of this object
    public void setNumerator(BigInteger a){
        numerator = a;
    }

    //sets the denominator of this object
    public void setDenominator(BigInteger b){
        denominator = b;
    }

    //accepts a Fraction and divides this by the Fraction
    //(mutliplies the numerator of a by denominator of b and
    //denominator of a by the numerator of b)
    public Fraction divide(Fraction a){
        return new Fraction(this.numerator.multiply(a.getDenominator()),this.denominator.multiply(a.getNumerator()));
    }

    public void equals(Fraction a){
        this.numerator = a.getNumerator();
        this.denominator = a.getDenominator();
    }

    //recursively calls itself to find the greatest common factor
    //of 2 numbers that are passed to it
    public int euclid(int a, int b){
        if(b==0)
            return a;
        if(b==1)
            return b;
        return euclid(b,a%b);
    }
}
