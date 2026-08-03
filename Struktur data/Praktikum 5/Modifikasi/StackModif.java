package Modifikasi;
public class StackModif {
    String stack[] = new String[50];
    int top = 0;
    public void push(String data) {
        if (top < stack.length) {
            stack[top] = data;
            top++;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan kata.");
        }
    }
    public String pop() {
        if (top > 0) {
            top--;
            String data = stack[top];
            return data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }
}