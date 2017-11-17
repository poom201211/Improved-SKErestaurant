package com.company;

import java.util.*; // import everything from the java.util package.

public class Skerestaurant {

    public static Scanner scan = new Scanner(System.in);

    public static String[] menuItems;

    public static double[] prices;

    public static int[] orders;

    public static void menuTable(){
            double total = 0;
            System.out.println("+------ Menu -------+--- Qty ---+----- Price ------+");
            for(int i = 0; i < menuItems.length; i++){
                if(orders[i] > 0){
                    System.out.printf("| %s\t\t\t\t| \t%6d  | \t\t%10.2f |\n", menuItems[i], orders[i], prices[i]*orders[i]);
                }
            }
            System.out.println("+-------------------+-----------+------------------+");
            for(int k = 0; k < menuItems.length; k++){
                total += prices[k]*orders[k];
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
        menuItems = readMenu.getMenuItems();
        prices = readMenu.getPrices();
        System.out.println("--------- Welcome to SKE Restaurant ---------");
        for(int i = 0; i < menuItems.length; i++){
            System.out.printf("[%d] %s\t%10.2f Baht.\n",i+1, menuItems[i], prices[i]);
        }
        System.out.println("[t] Total");
        System.out.println("[x] Exit");
        System.out.println();
        orders = new int[menuItems.length];

    }

    public static void enterBinMenu() {
        int quantity;
        String choice;
        do{
            choice = getStringReply("\nEnter your choice: ");
            if(isNumber(choice)){
                if(Integer.parseInt(choice) <= menuItems.length){
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
