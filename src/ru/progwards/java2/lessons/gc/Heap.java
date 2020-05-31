package ru.progwards.java2.lessons.gc;
/*
Имеется массив байт, который будет представлять из себя кучу - heap. Нужно будет написать алгоритм,
который выделяет и освобождает память (ячейки в массиве) и делает дефрагментацию.
1. Создать конструктор Heap(int maxHeapSize)
2. Создать свойство класса byte[] bytes; - собственно, куча
2. Метод public int malloc(int size) - "размещает", т.е. помечает как занятый блок памяти
с количеством ячеек массива heap равным size. Соответственно это должен быть непрерывный блок
(последовательность ячеек), которые на момент выделения свободны.
Возвращает "указатель" - индекс первой ячейки в массиве, размещенного блока.
3. Метод public void free(int ptr) - "удаляет", т.е. помечает как свободный блок памяти по "указателю".
Проверять валидность указателя - т.е. то, что он соответствует началу ранее выделенного блока,
а не его середине, или вообще, уже свободному.
4. Метод public void defrag() - осуществляет дефрагментацию кучи - ищет смежные свободные блоки,
границы которых соприкасаются и которые можно слить в один.
5. Метод public void compact() - компактизация кучи - перенос всех занятых блоков в начало хипа,
с копированием самих данных - элементов массива. Для более точной имитации производительности
копировать просто в цикле по одному элементу, не используя System.arraycopy.
Обязательно запускаем compact из malloc если не нашли блок подходящего размера
6. Исключения - свои собственные
OutOfMemoryException - нет свободного блока подходящего размера
InvalidPointerException - неверный указатель. Возникает при освобождении блока,
если переданный указатель не является началом блока.
Для реализации этих методов надо будет завести структуру данных - список (или другая структура данных)
свободных блоков. При выделении памяти искать блок подходящего размера в этом списке,
при освобождении - добавлять его туда. Для проверки валидности освобождения указателей - список
(или другая структура данных) занятых блоков. При компактизации саму процедуру замены
старый указателей на новые опускаем, поэтому и делаем не очень эффективное копирование самих данных,
что бы была близкая производительность.
 */
public class Heap {
}
