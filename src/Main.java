import barberingShop.BarbaShop;

import java.util.Random;
import java.util.Scanner;

public class Main {

        // creating an instance of the scanner class
        private static final Scanner scanner = new Scanner(System.in);

        // getting a random value from [0 - 4]
        private static final Random random = new Random();
        private static final String MAIN_CHAIR = "Main Chair ";


    public static void main(String[] args) {

            // print a default text to the console
            BarbaShop.welcomeScreen();

            // creating an object of the Barba shop
            BarbaShop shop = new BarbaShop();


            while(true) {
                    char input = scanner.nextLine().charAt(0);
                    if (input != ' ') {
                            System.out.println("Program Ended! \n Thank you");
                            break;
                    }
                    int event = random.nextInt(4);
                    shop.handleEvent(event);

                    // Format and print the event details along with the current customer and waiting queue
                    System.out.printf(
                            // Format string
                            "%4d  ---> ( %-7s )  [ %-5s : %-5s : %-5s : %-5s : %-5s : %-5s ]%n",

                            // Event identifier
                            event, shop.getEventDescription(event),

                            // Current customer details
                            shop.currentCustomer != null ? shop.currentCustomer + " (" + MAIN_CHAIR + ")" : "-----",
                            // Waiting queue details (up to 5 customers)
                            shop.waitingQueue.isEmpty() ? "-----" : shop.waitingQueue.get(0),
                            shop.waitingQueue.size() < 2 ? "-----" : shop.waitingQueue.get(1),
                            shop.waitingQueue.size() < 3 ? "-----" : shop.waitingQueue.get(2),
                            shop.waitingQueue.size() < 4 ? "-----" : shop.waitingQueue.get(3),
                            shop.waitingQueue.size() < 5 ? "-----" : shop.waitingQueue.get(4));
            }
    }


}