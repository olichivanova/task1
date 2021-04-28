package task1;

public class Task1 {
    public static void main(String[] args) {
        List list = new List();
        list.addFront(5);
        list.addBack(2);
        list.addBack(3);
        list.addBack(8);
        list.addBack(4);
        list.addFront(1);
        list.showElement();
        System.out.println();
        list.searchMax(2);
    }
}
