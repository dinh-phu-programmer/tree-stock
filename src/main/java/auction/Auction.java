package auction;

import datasource.StockDatasource;
import queue.ManageQueue;
import stock.OrderBuy;
import stock.OrderSell;
import stock.Stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Auction implements Runnable {

    PriorityBlockingQueue<OrderSell> queueSell;
    PriorityBlockingQueue<OrderBuy> queueBuy;

    public Auction(PriorityBlockingQueue<OrderSell> queueSell, PriorityBlockingQueue<OrderBuy> queueBuy) {
        this.queueSell = queueSell;
        this.queueBuy = queueBuy;
    }

    //    public void action(PriorityBlockingQueue<OrderSell> queueSell, PriorityBlockingQueue<OrderBuy> queueBuy) {
    public void action() {

        String queryStock = "select stock_id,auc_price,ce_price,fl_price from stock where 1=1";

        List<Stock> stocks = new ArrayList<Stock>();

        Connection con = null;
        try {
            con = StockDatasource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryStock);
            while (rs.next()) {

                String stockId = rs.getString(1);
                Double aucPrice = rs.getDouble(2);
                Double cePrice = rs.getDouble(3);
                Double flPrice = rs.getDouble(4);

                Stock stock = new Stock(stockId, aucPrice, cePrice, flPrice);

                stocks.add(stock); // luu cac thang lay ra tu db

            }


            ArrayList<OrderSell> sellStockList = new ArrayList<OrderSell>();
            ArrayList<OrderBuy> buyStockList = new ArrayList<OrderBuy>();
            for (Stock stock : stocks) {

                for (OrderSell sell : queueSell) {
                    if (sell.getStock().getStock().equals(stock.getStock())) {
                        sellStockList.add(sell);
                    }
                }

                for (OrderBuy buy : queueBuy) {
                    if (buy.getStock().getStock().equals(stock.getStock())) {
                        buyStockList.add(buy);
                    }
                }

            }
            System.out.println(sellStockList.size());
            System.out.println(buyStockList.size());

        } catch (Exception e) {

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }


    public void run() {
        while (true) {
            action();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

