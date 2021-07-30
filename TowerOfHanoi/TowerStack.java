
package TowerOfHanoi;

import java.util.ArrayList;

public class TowerStack<E> implements StackInterface<E> {


    private ArrayList<E> classArray = new ArrayList<E>();

    public String print() {
        String s = "[";
        for (int x = 0; x < classArray.size(); x++) {
            s += classArray.get(x);
            if (classArray.size() - 1 != x) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }


    @Override
    public void push(E o) {
        classArray.add(0, o);
    }


    @Override
    public E peek() {
        if (classArray.size() == 0) {
            return null;
        } else {
            return classArray.get(0);
        }

    }

    @Override
    public E pop() {
        if (classArray.size() == 0) {
            return null;
        } else {
            return classArray.remove(0);
        }
    }


    @Override
    public boolean empty() {
        if (classArray.size() == 0) {
            return true;
        } else return false;
    }

    @Override
    public int size() {
        return classArray.size();
    }

    @Override
    public E get(int x) {
        if (classArray.size() == 0 || x > classArray.size() - 1 || x < 0) {
            return null;
        } else {
            return classArray.get(x);
        }
    }

    public void clear() {

        classArray.clear();
    }
}