package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

class Order {
    public String shopId;           // идентификатор магазина
    public String orderId;          // идентификатор заказа
    public String customerId;       // идентификатор покупателя
    public LocalDateTime datetime;  // дата-время заказа(из атрибутов файла-дата последнего изменения)
    public List<OrderItem> items;   // список позиций в заказе, отсортированный по наименованию товара
    public double sum;             // сумма стоимости всех позиций в заказе

    public Order() {
        items = new ArrayList<OrderItem>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "shopId='" + shopId +
                ", orderId='" + orderId +
                ", customerId='" + customerId +
                ", datetime=" + datetime +
                ", items=" + items +
                ", sum=" + sum +
                '}';
    }
}

class OrderItem {
    public String googsName;    // наименование товара
    public int count;           // количество
    public double price;        // цена за единицу

    @Override
    public String toString() {
        return "\nOrderItem{" + googsName + ", count=" + count + ", price=" + price + '}';
    }
}

public class OrderProcessor {

    // инициализирует класс, с указанием начальной папки для хранения файлов
    Path startPath;
    List<Order> listOrder;
    int failFiles = 0;

    public OrderProcessor(String startPath) {
        this.startPath = Paths.get(startPath);
    }

    public boolean checkDate(LocalDate start, LocalDate finish, Path path) throws IOException {
        if (start == null && finish == null) return true;
        LocalDate fileDate = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault()).toLocalDate();
        if (fileDate == null) return false;
        return !((start != null && fileDate.isBefore(start)) || (finish != null && fileDate.isAfter(finish)));
    }

    //  загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
//  Если start == null, значит нет ограничения по дате слева, если finish == null,
//  значит нет ограничения по дате справа, если shopId == null - грузим для всех магазинов
//  При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е. Не поступает в обработку.
//  Метод возвращает количество файлов с ошибками. При этом, если в классе содержалась информация, ее надо удалить
    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        List<Order> listOrder = new ArrayList<>(); //удаляем инфу?
        String shopNull = shopId == null ? "???" : shopId;
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/" + shopNull + "-??????-????.csv");
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(path)) {
                        if (checkDate(start, finish, path)) {
                            List<OrderItem> listItems = new ArrayList<>();
                            List<String> items = new ArrayList<>((Files.readAllLines(path)));
                            Double summa = 0d;
                            for (String str : items) {
                                String[] item = str.split(",");
                                OrderItem newItems = new OrderItem();
                                newItems.googsName = item[0].trim();
                                newItems.count = Integer.parseInt(item[1].trim());
                                newItems.price = Double.parseDouble(item[2].trim());
                                summa += newItems.count * newItems.price;
                                listItems.add(newItems);
                            }
                            Collections.sort(listItems, new Comparator<OrderItem>() {
                                @Override
                                public int compare(OrderItem o1, OrderItem o2) {
                                    return o1.googsName.compareTo(o2.googsName);
                                }
                            });
                            String fileName = path.getFileName().toString();
                            String[] str = fileName.substring(0, fileName.lastIndexOf(".")).split("-");
                            Order newOrder = new Order();
                            newOrder.datetime = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault());
                            newOrder.shopId = str[0];
                            newOrder.orderId = str[1];
                            newOrder.customerId = str[2];
                            newOrder.sum = summa;
                            listOrder.add(newOrder);
                        }else
                            failFiles++;
                    }
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return failFiles;
    }

    // выдать список заказов в порядке обработки (отсортированные по дате-времени), для заданного магазина.
// Если shopId == null, то для всех
    public List<Order> process(String shopId) {
        List<Order> result = new ArrayList<>();
        for (Order o : listOrder) {
            if (shopId == null || o.shopId.compareTo(shopId)==0) result.add(o);
        }
        Collections.sort(result, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        });
        return result;
    }

    // выдать информацию по объему продаж по магазинам (отсортированную по ключам):
// String - shopId, double - сумма стоимости всех проданных товаров в этом магазине
    public Map<String, Double> statisticsByShop() {
        Map<String, Double> result = new TreeMap<>();
        for (Order o : listOrder) {
            if(result.containsKey(o.shopId)) result.put(o.shopId, result.get(o.shopId) + o.sum);
        }
        return result;
    }

    // выдать информацию по объему продаж по товарам (отсортированную по ключам):
// String - goodsName, double - сумма стоимости всех проданных товаров этого наименования
    public Map<String, Double> statisticsByGoods() {
        Map<String, Double> result = new TreeMap<>();
        for (Order order : listOrder) {
            for (OrderItem item : order.items) {
                if (result.containsKey(item.googsName)) result.put(item.googsName, result.get(item.googsName) + item.count * item.price);
                }
            }
        return result;
    }

    // выдать информацию по объему продаж по дням (отсортированную по ключам):
// LocalDate - конкретный день, double - сумма стоимости всех проданных товаров в этот день
    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> result = new TreeMap<LocalDate, Double>();
        for (Order o : listOrder) {
            LocalDate key = o.datetime.toLocalDate();
            boolean isExists = result.containsKey(key);
            double sum = isExists ? result.get(key) : 0;
            result.put(key, sum + o.sum);
        }
        return result;
    }
}
/*
    Информация о заказах поступает в виде файлов, которые лежат в под-папках разбитых по неделям, имена папок не имеют значения.
    Имя каждого файла имеет формат: AAA-999999-ZZZZ.csv где AAA - обязательные 3 символа shopId - идентификатор магазина,
    999999 - обязательные 6 символов orderId - номер заказа, ZZZZ - обязательные 4 символа customerId - идентификатор покупателя,
    расширение файла - csv, например S02-P01X12-0012.csv: shopId=”S02”, orderId=”P01X12”, customerId=”0012”
        Содержимое каждого файла имеет формат CSV (Comma Separated Values) со следующими данными
        Наименование товара, количество, цена за единицу
        Например:
        Игрушка мягкая “Мишка”, 1, 1500
        Пазл “Замок в лесу”, 2, 700
        Книжка “Сказки Пушкина”, 1, 300
*/