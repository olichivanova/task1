package task1;

public class List {
    private ListElement front;
    private ListElement back;


    void addFront (int data){
        ListElement a = new ListElement();
        a.data = data;
        if (front == null){
            front = a;
            back = a;
        }
        else {
            a.next = front;
            front = a;
        }
    }

    void addBack(int data){
        ListElement a = new ListElement();
        a.data = data;
        if (back == null){
            front = a;
        }
        else {
            back.next = a;
        }
        back = a;
    }
    void showElement (){
        ListElement t = front;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }
    void deleteElement (int data){
        if (front == null)
            return;
        if (front == back){
            front = null;
            back = null;
            return;
        }
        if (front.data == data){
            front = front.next;
            return;
        }
        ListElement t = front;
        while (t.next != null){
            if (t.next.data == data){
                if (back == t.next){
                    back = t;
                }
                t.next = t.next.next;
                return;
            }
            t= t.next;
        }
    }

    void searchMax( int N) {
        try {
            for (int i = 0; i < N; i++){
                ListElement t = front;
                int res = t.data;
                if (t == null)
                    System.out.println("No elements in list");
                while (t != null) {

                    if (t.data > res ){
                        res = t.data;
                    }
                    t = t.next;
                }
                res = res;

                System.out.println(res);
                deleteElement(res);
            }
        }
        catch (NullPointerException e){ }
    }

}
