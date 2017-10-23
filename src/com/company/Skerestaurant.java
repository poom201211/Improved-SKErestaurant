package com.company;

import java.util.*;

public class Skerestaurant {

    public static Scanner scan = new Scanner(System.in);

    public static int choice = 0;

    public static String[] getMenuItems;

    public static double[] getPrices;

    public static int[] orders;

    public static void menuTable(){
            double total = 0;
            System.out.println("+------ Menu -------+--- Qty ---+----- Price ------+");
            for(int i = 0; i < getMenuItems.length; i++){
                if(orders[i] > 0){
                    System.out.printf("| %s\t\t\t\t| \t%6d  | \t\t%10.2f |\n",getMenuItems[i], orders[i],getPrices[i]*orders[i]);
                }
            }
            System.out.println("+-------------------+-----------+------------------+");
            for(int k = 0; k < getMenuItems.length; k++){
                total += getPrices[k]*orders[k];
            }
            System.out.printf("| Total                         |\t\t%10.2f |\n",total);

            System.out.println("+-------------------+-----------+------------------+");
    }

    public static boolean isNumber(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

    public static String getStringReply(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }


    public static void showMenu(){
        RestaurantManager readMenu = new RestaurantManager();
        getMenuItems = readMenu.readFileName();
        getPrices = readMenu.readFilePrice();
        System.out.println("--------- Welcome to SKE Restaurant ---------");
        for(int i = 0; i < getMenuItems.length; i++){
            System.out.printf("[%d] %s\t%10.2f Baht.\n",i+1,getMenuItems[i],getPrices[i]);
        }
        System.out.println("[t] Total");
        System.out.println("[x] Exit");
        System.out.println();
        orders = new int[getMenuItems.length];

    }

    public static void enterBinMenu() {
        int quantity;
        String choice;
        do{
            choice = getStringReply("\nEnter your choice: ");
            if(isNumber(choice)){
                if(Integer.parseInt(choice) <= getMenuItems.length){
                    quantity = Integer.parseInt(getStringReply("Enter Quantity: "));
                    orders[Integer.parseInt(choice) - 1] += quantity;
                }
            }else if(choice.equals("t")){
                menuTable();
            }
        }while(!choice.equals("x"));
        System.out.println();
        menuTable();
        System.out.println();
        System.out.println("============== THANK YOU COME AGAIN ==============");
    }

    public static void main(String[] args) {

        showMenu();
        enterBinMenu();

    }
}
