//{ Driver Code Starts
import java.util.*;

class TwoStack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            twoStacks g = new twoStacks();
            int Q = sc.nextInt();
            while (Q > 0) {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                if (QueryType == 1) {
                    int a = sc.nextInt();
                    if (stack_no == 1)
                        g.push1(a);
                    else if (stack_no == 2)
                        g.push2(a);
                } else if (QueryType == 2) {
                    if (stack_no == 1)
                        System.out.print(g.pop1() + " ");
                    else if (stack_no == 2)
                        System.out.print(g.pop2() + " ");
                }

                Q--;
            }
            System.out.println();
            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends






class twoStacks {
    int[] arr;
    private static final int DEFAULT = 100;
    int t1,t2,size;
    
    twoStacks() {
        size = DEFAULT;
        arr = new int[size];
        t1 = -1;
        t2 = size;
    }
    

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        if(t1 < t2-1) {
            t1++;
            arr[t1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        // code here
        if(t1 < t2-1) {
            t2--;
            arr[t2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        // code here
        if(t1 >= 0) {
            int ele = arr[t1];
            t1--;
            return ele;
        }
        return -1;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if(t2 < size) {
            int ele = arr[t2];
            t2++;
            return ele;
        }
        return -1;
    }
}