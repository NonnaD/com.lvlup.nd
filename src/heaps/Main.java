package heaps;

public class Main {
    public static void main(String[] args) {
        Heap myHeap = new Heap(2);
        myHeap.insert(22);
        myHeap.insert(19);
        myHeap.insert(18);
        myHeap.insert(15);
        myHeap.insert(3);
        myHeap.insert(14);
        myHeap.insert(4);
        myHeap.insert(12);

        System.out.println(myHeap);


    }
}
