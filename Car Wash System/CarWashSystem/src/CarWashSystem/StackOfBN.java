
//course number: CPCS204
//date: 9 NOV 2022

package CarWashSystem;

// StackOfBN.java



import java.io.PrintWriter;

public class StackOfBN {
	private int [] BillNo;
        private int maxSize;
	private int top;
	
	// Constructor
	public StackOfBN (int size) {
		maxSize = size;             // set array size  
		BillNo = new int[maxSize]; // create array for stack
                top = -1;                   // set top to -1 (no items in stack yet)
	}
	
	
	//
	// boolean | isFull()
	//
	public boolean isFull () {
		return (top == maxSize-1);
	}
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int size() {
		return top+1;
	}
	//
	// int | pop()
	//
	public int pop() {
		return BillNo[top--];
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		return BillNo[top];
	}
	
	
	//
	// void | push(int)
	//
	public void push(int value) {
		BillNo[++top] = value;
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int value) {
		for(int i=0; i<=top; i++) {
			// if the value is found at stack[i], return true
			if (BillNo[i] == value)
				return true;
		}
		// If we make it till here, the value was not found in the array.
		return false;
	}
	
	
	//
	// void | PrintStack()
	//
	public void PrintStack() {
		for(int i=0; i<=top; i++) {
			System.out.print(BillNo[i] + ", ");
		}
		// print a newline
		System.out.println();
	}
	
}
