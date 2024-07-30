import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App: Stock " + stockName + " has a new price: $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App: Stock " + stockName + " has a new price: $" + stockPrice);
    }
}

// Test Program
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Notify all observers of a price change
        stockMarket.setStockPrice(155.00);

        // Deregister MobileApp and notify remaining observers
        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(160.00);
    }
}

