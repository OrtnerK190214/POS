import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberTester{

    private String fileName;
    public NumberTest numberTester;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.numberTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.numberTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.numberTester = palindromeTester;
    }

    public void testFile() {
        File file = new File(fileName);
        List dateizahlen = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String s = scanner.nextLine();
                String[] splitted = s.split(" ");
                for (int i = 0; i< splitted.length; i++)
                {
                    dateizahlen.add(i);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        NumberTest oddeven = (zahl) -> {
            if (zahl % 2 == 0) {
                return true;
            }
            else {
                return false;
            }
        };

        NumberTest prime = (zahl) -> {
            boolean tmp = false;
            for (int i = 2; i <= zahl / 2; ++i) {
                if (zahl % i == 0) {
                    tmp = true;
                    break;
                }
            }

            if (!tmp) {
                return true;
            }
            else {
                return false;
            }
        };

        NumberTest palindrome = (zahl) -> {
            int reversedNum = 0;
            int remainder;

            int originalNum = zahl;

            while (zahl != 0) {
                remainder = zahl % 10;
                reversedNum = reversedNum * 10 + remainder;
                zahl /= 10;
            }

            if (originalNum == reversedNum) {
                return true;
            }
            else {
                return false;
            }
        };


        int anweisung = 0;
        int zahl = 0;
        for (int i = 1; i<dateizahlen.size(); i++) {
            if (i % 2 == 0)
            {
                anweisung = i;
            }
            else {
                zahl = i;
            }
            if(anweisung == 1)
            {
                setOddEvenTester(oddeven);
            }
            else if(anweisung == 2)
            {
                setPrimeTester(prime);
            }
            else if(anweisung == 3)
            {
                setPalindromeTester(palindrome);
            }

            System.out.println(numberTester.testNumber(zahl));
        }
    }
}
