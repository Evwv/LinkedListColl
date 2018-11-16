import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }
    void test(){
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4",1);
        System.out.println("Произвели добавление элементов , все выводим");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Узнаем индекс элемента test3");
        System.out.println(list.indexOf("test3"));
        System.out.println("Удаляем элемент с индексом 1");
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println("Изменяем значения по индексам");
        list.set(1,"Test1");
        list.set(2,"Test2");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println(list.toString());
        System.out.println("Очищаем коллекцию");
        list.clear();
        System.out.println(list.size());
    }
}

