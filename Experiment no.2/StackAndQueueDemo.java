import java.util.LinkedList;


class Stack {
    private LinkedList<Integer> stackList;

    
    public Stack() {
        stackList = new LinkedList<>();
    }

    
    public void push(int value) {
        stackList.addFirst(value);
        System.out.println(value + " pushed to stack.");
    }

   
    public int pop() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Return -1 if the stack is empty
        } else {
            int poppedValue = stackList.removeFirst();
            System.out.println(poppedValue + " popped from stack.");
            return poppedValue;
        }
    }

   
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    
    public int peek() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Return -1 if the stack is empty
        } else {
            return stackList.getFirst();
        }
    }
}

class Queue {
    private LinkedList<Integer> queueList;

    // Constructor to initialize the queue
    public Queue() {
        queueList = new LinkedList<>();
    }

    // Method to add an element to the queue
    public void enqueue(int value) {
        queueList.addLast(value);
        System.out.println(value + " enqueued to queue.");
    }

    
    public int dequeue() {
        if (queueList.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; 
        } else {
            int dequeuedValue = queueList.removeFirst();
            System.out.println(dequeuedValue + " dequeued from queue.");
            return dequeuedValue;
        }
    }

    
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    
    public int peek() {
        if (queueList.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Return -1 if the queue is empty
        } else {
            return queueList.getFirst();
        }
    }
}

public class StackAndQueueDemo {
    public static void main(String[] args) {
        
        Stack stack = new Stack();
        Queue queue = new Queue();

        
        System.out.println("Stack Operations:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element of stack: " + stack.peek());
        stack.pop();
        System.out.println("Top element of stack after pop: " + stack.peek());

       
        System.out.println("\nQueue Operations:");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Front element of queue: " + queue.peek());
        queue.dequeue();
        System.out.println("Front element of queue after dequeue: " + queue.peek());
    }
}
