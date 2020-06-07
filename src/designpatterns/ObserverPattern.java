package designpatterns;

//http://www.thejavageek.com/2016/08/04/observer-pattern-implementation/

import java.util.HashSet;
import java.util.Set;

interface Observable {
	public abstract void register(Observer o);

	public abstract void remove(Observer o);

	public abstract void notifyObservers();
}

interface Observer {
	public void update(double price);
}

class RegularBuyer implements Observer {

	private Observable product;

	public RegularBuyer(Observable product) {
		this.product = product;
		this.product.register(this);
	}

	@Override
	public void update(double price) {
		System.out.println("New price received in RegularBuyer = " + price);
	}

	public void unSubscribe() {
		this.product.remove(this);
	}

}

class PrivilegedBuyer implements Observer {

	private Observable product;

	public PrivilegedBuyer(Observable product) {
		this.product = product;
		this.product.register(this);
	}

	@Override
	public void update(double price) {
		System.out.println("New Price received in PrivilegedBuyer = " + price);
	}

}

class Product implements Observable {

	private Set<Observer> observers = new HashSet<>();
	private double price;

	@Override
	public void register(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void remove(Observer o) {
		if (!observers.isEmpty()) {
			observers.remove(o);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(price);
		}
	}

	public void setPrice(double price) {
		this.price = price;
		this.notifyObservers();
	}

}

public class ObserverPattern {
	public static void main(String[] args) {
		Product product = new Product();
		RegularBuyer regularBuyer = new RegularBuyer(product);
		PrivilegedBuyer privilegedBuyer = new PrivilegedBuyer(product);

		product.setPrice(10000);
		regularBuyer.unSubscribe();
		product.setPrice(15000);
	}
}