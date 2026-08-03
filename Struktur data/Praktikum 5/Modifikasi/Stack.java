package Modifikasi;
public class Stack {
    char stack[] = new char[100]; 
    int top;
    public void push(char data)
    {
        stack[top] = data;
        top++;
    }
    public char pop()
    {
        char data;
        if (top > 0) { 
            top--;
            data = stack[top];
            return data;
        } else {
            System.out.println("Stack kosong (Underflow)!");
            return '\0'; 
        }
    }
    public void tampil()
    {
        if (top == 0) {
            System.out.print("Stack kosong.");
            return;
        }
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i]);
        }
    }
}