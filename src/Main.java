
class MyCircularDeque {
    private int currentSize, front, rear;
    public int[] arr;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque() {


        currentSize = 0;
        front = 0;
        rear = 0;
        arr = new int[3];


    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        else {
            arr[front] = value;
            front = (front + arr.length - 1) % arr.length;
            if (currentSize == 0) {
                rear = (rear + arr.length + 1) % arr.length;
            }
            currentSize++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        else {
            arr[rear] = value;
            rear = (rear + arr.length + 1) % arr.length;
            if (currentSize == 0) {
                front = (front + arr.length - 1) % arr.length;
            }
            currentSize++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        else {
            arr[(front + arr.length + 1) % arr.length]= 0;
            front = (front + arr.length + 1) % arr.length;
            currentSize--;
            if (currentSize == 0) {
                rear = 0;
                front = 0;
            }

            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        else {
            arr[(rear + arr.length - 1) % arr.length]= 0;
            rear = (rear + arr.length - 1) % arr.length;
            currentSize--;
            if (currentSize == 0) {
                front = 0;
                rear = 0;
            }
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        else {
            System.out.println("front element: "+ arr[(front + arr.length + 1) % arr.length]);
            return arr[(front + arr.length + 1) % arr.length];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        else {
            System.out.println("Rear element: "+ arr[(rear + arr.length - 1) % arr.length]);
            return arr[(rear + arr.length - 1) % arr.length];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return currentSize == arr.length;
    }

    public void display() {
        for ( int e: arr) {
            System.out.println("Elements "+e);
        }
    }
}



public class Main {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque();
        circularDeque.insertFront(332);
        circularDeque.getRear();
        circularDeque.insertFront(68);
        circularDeque.deleteLast();
        circularDeque.getRear();
        circularDeque.isFull();
        circularDeque.getFront();
        circularDeque.deleteFront();
        circularDeque.isEmpty();
        circularDeque.getRear();
        circularDeque.getFront();
        circularDeque.getFront();
        circularDeque.deleteLast();
        circularDeque.getRear();
        circularDeque.getRear();
        circularDeque.getFront();
        circularDeque.getRear();
        circularDeque.isEmpty();
        circularDeque.deleteLast();
        circularDeque.insertLast(783);
        circularDeque.getFront();

    }
}
