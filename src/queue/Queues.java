package queue;

/*
A queue is an ordered list in which insertions are done at one end(rear) and deletions are done at other end(front).
FIFO
Applications-
Scheduling jobs
Multiprogramming
Asynchronous data transfer(file IO)
 */

public class Queues {
    int front, rear, size, capacity;
    int[] queue;

//    private Node front, rear;     for LinkedList implementation

    Queues(int c) {
        front = -1;
        rear = -1;
        size = 0;
        capacity = c;
        queue = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue is full. Cannot add " + data);
            return;
        }
        if(rear == -1) {
            front = rear = 0;
        } else {
            rear = (rear+1)%capacity;  //circular behavior
        }

        queue[rear] = data;
        size += 1;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued: " + queue[front]);
        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front+1)%capacity;
        }
        size--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity; // Handle circular indexing
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queues q = new Queues(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display(); // Display elements

        q.dequeue();
        q.display(); // Display elements after dequeuing one

        q.enqueue(60);
        q.display(); // Test circular behavior by enqueuing after dequeuing
    }
}

/*
for all operation - O(1).
display - O(n).
 */
