package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
//package com.company;
//
//import java.io.InputStream;
//
//Reads input from some input source "byte by byte"
//
//import java.util.Scanner;
//
//public class RestaurantManager {
//    static final String MENU_FILE = "C:\\Users\\Poom\\Desktop\\menu.text";
//    private static String[] menuItems;
//    private static double[] prices;
//    public static void readFile(){
//        ClassLoader loader = RestaurantManager.class.getClassLoader();
//        InputStream in = loader.getResourceAsStream(MENU_FILE);
//        //check that it worked
//        if(in == null){
//            System.err.println("Could not find resource " + MENU_FILE);
//            System.exit(1);
//        }
//        Scanner scanner = new Scanner(in);
//        while(scanner.hasNextLine()){
//            String line = scanner.nextLine();
//            System.out.println(line);
//        }
//        //be nice
//        scanner.close();
//    }
//    public static void main(String[] args) {
//        readFile();
//    }
//}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------


public class RestaurantManager {

    private static String[] menuItems = new String[3];

    private static double[] prices = new double[3];

    public static void readFile(){
        String path = "C:\\Users\\Poom\\Desktop\\menu.txt";
        File file = new File(path);
        try {//Sometimes if a program runs into an error, we provide an exit for the program.
            BufferedReader br = new BufferedReader(new FileReader(file));//Put everything that is read in the file and put in it BufferedReader
            String line;
            String[] parts;
            int count = 0;
            while( (line = br.readLine())  != null){
                System.out.println(line);
                parts = line.split(" ", 2);//to split when seeing space(" ")String part1 = Pizza String part2 = 45
                String part1 = parts[0];//e.g round 1 = Pizza
                menuItems[count] = part1;
                String part2 = parts[1];//e.g round 1 = 45
                prices[count] = Double.parseDouble(part2);//change from string to double.
                count++;
            }
            System.out.println(Arrays.toString(menuItems));
            System.out.println(Arrays.toString(prices));
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readFile();
    }
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
