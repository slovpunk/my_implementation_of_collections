package ru.didyk.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyVersionOfList<Integer> myVersionOfList = new MyVersionOfList<>();
        List<Integer> list = new ArrayList<>();

        list.add(99);
        list.add(100);
//        list.add(101);

        myVersionOfList.add(1);
        myVersionOfList.add(2);
//        myVersionOfList.add(3);
//        myVersionOfList.add(4);
//        myVersionOfList.add(5);
//        System.out.println(myVersionOfList.contains("as"));
//        myVersionOfList.addAll(list);
//        myVersionOfList.add(5, 10);
//        myVersionOfList.remove(7);
//        System.out.println(myVersionOfList.size());
//        myVersionOfList.clear();
//        System.out.println(myVersionOfList);

        Iterator<Integer> iterator = myVersionOfList.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


    }
}
