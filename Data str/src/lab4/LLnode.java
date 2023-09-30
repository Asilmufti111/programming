package lab4;

/// LLnode.java
// Class from which we can Linked List node objects
package LinkListUpdated;

public class LLnode {

    private int data;
    private LLnode next;

    // CONSTRUCTORS
    public LLnode() {
        data = 0;
        next = null;
    }

    public LLnode(int data) {
        this.data = data;
        next = null;
    }

    public LLnode(int data, LLnode next) {
        this.data = data;
        this.next = next;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public LLnode getNext() {
        return next;
    }

    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LLnode next) {
        this.next = next;
    }
}