package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetOperations {
    //  - объединение множеств
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }

    // - пересечение множеств
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        HashSet result = new HashSet(set1);
        result.retainAll(set2);
        return result;
    }

    // - разница множеств
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        HashSet result = new HashSet(set1);
        result.removeAll(set2);
        return result;
    }

    // - симметрическая разница
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        HashSet result = new HashSet(set1);
        HashSet result1 = new HashSet(set1);
        result.addAll(set2);
        result1.retainAll(set2);
        result.removeAll(result1);
        return result;
    }

    public static void main(String[] args) {

    }
}