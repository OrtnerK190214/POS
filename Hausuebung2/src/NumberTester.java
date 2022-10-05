import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberTester {

    private String fileName;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTester oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTester palindromeTester) {
        this.PalindromeTester() = palindromeTester;
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

        

    }
}
