public interface ILinkedList<E> extends Iterable<E>{

    void add(E e);

    void add(E e, int idex);

    void clear();

    E get(int index);

    int indexOf(E e);

    E remove(int index);

    E set(int index, E e);

    int size();

    E[] toArray();

    String toString();





}
