package mainClasses;
public class Fraction implements Cloneable,Comparable {
    private final int numerator;
    private final int denominator;

    public static void main(String[] args)
    {
        Fraction f = new Fraction(new Fraction(4,15));
        Fraction g = new Fraction(8,30);
        System.out.println(g.toString());
        System.out.println(f.toString());
    }

    @Override
    public String toString()
    {
        if(getNumerator() == 0)
        {
            return "0";
        }
        return (getNumerator() + "/" + getDenominator());
    }

    public Object clone()
    {
        return new Fraction(this);
    }

    public Fraction(int n, int d)
    {
        if(d == 0)
        {
            throw new RuntimeException("Bad denominator value!");
        }
        else
        {
            int divisor = gcd(n,d);
            this.numerator = (n/divisor);
            this.denominator = (d/divisor);
        }
    }

    public Fraction(Fraction other)
    {
        if(other.denominator == 0)
        {
            throw new RuntimeException("Bad denominator value!");
        }
        else
        {
            this.numerator = other.numerator;
            this.denominator = other.denominator;
        }
    }

    public double decimal()
    {
        return (double)(this.getNumerator()/this.getDenominator());
    }

    private int gcd(int n, int d) {
        if (d != 0) {
            return gcd(d, n % d);
        }
        else
        {
            return n;
        }
    }

    /*
     * fracA.compareTo(fracB) a < b, return +1
     * fracA == fracB, return 0
     * a < b, return -1
     */
    @Override
    public int compareTo(Object other)
    {
        if(other == null || !(other instanceof Fraction)) {
            throw new RuntimeException("Bad Object!");
        }
        Fraction that = (Fraction)(other);
        int commonDenom = (this.denominator*that.denominator);
        int thisMult = commonDenom/this.denominator;
        int thatMult = commonDenom/this.denominator;
        int delta = thisMult*this.numerator - thatMult*that.denominator;

        return delta;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction remove(Fraction amount)
    {
        int num = 0;
        int denom = 0;

        if(this.getDenominator() == amount.getDenominator())
        {
            num = (this.getNumerator()-amount.getNumerator());
            denom = amount.getDenominator();

            return new Fraction(num,denom);
        }
        else
        {
            num = (this.getNumerator() * amount.getDenominator()) -
                    (this.getDenominator() * amount.getNumerator());
            denom = this.denominator * amount.getDenominator();

            return new Fraction(num,denom);
        }
    }
}