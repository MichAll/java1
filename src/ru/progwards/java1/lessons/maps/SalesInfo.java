package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.*;

public class SalesInfo {

    private List<String[]> saleS = new ArrayList<>();
// вернуть количество успешно загруженных строк. Если в строке более или менее 4-x полей,
// или количество и сумма не преобразуются в числа - эту строку не загружаем.
    public int loadOrders(String fileName){
        int i = 0;
        try (FileReader fileRead = new FileReader(fileName)) {
            try (Scanner scanner = new Scanner(fileRead)) {
                while (scanner.hasNextLine()) {
                    String [] str = scanner.nextLine().split(", ");
                    if (str.length == 4) {
                        try {
                            Integer.parseInt(str[2]);
                            Double.parseDouble(str[3]);
                            i++;
                            saleS.add(str);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
// - вернуть список товаров, отсортированный по наименованию товара.
// В String - наименование товара, в Double - общая сумма продаж по товару
    public Map<String, Double> getGoods() {
        if (saleS.isEmpty()) return null;
        TreeMap<String, Double> treeS = new TreeMap<>();
        for (String[] str : saleS) {
            if (treeS.containsKey(str[1]))
                treeS.replace(str[1], treeS.get(str[1]) +Double.parseDouble(str[3]));
            else
                treeS.put(str[1], Double.parseDouble(str[3]));
        }
        return treeS;
    }
//  вернуть список покупателей, отсортированный по алфавиту.
//  В String  - ФИ, в Double - сумма всех покупок покупателя, в Integer - количество покупок
    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        if (saleS.isEmpty()) return null;
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> treeS = new TreeMap<>();
        for (String[] str : saleS) {
            if (treeS.containsKey(str[0])){
                AbstractMap.SimpleEntry simEnt = treeS.get(str[0]);
                simEnt = new AbstractMap.SimpleEntry<>(((double)simEnt.getKey()+Double.parseDouble(str[3])),((int) simEnt.getValue() + Integer.parseInt(str[2])));
                treeS.replace(str[0], simEnt);
            }else {
                AbstractMap.SimpleEntry simEnt = new AbstractMap.SimpleEntry<>(Double.parseDouble(str[3]), Integer.parseInt(str[2]));
                treeS.put(str[0], simEnt);
            }
        }
        return treeS;
    }

    public static void main(String[] args) {
        SalesInfo salesInf = new SalesInfo();
        System.out.println(salesInf.loadOrders("D:/JavaPackage/Sales.csv"));
        for ( Map.Entry<String, Double> entry : salesInf.getGoods().entrySet()) {
            System.out.println(entry);
        }
        for (Map.Entry<String, AbstractMap.SimpleEntry<Double, Integer>> entry : salesInf.getCustomers().entrySet()) {
            System.out.println(entry);
        }
    }

// Протестировать на данных на примере
//Информация по продажам
//
//Во входном файле находятся данные в CSV формате, CSV - Comma Separated Values, значения разделенные запятыми.
// Каждая строка - данные об одной покупке. Входные данные
//
//ФИ покупателя, наименование товара, количество, сумма
//
//String, String, int, double
//
//Пример
//
//Иванов Сергей, iPhone 10X, 2, 150000
//Петрова Анна, наушники JBL, 2, 7000
//Иванов Сергей, чехол для iPhone, 1, 1000
//Петрова Анна, пакет пластиковый, 1, 3
//Радж Кумар, батарейка ААА, 1, 150
//Михаил Цикло, iPhone 10X, 1, 75000
//Радж Кумар, пакет пластиковый, 1, 3
//Михаил Цикло, пакет пластиковый, 1, 3
//Иванов Сергей, стекло защитное, 1, 1000
//Василий Пупкин, спички, 10, 10
}
