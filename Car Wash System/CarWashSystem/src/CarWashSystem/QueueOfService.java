
//course number: CPCS204
//date: 9 NOV 2022

package CarWashSystem;


// QueueOfService.java

public class QueueOfService{
	private Customer[] queue;
	private int maxSize;
	private int front;
	private int numItems; // This counts the number of elements in the queue
	
	// Constructor
	public QueueOfService (int size) {
		maxSize = size;             // set array size
		queue = new Customer[maxSize];   // create array for stack
		front = 0;                  
		numItems = 0;               // initialize numItems to zero
	}
	
	
	//
	// boolean | isFull()
	//
	public boolean isFull () {
		return (numItems == maxSize);
	}
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return (numItems == 0);
	}
	
	
	//
	// int | size()
	//
	public int size() {
		return numItems;
	}
	
	
	//
	// void | enqueue(int)
	//
	public void enqueue(Customer value) {
		queue[(front+numItems) % maxSize] = value;
		numItems++;
	}
	
	
	//
	// int | dequeue()
	//
	public Customer dequeue() {
		Customer temp = queue[front];
		// update the location of front
		front = (front+1) % maxSize;
		// decrement numItems
		numItems--;
		// return the previous front value
		return temp;
	}
	
	
	//
	// int | peek()
	//
	public Customer peek() {
		return queue[front];
	}
	

	
}
