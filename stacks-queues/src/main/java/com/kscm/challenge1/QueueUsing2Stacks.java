package com.kscm.challenge1;

import java.util.Stack;

public class QueueUsing2Stacks {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }
    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        stack2.pop();
    }
    // Get the front element.
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }
    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsing2Stacks myQueue = new QueueUsing2Stacks();
        myQueue.push(1); // S1 -> [1], S2 -> [], Q -> [1]
        myQueue.push(2); // S1 -> [1, 2], S2 -> [], Q -> [1, 2]
        myQueue.push(3); // S1 -> [1, 2, 3] , S2 -> [], Q -> [1, 2, 3]
        myQueue.pop(); // S1 -> [] , S2 -> [3, 2, 1] , pop removes 1 from S2 so S2 -> [3, 2], Q -> [2, 3]
        System.out.println(myQueue.peek()); // This will print 2

        myQueue.push(4); // S1 -> [4] , S2 -> [3, 2], Q -> [2, 3, 4]
        System.out.println(myQueue.peek()); // This will print 2

        myQueue.pop(); // s1 -> [4], S2 -> [3], Q -> [3, 4]
        System.out.println(myQueue.peek()); // This will print 3
    }
}
