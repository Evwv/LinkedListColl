import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private  int size = 0;
    private  Node<E> first;
    private  Node<E> last;

    @Override
    public void add(E e) {
        Node<E> l = last;
        Node<E> newEntry = new Node<>(l,e,null);
        last = newEntry;
        if (l == null){
            first = newEntry;
        } else {
            l.next = newEntry;
        }
        size++;
    }
    private Node<E> node(int index){
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    @Override
    public void add(E e, int index) {
        Node<E> newEntry = new Node<>(node(index).prev,e,node(index));
        node(index).prev = newEntry;
        node(index-1).next = newEntry;
        size++;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null;) {
            Node<E> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >=0 && index<=size)
            return node(index).item;
        return null;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

     private E removeHelper(Node<E> e) {
        final E x = e.item;
        final Node<E> next = e.next;
        final Node<E> prev = e.prev;

         if (prev == null) {
             first = next;
         } else {
             prev.next = next;
             e.prev = null;
         }

         if (next == null) {
             last = prev;
         } else {
             next.prev = prev;
             e.next = null;
         }

        e.item = null;
        size--;

        return x;
    }
    @Override
    public E remove(int index) {
        return removeHelper(node(index));
    }

    @Override
    public E set(int index, E e) {
        if (index >=0 && index<=size)
            return node(index).item = e;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        int i = 0;
        Object[] mas = new Object[size()];
        for (Node<E> e = first; e != null; e = e.next) {
            mas[i++] = e.item;
        }
        return (E[]) mas;
    }
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public Iterator<E> iterator() {
        return new ownIterator<E>();
    }

    private class ownIterator<E> implements Iterator<E>{

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public ownIterator(){
            if (size == 0){
                next = null;
            } else {
               next = (Node<E>) node(nextIndex);
            }
            nextIndex++;
        }

        @Override
        public boolean hasNext() {
            return nextIndex <= size;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
