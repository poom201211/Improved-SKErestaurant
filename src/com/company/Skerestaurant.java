package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

public class Skerestaurant {

    public static Scanner scan = new Scanner(System.in);

    public static int Total = 0,storePizza = 0,storeChickens = 0,storeCoke = 0,choice = 0,quantity = 0,printPizza = 0,printChicken = 0,printCoke = 0,finalTotal = 0;

    final static int[] prices = new int[]{250,120,45};
    //prices[0] = pizza = 250
    //prices[1] = chicken = 120
    //prices[2] = coke = 45
    final static String[] showItem = new String[]{"Pizza","Chicken","Coke"};

    final static List<Integer> totalQuantity = new ArrayList<>();

    public static int Pizza(int quantity) {
        int totalPizza = quantity * prices[0];
        return totalPizza;
    }

    public static int Chickens(int quantity) {
        int totalChick = quantity * prices[1];
        return totalChick;
    }

    public static int Coke(int quantity) {
        int totalCoke = quantity * prices[2];
        return totalCoke;
    }

    public static void Change(int total) {
        int money = getIntReply("Enter change: ");
        money = money - total;
        int thousand = 0;
        int fiveHundred = 0;
        int hundred = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        int two = 0;
        int one = 0;
        while(money > 0) {
            if (money >= 1000) {
                money = money - 1000;
                thousand = thousand + 1;
            } else if(money >= 500) {
                money = money - 500;
                fiveHundred = fiveHundred + 1;
            } else if(money >= 100){
                money = money - 100;
                hundred = hundred + 1;
            } else if(money >= 50){
                money = money - 50;
                fifty = fifty +1;
            } else if(money >= 20){
                money = money - 20;
                twenty = twenty + 1;
            } else if(money >= 10){
                money = money - 10;
                ten = ten + 1;
            } else if(money >= 5){
                money = money - 5;
                five = five + 1;
            } else if(money >= 2){
                money = money - 2;
                two = two + 1;
            } else if(money >= 1){
                money = money - 1;
                one = one + 1;
            }
        }
        if(thousand != 0){
            System.out.println("1000 notes: " + thousand);
        } if(fiveHundred != 0){
            System.out.println("500 notes: " + fiveHundred);
        } if(hundred != 0){
            System.out.println("100 notes: " + hundred);
        } if(fifty != 0){
            System.out.println("50 notes: " + fifty);
        } if(twenty != 0) {
            System.out.println("20 notes: " + twenty);
        } if(ten != 0) {
            System.out.println("10 coins: " + ten);
        } if(five != 0) {
            System.out.println("5 coins: " + five);
        } if(two != 0) {
            System.out.println("2 coins: " + two);
        } if(one != 0) {
            System.out.println("1 coins: " + one);
        }
    }

    public static void coupon(){
        Random ran = new Random();
        int i = ran.nextInt(10)+1;
        if(i==1||i==2||i==3||i==4||i==5)System.out.println("You receive 5% discount coupon for next time.");
        else if(i==6||i==7||i==8)System.out.println("You receive 10% discount coupon for next time");
        else if(i==9||i==10)System.out.println("You receive 20% discount coupon for next time.");
    }

    public static int getIntReply(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    public static void showMenu(){
        System.out.println("--------- Welcome to SKE Restaurant ---------");
        System.out.printf("1.) %s       %d Baht.\n",showItem[0],prices[0]);
        System.out.printf("2.) %s     %d Baht.\n",showItem[1],prices[1]);
        System.out.printf("3.) %s         %d Baht.\n",showItem[2],prices[2]);
        System.out.println("4.) Total");
        System.out.println("5.) Exit");
        System.out.println();
    }

    public static void enterBinMenu() {
        do {
            choice = getIntReply("Enter your choice: ");
            if (choice == 1) {
                printPizza++;
            } else if (choice == 2) {
                printChicken++;
            } else if (choice == 3) {
                printCoke++;
            }
            if (choice != 4 && choice != 5) {
                quantity = getIntReply("Enter Quantity: ");
                if (choice == 1) {
                    storePizza = storePizza + quantity;
                    totalQuantity.add(quantity);
                } else if (choice == 2) {
                    storeChickens = storeChickens + quantity;
                    totalQuantity.add(quantity);
                } else if (choice == 3) {
                    storeCoke = storeCoke + quantity;
                    totalQuantity.add(quantity);
                }
                System.out.println();
            }
            int Total = 0;
            if (choice == 4) {
                System.out.println("+------ Menu -------+--- Qty ---+----- Price ------+");
                if (printPizza >= 1 && quantity >= 0) {
                    System.out.printf("| Pizza\t\t\t\t| \t%6d  | \t\t%10d |\n", storePizza, Pizza(storePizza));
                    Total = Total + Pizza(storePizza);
                }
                if (printChicken >= 1 && quantity >= 0) {
                    System.out.printf("| Chickens\t\t\t| \t%6d  | \t\t%10d |\n", storeChickens, Chickens(storeChickens));
                    Total = Total + Chickens(storeChickens);
                }
                if (printCoke >= 1 && quantity >= 0) {
                    System.out.printf("| Coke\t\t\t\t| \t%6d  | \t\t%10d |\n", storeCoke, Coke(storeCoke));
                    Total = Total + Coke(storeChickens);
                }
                System.out.println("+-------------------+-----------+------------------+");
                System.out.printf("| Total                         |\t\t%10d |\n", Total);
                finalTotal = Total;
                System.out.println("+-------------------+-----------+------------------+");
            }
        }
        while (choice != 5) ;
    }

    public static void changeMenu(){
        if (choice == 5) {
            System.out.println("+------ Menu -------+--- Qty ---+----- Price ------+");
            if (printPizza >= 1 && quantity >= 0) {
                System.out.printf("| Pizza\t\t\t\t| \t%6d  | \t\t%10d |\n", storePizza, Pizza(storePizza));
                Total = Total + Pizza(storePizza);
            }
            if (printChicken >= 1 && quantity >= 0) {
                System.out.printf("| Chickens\t\t\t| \t%6d  | \t\t%10d |\n", storeChickens, Chickens(storeChickens));
                Total = Total + Chickens(storeChickens);
            }
            if (printCoke >= 1 && quantity >= 0) {
                System.out.printf("| Coke\t\t\t\t| \t%6d  | \t\t%10d |\n", storeCoke, Coke(storeCoke));
                Total = Total + Coke(storeCoke);
            }
            System.out.println("+-------------------+-----------+------------------+");
            System.out.printf("| Total                         |\t\t%10d |\n",Total);
            finalTotal = Total;
            int sumQuantity = 0;
            for (int i = 0; i < totalQuantity.size() ; i++){
                sumQuantity += totalQuantity.get(i);
            }
            System.out.println("+-------------------+-----------+------------------+");
            System.out.printf("| Total Quantity                |\t\t%10d |\n",sumQuantity);
            System.out.println("+-------------------+-----------+------------------+");
            System.out.println();
            Change(finalTotal);
            System.out.println();
            coupon();
            System.out.print("===== Thank You =====");
        }
    }

    public static void main(String[] args) {
        showMenu();
        enterBinMenu();
        changeMenu();
    }
}
