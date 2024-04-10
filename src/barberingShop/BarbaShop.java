package barberingShop;

import java.util.LinkedList;

public class BarbaShop {

    public final LinkedList<String> waitingQueue = new LinkedList<>();
    public String currentCustomer = null;

    private static final int CHAIR_COUNT = 5;

    /**
     * Event description method
     * on a trigger, thus when the tab on the space bar ' '
     * if the event is 0 or 1 then a particular description should be triggered
     * */
    public String getEventDescription(int event) {
        return switch (event) {
            case 0 ->  "-- " + currentCustomer;
            //  case 1 ->  "++ VIP" + (waitingQueue.size() + 1);
            case 1 ->  "++ VIP" + (waitingQueue.size());
            case 2, 3 -> "++ ORD" + (waitingQueue.size());
            //  case 2, 3 -> "++ ORD" + (waitingQueue.size() + 1);
            default -> "";
        };
    }


    /**
     * Event Handler
     * */
    public void handleEvent(int event) {
        switch (event) {
            case 0:
                serveCustomer();
                break;
            case 1:
                addVIPCustomer();
                break;
            default:
                addOrdinaryCustomer(event);
        }
    }

    //checks if there is a current customer.
    public void serveCustomer() {
        if (currentCustomer == null) {
            return;
        }
        // This line sets the currentCustomer to null,
        currentCustomer = null;

        /** This conditional statement checks if the waiting queue is not empty.
         *  If it's not empty, it removes and returns the first
         *  customer from the waiting queue using the [ pollFirst() method ]
         *  and assigns it to the currentCustomer. */
        if (!waitingQueue.isEmpty()) {
            currentCustomer = waitingQueue.pollFirst();
        }
    }


    //adds a VIP customer to the waiting queue.
    public void addVIPCustomer() {

        /** If both conditions are true, it assigns the currentCustomer
         * to be "VIP1" and returns, indicating that the VIP customer has been added */
        if (currentCustomer == null && waitingQueue.isEmpty()) {
            currentCustomer = "VIP" + (1);
            return;
        }

        /** Checks if the waiting queue is empty or the first customer
         * in the waiting queue is a VIP customer. If either condition
         * is true, it adds the VIP customer to the beginning
         * of the waiting queue*/
        if (waitingQueue.isEmpty() || waitingQueue.getFirst().startsWith("VIP")) {
            waitingQueue.addFirst("VIP" + (waitingQueue.size() + 1));
        } else {

            /** If neither of the above conditions is met,
             * the method iterates through the waiting queue
             * to find the index where the first non-VIP customer is encountered.
             * It then inserts the new VIP customer at that index.*/
            int index = 1;
            for (String customer : waitingQueue) {
                if (customer.startsWith("VIP")) {
                    waitingQueue.add(index, "VIP" + (waitingQueue.size() + 1));
                    return;
                }
                index++;
            }


            //waitingQueue.addLast("VIP" + (waitingQueue.size() + 1));
            waitingQueue.addFirst("VIP" + (waitingQueue.size() + 1));
        }
    }



    public void addOrdinaryCustomer(int event) {
        if (currentCustomer == null && waitingQueue.size() < CHAIR_COUNT) {
            currentCustomer = "ORD" + (waitingQueue.size() + 1);
            return;
        }
        //  if (waitingQueue.size() < CHAIR_COUNT) {
        if (waitingQueue.size() < CHAIR_COUNT) {
            // waitingQueue.remove("ORD" + (waitingQueue.size() + 1));
            waitingQueue.addLast("ORD" + (waitingQueue.size() + 1));
        } else {
            //System.out.println("+- " + "ORD" + (event - 1 + 1) + " (Customer left)");
        }
    }



    public static void welcomeScreen(){

        System.out.println("\n");
        System.out.println("    ========================================================================");
        System.out.println("    !                Welcome to Executive Barbering Shop                   !");
        System.out.println("    ________________________________________________________________________");
        System.out.println("    !                                                                      !");
        System.out.println("    !           Press space to trigger events. Press any other key to exi  !");
        System.out.println("    !                                                                      !");
        System.out.println("    !                                                                      !");
        System.out.println("    ========================================================================");


    }
}
