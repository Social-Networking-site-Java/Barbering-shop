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
            case 1 ->  "++ VIP" + (waitingQueue.size());
            case 2, 3 -> "++ ORD" + (waitingQueue.size());
            default -> "";
        };
    }


    /**
     * Event Handler
     * */
    public void handleEvent(int event) {
        switch (event) {
            case 0:
                // Serve the current customer
                serveCustomer();
                break;
            case 1:
                // Add a VIP customer to the waiting queue
                addVIPCustomer();
                break;
            default:
                // Add an ordinary customer to the waiting queue
                addOrdinaryCustomer();
        }
    }

    //checks if there is a current customer.
    public void serveCustomer() {
        // it means there's no one to serve, so the method returns early without doing anything.
        if (currentCustomer == null) {
            return;
        }
        // This line sets the currentCustomer to null,
        // indicating that the current customer has been served
        // and is no longer in the barber shop.
        currentCustomer = null;

        /* This conditional statement checks if the waiting queue is not empty.
         *  If it's not empty, it removes and returns the first
         *  customer from the waiting queue using the [ pollFirst() method ]
         *  and assigns it to the currentCustomer. **/
        if (!waitingQueue.isEmpty()) {
            currentCustomer = waitingQueue.pollFirst();
        }
    }



    // adding a vip customer
    public void addVIPCustomer() {
        // Check if there is no current customer and the waiting queue is empty
        if (currentCustomer == null && waitingQueue.isEmpty()) {
            // If both conditions are true, assign the currentCustomer as the first VIP
            currentCustomer = "VIP1";
            return;
        }

        // Iterate through the waiting queue to find the index of the first non-VIP customer
        int index = 0;
        for (String customer : waitingQueue) {
            if (!customer.startsWith("VIP")) {
                break;
            }
            index++;
        }

        // Insert the new VIP customer at the index of the first non-VIP customer
        waitingQueue.add(index, "VIP" + (waitingQueue.size() + 1));
    }

    // adding ORD customer
    public void addOrdinaryCustomer() {
        // Check if there is space in the waiting queue or if there is no current customer
        if (waitingQueue.size() < CHAIR_COUNT && currentCustomer == null) {
            // If there's space and no current customer, make the current customer the new ordinary customer
            currentCustomer = "ORD" + (waitingQueue.size() + 1);
        } else if (waitingQueue.size() < CHAIR_COUNT) {
            // If there's space in the waiting queue, add the new ordinary customer to the end of the queue
            waitingQueue.addLast("ORD" + (waitingQueue.size() + 1));
        }
    }



    public static void welcomeScreen(){

        System.out.println();
        System.out.println("    ========================================================================");
        System.out.println("    !                Welcome to Executive Barbering Shop                   !");
        System.out.println("    ________________________________________________________________________");
        System.out.println("    !                                                                      !");
        System.out.println("    !           Press space to trigger events. Press any other key to exi  !");
        System.out.println("    !                                                                      !");
        System.out.println("    !                                                                      !");
        System.out.println("    ========================================================================");
        System.out.println();


    }
}
