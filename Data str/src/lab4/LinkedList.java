package lab4;
// LinkedList.java
// Class from which we can create fully functional Linked Lists

public class LinkedList {
    // head: reference variable to the first node of the list

    private LLnode head;

    // CONSTRUCTORS
    public LinkedList() {
        head = null;
    }

    /* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return head == null;
    }

    //
    // boolean | search(int)
    //
    public boolean search(int data) {
        return search(head, data);
    }
    //
    // boolean | search(LLnode, int)
    //

    private boolean search(LLnode p, int data) {
        LLnode helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    //
    // boolean | search(int)
    //
    public LLnode findNode(int data) {
        return findNode(head, data);
    }
    //
    // boolean | search(LLnode, int)
    //

    private LLnode findNode(LLnode p, int data) {
        LLnode helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return null;
    }

    //
    // void | PrintList()
    //
    public void PrintList() {
        PrintList(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void PrintList(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getData() + ", ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    //
    // void | PrintList()
    //
    public void ModifyAllNodes() {
        ModifyAllNodes(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void ModifyAllNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // We add 10 to the data value of each node
            helpPtr.setData(helpPtr.getData() + 10);
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    //
    // int | sumNodes()
    //
    public int sumNodes() {
        return sumNodes(head);
    }
    //
    // int | sumNodes(BSTnode)
    //

    private int sumNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        int sum = 0; // counter
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Increase sum
            sum += helpPtr.getData();
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        return sum;
    }

    //
    // void | insert(int)
    //
    public void insert(int data) {
        head = insert(head, data);
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private LLnode insert(LLnode head, int data) {
        // IF there is no list, newNode will be the first node, so just return it
        if (head == null || head.getData() > data) {
            head = new LLnode(data, head);
            return head;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            LLnode helpPtr = head;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getData() > data) {
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            LLnode newNode = new LLnode(data, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    //
    // void | delete(int)
    //
    public void delete(int data) {
        head = delete(head, data);
    }
    //
    // LLnode | delete(LLnode, value)
    //

    private LLnode delete(LLnode head, int data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (head.getData() == data) {
                head = head.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                LLnode helpPtr = head;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getData() == data) {
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return head;
        }
        return head;
    }

    public void deleteNodeAfter(int data) {
        deleteNodeAfter(head, data);
    }

    private void deleteNodeAfter(LLnode head, int data) {
        LLnode helpptr = head;
        boolean found = false;
        while (helpptr != null) {
            if (helpptr.getData() == data) {
                found = true;

                if (helpptr.getNext() == null) {
                    System.out.println(">    No node can be deleted after this node as it is the last node in the list.");
                } else {
                    helpptr.setNext(helpptr.getNext().getNext());
                    System.out.println(">    The node after this node has been daleted.");
                }
                break;
            }
            helpptr = helpptr.getNext();
        }
        if (found == false) {
            System.out.println(">     Error: The node is not present in the list.");

        }

    }

}
