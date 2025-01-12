import java.math.BigInteger;

public class TheCode {

    public static boolean IsItPrime = true;
    public static void primeDetector(BigInteger number) {
    if (number.equals("2") || number.equals("-2")){
        IsItPrime = true;
    }else if(number.compareTo(new BigInteger("2")) == 1) {
        for (BigInteger i = new BigInteger("2"); i.compareTo(number) == -1; i=i.add(new BigInteger("1"))) {
            if (number.mod(i).equals(new BigInteger("0"))) {
                IsItPrime = false;
                break;
            }
        }
    } else if (number.equals("1") | number.equals("-1") ) {
        IsItPrime = false;
    } else if (number.compareTo(new BigInteger("-2")) == -1) {
        for (BigInteger i = new BigInteger("2"); i.compareTo(number.multiply(new BigInteger("-1"))) == -1; i = i.add(new BigInteger("1"))) {
            if (number.multiply(new BigInteger("-1")).mod(i).equals(new BigInteger("0"))) {
                IsItPrime = false;
                break;
            }

        }
    } else if (number.equals("0")) {
                IsItPrime = false;
        }else{
        IsItPrime = true;
    }
    }
}
