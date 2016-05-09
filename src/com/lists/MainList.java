package com.lists;

import java.util.Iterator;

public class MainList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a0");
        list.add("b1");
        list.add("c2");
        list.add("d3");
        list.add("e4");
        list.add("f5");
        list.add("g6");
        list.add("h7");
        list.add("i8");
        list.add("j9");
        System.out.println(list.size());
        System.out.println("Forward iteration");

        Iterator it = list.listIterator();
        int counter = 0;
        while (it.hasNext()) {
            System.out.println(counter + ": Element: " + it.next());
            counter++;
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Random iterator");
        System.out.println();

        Iterator bit = list.randomIterator();
        counter = 0;
        while (bit.hasNext()) {
            System.out.println(counter + ": Element:" + bit.next());
            counter++;
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Random all iteration");
        Iterator rit = list.randomIteratorAll();
        counter=0;
        while (rit.hasNext()) {
            System.out.println(counter + ": Element:" + rit.next());
            counter++;
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Forward iteration");


        it = list.listIterator();
        counter = 0;
        while (it.hasNext()) {
            System.out.println(counter + ": Element: " + it.next());
            counter++;
        }


        System.out.println();
        System.out.println(list);
    }
}
