package sps2plc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class Temp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("~/temp.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
