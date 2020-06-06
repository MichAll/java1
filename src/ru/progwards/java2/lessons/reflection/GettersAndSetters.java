package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;


public class GettersAndSetters {
    static Map<String, String> mapFields = new HashMap<>();
    static Map<String, String> mapGet = new HashMap<>();
    static Map<String, String> mapSet = new HashMap<>();

    public static void check(String name) throws ClassNotFoundException {
        Class clazz = Class.forName(name);
        getFieldsOf(clazz);
        getMethodsOf(clazz);
        for (Map.Entry<String, String> entry : mapFields.entrySet()){
            if (mapGet.containsKey(entry.getKey()) && mapGet.get(entry.getKey()).equals(entry.getValue())) {
            }else
                printStr(1, entry.getValue(),entry.getKey());
            if (mapSet.containsKey(entry.getKey()) && mapSet.get(entry.getKey()).equals(entry.getValue())){
            }else
                printStr(2, entry.getValue(),entry.getKey());
        }
    }

    private static void printStr(int x, String type,String name) {
        if (x==1)
            System.out.println("public "+type+" get"+name+"()");
        else
            System.out.println("public void set"+name+"("+type+" "+name.toLowerCase()+")");
    }

    private static void getMethodsOf(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(m -> {
            if (m.getModifiers() == 1) {
                if(m.getName().substring(0,3).equals("get")&&m.getParameters().length==0) {
                    mapGet.put(m.getName().substring(3),m.getReturnType().getSimpleName());
                }else if(m.getName().substring(0,3).equals("set") && m.getParameters().length==1 && m.getReturnType().equals(Void.TYPE)) {
                    Parameter[] parameters = m.getParameters();
                    mapSet.put(m.getName().substring(3),parameters[0].getType().getSimpleName());
                }
            }
        });
    }

    private static void getFieldsOf(Class clazz) {
        Field[] fields =  clazz.getDeclaredFields();
        for (Field f:fields) {
            if(f.getModifiers()==2){
                String name =f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
                mapFields.put(name, f.getType().getSimpleName());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        check("ru.progwards.java2.lessons.reflection.Person");
        //check("ru.progwards.java2.lessons.reflection.Employee");
    }
}
