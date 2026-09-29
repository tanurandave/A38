class UserEmtyStackException extends RuntimeException{
    UserEmtyStackException(){
        super();
    }
}
class UserVector<E>{
        private E[] arr;
    private int indx;
    private boolean flag;
    private int increCap;
     // Default constructor
    public UserVector() {
        arr = (E[]) new Object[10];
    }


     public int size() {
        return indx;
    }


    // 5. isEmpty()
    public boolean isEmpty() {
        return size() == 0;
    }

      // 15. addElement()
    public void addElement(E obj) {

        if (size() == capacity()) {
            ensureCapacity(size() + 1);
        }

        arr[indx++] = obj;
    }


    // 16. removeElement()
    public boolean removeElement(Object obj) {

        int index = indexOf(obj);

        if (index >= 0) {
            removeElementAt(index);
            return true;
        }

        return false;
    }


    // toString()
    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        String op = "[";

        for (int i = 0; i < size() - 1; i++) {
            op += arr[i] + ", ";
        }

        op += arr[size() - 1] + "]";

        return op;
    }

}
class UserStack<E>{
    UserStack<E>{

    }
}
public class DriverExampleStack {
    public static void main(String[] args) {
        UserStack<Integer> stack = new UserStack<Integer>();
    }
}
