package Tugas;
public class StackMahasiswa {
    Mahasiswa stack[] = new Mahasiswa[20];
    int top;

    public StackMahasiswa() {
        top = 0;
    }

    public void push(Mahasiswa data) {
        if (top < stack.length) {
            stack[top] = data;
            top++;
        } else {
            // Handle Stack Overflow
        }
    }

    public Mahasiswa pop() {
        if (top > 0) {
            top--;
            return stack[top];
        } else {
            return null; // Handle Stack Underflow
        }
    }
    
    // Untuk melihat elemen teratas tanpa menghapusnya
    public Mahasiswa peek() {
        if (top > 0) {
            return stack[top - 1];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }
    
    public void tampil() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println("-> " + stack[i].toString());
        }
    }
}