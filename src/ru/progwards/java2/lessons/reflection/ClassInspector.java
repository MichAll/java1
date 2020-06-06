package ru.progwards.java2.lessons.reflection;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;

public class ClassInspector {

    public static void inspect(String name) throws ClassNotFoundException, IOException {

        Class clazz = Class.forName(name);
        FileWriter fileWriter = new FileWriter( clazz.getSimpleName()+".java");
        String result;
        result = "class " + clazz.getSimpleName() + " {";
        fileWriter.write(result+"\n");
        System.out.println(result);

        Field[] fields =  clazz.getDeclaredFields();
        for (Field f:fields) {
            int mod = f.getModifiers();
            result = Modifier.toString(mod)+" "+f.getType().getSimpleName()+" "+f.getName()+";";
            System.out.printf("\t%s %s",result,"\n");
            fileWriter.write("\t"+result+"\n");
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c:constructors) {
            String strConstr = Modifier.toString(c.getModifiers())+" " +clazz.getSimpleName()+"(";
            Parameter[] parameters = c.getParameters();
            String strParam = "";
            for (int i = 0; i<parameters.length;i++){
                strParam += parameters[i].getType().getSimpleName()+" "+ parameters[i].getName();
                if (parameters.length>i+1)
                    strParam +=", ";
            }
            result = strConstr+strParam +") {}";
            System.out.printf("\t%s %s",result,"\n");
            fileWriter.write("\t"+result+"\n");
        }
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(m -> {
            String mod = Modifier.toString(m.getModifiers());
            Parameter[] parameters = m.getParameters();
            String strMeth = mod+" " +
                    ""+m.getReturnType().getSimpleName() +" " +
                    ""+m.getName();
            String strParam = "";
            for (int i = 0; i<parameters.length;i++){
                strParam += parameters[i].getType().getSimpleName()+" "+ parameters[i].getName();
                if (parameters.length>i+1)
                    strParam +=", ";
            }
            System.out.printf("\t%s %s ",strMeth+"("+strParam +") {}","\n");
            try {
                fileWriter.write("\t"+strMeth+"("+strParam +") {}"+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("}");
        fileWriter.write( "}");
        fileWriter.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        inspect("ru.progwards.java2.lessons.reflection.Employee");
    }
}
