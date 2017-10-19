package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RestaurantManager {

    private static String[] menuItems;

    private static double[] prices;

    public static String[] readFileName() {
        String path = "C:\\Users\\Poom\\Desktop\\menu.txt";
        File file = new File(path);
        try {//Sometimes if a program runs into an error, we provide an exit for the program.
            BufferedReader takeAllLine = new BufferedReader(new FileReader(file));//Put everything that is read in the file and put in it BufferedReader
            String lineString;
            String[] parts;

            int lines = 0;
            int count = 0;

            while ((lineString = takeAllLine.readLine()) != null) {
                lines += 1;
            }
            takeAllLine = new BufferedReader(new FileReader(file));
            prices = new double[lines];
            menuItems = new String[lines];

            while ((lineString = takeAllLine.readLine()) != null) {
                parts = lineString.split(";", 2);//to split when seeing space(";")String part1 = Pizza String part2 = 45
                String part1 = parts[0].trim();//e.g round 1 = Pizza
                menuItems[count] = part1;
                String part2 = parts[1].trim();//e.g round 1 = 45
                prices[count] = Double.parseDouble(part2);//change from string to double.
                count++;

            }
            takeAllLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
    public static double[] readFilePrice() {
        String path = "C:\\Users\\Poom\\Desktop\\menu.txt";
        File file = new File(path);
        try {//Sometimes if a program runs into an error, we provide an exit for the program.
            BufferedReader takeAllLine = new BufferedReader(new FileReader(file));//Put everything that is read in the file and put in it BufferedReader
            String lineString;
            String[] parts;

            int lines = 0;
            int count = 0;

            while ((lineString = takeAllLine.readLine()) != null) {
                lines += 1;
            }
            takeAllLine = new BufferedReader(new FileReader(file));
            prices = new double[lines];
            menuItems = new String[lines];

            while ((lineString = takeAllLine.readLine()) != null) {
                parts = lineString.split(";", 2);//to split when seeing space(";")String part1 = Pizza String part2 = 45
                String part1 = parts[0].trim();//e.g round 1 = Pizza
                menuItems[count] = part1;
                String part2 = parts[1].trim();//e.g round 1 = 45
                prices[count] = Double.parseDouble(part2);//change from string to double.
                count++;

            }
            takeAllLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prices;
    }
}

