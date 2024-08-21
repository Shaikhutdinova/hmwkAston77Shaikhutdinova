package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> myList = new CustomArrayList<>();
        myList.add(8);
        List<Integer> temp = new ArrayList<>();
        temp.add(4);
        temp.add(27);
        myList.addAll(temp);
        System.out.println(myList.toString());
        myList.add(1, 3);
        System.out.println(myList.toString());
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList.toString());
        System.out.println(myList.get(2));
        System.out.println(myList.indexOf(8));
        myList.remove(1);
        System.out.println(myList.toString());
        System.out.println( myList.contains(48));
        System.out.println( myList.contains(3));
        myList.clear();
        if(myList.isEmpty()){
            System.out.println("List is empty");
        } else {
            System.out.println(myList.toString());
        }
    }
}
