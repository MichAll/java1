package ru.progwards.MichAll;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class User {
    public Integer id;
    public String name;
    User (Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public TreeSet<User> createSet() {
        TreeSet<User> newUser = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.id, o2.id)*-1;
            }
        });
        return newUser;
    }

    public static void main(String[] args) {
    }
}