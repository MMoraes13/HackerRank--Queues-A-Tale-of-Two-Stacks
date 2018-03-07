import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> filaA = new Stack<T>();
        Stack<T> filaB = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack       
            filaA.push (value);
        }

        public T peek() {
           if (filaB.isEmpty ())
                preparingFilaB();            
            return filaB.peek();
        }

        public T dequeue() {
            if (filaB.isEmpty ())
                preparingFilaB();
            return filaB.pop();
        }
        
        public void preparingFilaB () {
             while (!filaA.isEmpty()) {
                filaB.push (filaA.pop());
            }            
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                 queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

