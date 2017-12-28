package collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class Book implements Comparable<Book> {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class PriorityQueueComparators {
	public static void main(String[] args) {
		Queue<Book> queue = new PriorityQueue<Book>();
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		System.out.println("Traversing the queue elements:");
		
		// Traversing queue elements
		for (Book b : queue) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
		
		System.out.println(queue.poll().id);
		// Adding Books to the queue
		System.out.println("added new elements");
		queue.add(new Book(501,null,null,null,9));
		queue.add(new Book(5,null,null,null,9));
		queue.add(new Book(54,null,null,null,9));
		
		System.out.println(queue.poll().id);
		
		Iterator<Book> itr = queue.iterator();
		while(itr.hasNext()) {
			System.out.println(queue.poll().id);
		}
	}
}
