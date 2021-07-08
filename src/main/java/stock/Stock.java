package stock;

public class Stock implements Comparable<Stock> {
    String stock;
    String comp;
    Double aucprice;
    Double ceprice;
    Double flprice;

    public Stock(String stock) {
        this.stock = stock;
    }

    public Stock(String stock, String comp, Double aucprice, Double ceprice, Double flprice) {
        this.stock = stock;
        this.comp = comp;
        this.aucprice = aucprice;
        this.ceprice = ceprice;
        this.flprice = flprice;
    }

    public Stock(String stockId, Double aucPrice, Double cePrice, Double flPrice) {
        this.stock = stockId;
        this.aucprice = aucPrice;
        this.ceprice = cePrice;
        this.flprice = flPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock='" + stock + '\'' +
                ", aucprice=" + aucprice +
                ", ceprice=" + ceprice +
                ", flprice=" + flprice +
                '}';
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public Double getAucprice() {
        return aucprice;
    }

    public void setAucprice(Double aucprice) {
        this.aucprice = aucprice;
    }

    public Double getCeprice() {
        return ceprice;
    }

    public void setCeprice(Double ceprice) {
        this.ceprice = ceprice;
    }

    public Double getFlprice() {
        return flprice;
    }

    public void setFlprice(Double flprice) {
        this.flprice = flprice;
    }

    @Override
    public int compareTo(Stock o) {
        return 0;
    }
}
