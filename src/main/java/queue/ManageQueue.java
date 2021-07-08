package queue;

import stock.Order;
import stock.OrderBuy;
import stock.OrderSell;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class ManageQueue {
    private static PriorityBlockingQueue<OrderSell> queueSell;
    private static PriorityBlockingQueue<OrderBuy> queueBuy;

    public static PriorityBlockingQueue<OrderSell> getQueueSell() {
//        Comparator<OrderSell> priceSorted = Comparator.comparing(OrderSell::getPrice);
        if (queueSell == null) {
            queueSell = new PriorityBlockingQueue<OrderSell>();
        }
        return queueSell;
    }

    public static PriorityBlockingQueue<OrderBuy> getQueueBuy() {
        if (queueBuy == null) {
            queueBuy = new PriorityBlockingQueue<OrderBuy>();
        }
        return queueBuy;
    }
}
