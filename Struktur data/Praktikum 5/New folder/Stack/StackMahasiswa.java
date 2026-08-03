package Stack;

public class StackMahasiswa {
    private Mahasiswa[] stack;
    private int top;
    private int capacity;

    public StackMahasiswa(int size) {
        this.capacity = size;
        this.stack = new Mahasiswa[capacity];
        this.top = 0;
    }

    public boolean isKosong() {
        return top == 0;
    }

    public void push(Mahasiswa data) {
        if (top < capacity) {
            stack[top] = data;
            top++;
        } else {
            System.out.println("Stack Penuh!");
        }
    }

    public Mahasiswa pop() {
        if (!isKosong()) {
            top--;
            Mahasiswa data = stack[top];
            stack[top] = null;
            return data;
        }
        return null;
    }

    public Mahasiswa peek() {
        if (!isKosong()) {
            return stack[top - 1];
        }
        return null;
    }

    public void tampilkanIsiSimple() {
        System.out.print("[");
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i].nilaiHuruf);
            if (i < top - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public void tampil() {
        if (isKosong()) {
            System.out.println("Stack Kosong");
            return;
        }
        System.out.println("--- Isi Stack (Atas ke Bawah) ---");
        for (int i = top - 1; i >= 0; i--) {
            System.out.println("NIM: " + stack[i].nim + " | Nama: " + stack[i].nama +
                    " | Jurusan: " + stack[i].jurusan + " | Nilai: " + stack[i].nilaiHuruf);
        }
    }
}