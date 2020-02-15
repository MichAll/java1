package ru.progwards.java1.lessons.io2;

public class PhoneNumber {

    public static String format(String phone) {
        if ("".equals(phone)) return "";
        String newPhone = "";
        StringBuilder strBuild = new StringBuilder();
        if (phone.length()>9){
            for (char ch: phone.toCharArray()){
                if(Character.isDigit(ch)) strBuild.append(ch);
            }
            newPhone = strBuild.toString();
            if (newPhone.length()==11){
                strBuild.replace(0,1,"+7(");
                strBuild.insert(9, '-');
                strBuild.insert(6, ')');
                newPhone = strBuild.toString();
            } else if (newPhone.length()==10){
                strBuild.insert(6, '-');
                strBuild.insert(3, ')');
                strBuild.insert(0, "+7(");
                newPhone = strBuild.toString();
            } else return "";
        }
        return newPhone;
    }

    public static void main(String[] args) {
        System.out.println(format("8(058)430-85-3311"));
    }
}
