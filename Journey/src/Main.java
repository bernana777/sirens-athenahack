import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String filename = in.next();
        in.close();
        System.out.println(ReadNetFile.initNet(ReadNetFile.readNetFile(filename)).toString());
        System.out.println();
    }
}
