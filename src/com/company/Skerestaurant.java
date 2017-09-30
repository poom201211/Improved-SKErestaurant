package com.company;

import java.util.Random;

import java.util.Scanner;

public class Skerestaurant {

    public static Scanner scan = new Scanner(System.in);

    public static int Total = 0,storePizza = 0,storeChickens = 0,storeCoke = 0,choice = 0,quantity = 0,printPizza = 0,printChicken = 0,printCoke = 0,finalTotal = 0;

    final static int pricePizza = 250,priceChicken = 120,priceCoke = 45;

    public static int Pizza(int quantity) {
        int totalPizza = quantity * pricePizza;
        return totalPizza;
    }

    public static int Chickens(int quantity) {
        int totalChick = quantity * priceChicken;
        return totalChick;
    }

    public static int Coke(int quantity) {
        int totalCoke = quantity * priceCoke;
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
        System.out.println("1.) Pizza       250 Baht.");
        System.out.println("2.) Chickens    120 Baht.");
        System.out.println("3.) Coke        45 Baht.");
        System.out.println("4.) Total");
        System.out.println("5.) Exit");
        System.out.println();
    }

    public static void binMenu() {
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
                } else if (choice == 2) {
                    storeChickens = storeChickens + quantity;
                } else if (choice == 3) {
                    storeCoke = storeCoke + quantity;
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
        binMenu();
        changeMenu();
    }
}
