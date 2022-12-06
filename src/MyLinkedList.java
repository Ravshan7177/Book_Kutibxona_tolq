import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Item<T> first = null;
    private Item<T> last = null;
    private int size = 0;

    public void add(T value) {
        Item<T> item = new Item<>();
        item.value = value;

        if (first == null) {
            first = item;
            last = item;
        } else {
            last.next = item;
            last = item;
            /*Item temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = item;*/
        }
        size++;
    }

    public void print() {
        Item<T> temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public void addFist(T value) {
        Item<T> item = new Item<>();
        item.value = value;

        item.next = first;
        first = item;
        size++;
    }

    public void addLast(T value) {
        add(value);
    }

    public void add(int index, T value) {
        if (index == 0) {
            addFist(value);
            return;
        }

        if (index > size()) {
            System.out.println("IndexOutOfBound");
            return;
        }

        Item<T> temp = first;
        int count = 0;
        while (temp != null) {
            if (count == index - 1) {
                Item<T> item = new Item<>();
                item.value = value;
                item.next = temp.next;
                temp.next = item;
            }
            count++;
            temp = temp.next;
        }
        size++;
    }


    /**
     * Fetching  value
     */

    public T get(int index) {
        Item<T> temp = first;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.value;
            }
            temp = temp.next;
            count++;
        }
        return null;
    }

    public int indexOf(T value) {
        Item<T> temp = first;
        int count = 0;
        while (temp != null) {
            if (temp.value == value) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    /**
     * Update value
     */

    public T set(int index, T value) {
        Item<T> temp = first;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                T oldValue = temp.value;
                temp.value = value;
                return oldValue;
            }
            temp = temp.next;
            count++;
        }
        return null;
    }

    /**
     * Remove/delete
     */

    public T remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        Item<T> temp = first;
        int count = 0;
        while (temp != null) {
            if (count == index - 1) {
                // temp = 7
                // element = 9
                Item<T> element = temp.next;
                temp.next = element.next;
                element.next = null;
                size--;

                if (element == last) {
                    last = temp;
                }
                return element.value;
            }
            temp = temp.next;
            count++;
        }
        return null;
    }

    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        T value = first.value;
        first = first.next;
        size--;
        return value;
    }

    public void removeLast() {
        remove(size - 1);
    }

    public int remove(T value) {
        int index = indexOf(value);
        remove(index);
        return index;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Is methods
     */

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isContains(T value) {
        return indexOf(value) != -1;
    }

    /**
     * Other methods
     */

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] objArray = new Object[size];
        int index = 0;

        Item<T> temp = first;
        while (temp != null) {
            objArray[index++] = temp;
            temp = temp.next;
        }
        return objArray;
    }

    public void printAll() {

    }

    public void printFirstAndLast() {

    }

    public String toString() {
        // [1,2,3,4,5]
        String s = "[";
        Item<T> temp = first;
        while (temp != null) {
            if (temp == last) {
                s += temp.value;
            } else {
                s += temp.value + ",";
            }
            temp = temp.next;
        }
        s += "]";
        return s;
    }


    /**
     * Iterating
     */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Item<T> temp = first;

            @Override
            public boolean hasNext() {
                if (temp == null) {
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                T value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }


    public class Item<T> {
        public T value;
        public Item<T> next;
    }


}
