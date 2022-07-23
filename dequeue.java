import java.util.NoSuchElementException;

public class dequeue {
    private listnode front;
    private listnode rear;
    private int length;

    public class listnode{
        private int data;
        private listnode next;

        public listnode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public dequeue(){
        front = null;
        rear = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        listnode current = front;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data){
        listnode temp = new listnode(data);
        if(isEmpty()){
            front = temp;
        }
        else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }

    public static void main(String[] args){
        dequeue queue = new dequeue();
        queue.enqueue(3);
        queue.enqueue(9);
        queue.enqueue(5);
        queue.print();
        queue.dequeue();
        queue.print();
    }
}
