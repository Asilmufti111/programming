
//course number: CPCS204
//date: 9 NOV 2022

package CarWashSystem;

public class QueueOfCustomerLL {
    private Customer front;
    private Customer back;
    
    // CONSTRUCTOR
    public QueueOfCustomerLL() {
        front = null;
        back = null;
    }
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return front == null;
	}
	
	
	//
	// void | PrintQueue()
	//
	public void PrintQueue() {
		PrintQueue(front);
	}
	//
	// void | PrintQueue(QueueNode)
	//
	private void PrintQueue(Customer front) {
		// We need to traverse...so we need a help ptr
		Customer helpPtr = front;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getFirstName() + " "+helpPtr.getLastName()+","+helpPtr.getserviceName()+", "+helpPtr.getBN());
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(String data) {
		return search(front, data);
	}
	//
	// boolean | search(QueueNode, int)
	//
	private boolean search(Customer p, String data) {
		// To search, we must traverse. Therefore, we need helpPtr.
		Customer helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getserviceName().equals(data))
				return true;
			helpPtr = helpPtr.getNext(); // step one node over		
		}
		return false;
	}
	
	
	//
	// void | enqueue(int)
	//
	public void enqueue(Customer data) {
		if (isEmpty()) {
			front = back = enqueue(front, back, data);
		}
		else {
			back = enqueue(front, back, data);
		}
		
	}
	//
	// QueueNode | enqueue(QueueNode, QueueNode, int)
	//
	private Customer enqueue(Customer front, Customer back, Customer data) {
		if (isEmpty()) {
			return data;
		}
		else {
			back.setNext(data);
			back = back.getNext();
			return back;
		}
	}
	
	
	//
	// QueueNode | dequeue()
	//
	public Customer dequeue() {
		Customer temp = front;
		front = dequeue(front);
		if (front == null)
			back = null;
		return temp;
	}
	//
	// QueueNode | dequeue(QueueNode)
	//
	private Customer dequeue(Customer front) {
		front = front.getNext();
		return front;
	}
	
	
	//
	// int | peek()
	//
	public Customer peek() {
		// Invoke the peek method with front as a parameter
		Customer frontValue = peek(front);
		
		// return topValue
		return frontValue;
	}
	//
	// int | peek(QueueNode)
	//
	private Customer peek(Customer front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front;
	}
}

