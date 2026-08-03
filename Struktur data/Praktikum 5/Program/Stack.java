package Program;
public class Stack {
    int stack[] = new int[20];
    int top;
    public void push(int data)
    {
        stack[top]= data;
        top++;
    }
    public int pop()
    {
        int data;
        data = stack[top];
        top--;
        return data;
    }
    public void tampil ()
    {
        for (int i = top-1; i >=0; i--)
        {
            System.out.print(stack [i] + " ");
  }
 }
}