package queue;

import stock.Order;
import stock.OrderBuy;
import stock.OrderSell;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

public class ManageQueue {
    private static PriorityBlockingQueue<OrderSell> queueSell = new PriorityBlockingQueue<OrderSell>();
    private static PriorityBlockingQueue<OrderBuy> queueBuy = new PriorityBlockingQueue<OrderBuy>();

    public static PriorityBlockingQueue<OrderSell> getQueueSell() {
//        Comparator<OrderSell> priceSorted = Comparator.comparing(OrderSell::getPrice);

        return queueSell;
    }

    public static PriorityBlockingQueue<OrderBuy> getQueueBuy() {

        return queueBuy;
    }
}
