package comparison;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        TestList testList = new TestList();
        int size = 100000;
        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>();

        testList.create(linkedList,size);
        testList.create(arrayList,size);

        System.out.println("Добавление элемента");
        testList.time(testList.add(linkedList),testList.add(arrayList));
        System.out.println("Удаление элемента");
        testList.time(testList.remove(linkedList,size),testList.remove(arrayList,size));
        System.out.println("Вставка элемента в середину");
        testList.time(testList.set(linkedList,size),testList.remove(arrayList,size));

    }

    void create(List<String> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add("test1");
        }
    }

    long  add(List<String> list) {
        long start = System.nanoTime();
        list.add("test2");
        long end = System.nanoTime() - start;
        return end;
    }

    long remove(List<String> list,int size) { ;
        long start = System.nanoTime();
        list.remove(size-1);
        long end = System.nanoTime() - start;
        return end;
    }

    long set(List<String> list, int size) {
        long start = System.nanoTime();
        list.add(size/2,"test4");
        long end = System.nanoTime() - start;
        return end;
    }

    void time(long time1, long time2) {
        if (time1 < time2) {
            System.out.println("LinkedList faster , time work = " + time1);
        } else if (time1 > time2){
            System.out.println("ArrayList faster , time work = " + time2);
        }
    }
}
