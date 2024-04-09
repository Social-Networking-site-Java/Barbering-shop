package barberingShop;

import java.util.LinkedList;

public class BarbaShop {

    final LinkedList<String> waitingQueue = new LinkedList<>();
    String currentCustomer = null;

    private static final int CHAIR_COUNT = 5;

    /**
     * Event description method
     * on a trigger, thus the tab on the space bar ' '
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
}
