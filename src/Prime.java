
/**
 * Created by david on 4/19/16.
 */
public class Prime {

    int currentPrime;

    Prime(int beginningValue) {
        currentPrime = beginningValue;
    }

    public int nextPrime() {
        return getPrime();
    }

    private int getPrime() {
        mainloop:
        while (true) {
            currentPrime += 1;
            if (isPrime(currentPrime) && finalPrimeCheck(currentPrime)) {
                break mainloop;
            }
        }
        return currentPrime;
    }

    private boolean isPrime(int value) {
        if (value % 1 == 0) {
            if (value % value == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean finalPrimeCheck(int value) {
        String valueString = String.valueOf(value);

        if (divisibleBy2(valueString)) {
            return false;
        }
        if (divisibleBy3(valueString)) {
            return false;
        }
        if (divisibleBy5(valueString)) {
            return false;
        }
        if (divisibleBy7(valueString)) {
            return false;
        }
        if (divisibleBy11(valueString)) {
            return false;
        }
        if (divisibleBy13(valueString)) {
            return false;
        }
        return true;

    }

    private boolean divisibleBy2(String value) {
        if ((Integer.parseInt(value.substring(value.length()-1, value.length())) % 2 == 0)) {
            return true;
        }
        return false;
    }

    private boolean divisibleBy3(String value) {
        int valueSummed = 0;
        for (int i=0; i < value.length(); i++) {
            valueSummed += Integer.parseInt(value.substring(i, i+1));
        }
        if (valueSummed % 3 == 0){
            return true;
        }
        return false;
    }

    private boolean divisibleBy5(String value) {
        if ((Integer.parseInt(value.substring(value.length()-1, value.length()))) == 5 || ((Integer.parseInt(value.substring(value.length()-1, value.length()))) == 0)) {
            return true;
        }
        return false;
    }

    private boolean divisibleBy7(String value) {
        if (Integer.parseInt(value.substring(0, value.length() -1)) - (Integer.parseInt(value.substring(value.length()-1, value.length())) * 2) % 7 == 0) {
            return true;
        }
        return false;
    }

    private boolean divisibleBy11(String value) {
        int odd = 0;
        int even = 0;
        for (int i=0; i < value.length(); i++) {
            if (i % 2 == 0) {
                even += (int) value.charAt(i);
            }
            else {
                odd += (int) value.charAt(i);
            }
        }
        if (odd % even == 0) {
            return true;
        }
        return false;
    }

    private boolean divisibleBy13(String value) {
        if (Integer.parseInt(value) == 13) {
            return false;
        }
        int lastDigit = Integer.parseInt(value.substring(value.length() - 1, value.length())) * 9;
        int firstDigits = Integer.parseInt(value.substring(0, value.length() - 1));

        if ((firstDigits - lastDigit) % 13 == 0) {
            return true;
        }
        return false;
    }


}
