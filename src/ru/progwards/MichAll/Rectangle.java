package ru.progwards.MichAll;

public class Rectangle {
        private double a;
        private double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double area() {

            return a*b;
        }
    public int compareTo(Rectangle anRectangle) {
        Double res1 = this.area();
        Double res2 = anRectangle.area();
        return res1.compareTo(res2);
    }
//    public int arrayMax(int[] a) {
//        int maxInt;
//        if (a.length>0) {
//            Arrays.sort(a);
//            maxInt=a[a.length-1];
//        }else
//            maxInt=0;
//        return maxInt;
//    }
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(2,4);
        Rectangle rect2 = new Rectangle(4,2);
        System.out.println(rect1.compareTo(rect2));
//        if (result>0)
//            str = ("прямоугольник " + (int) this.a + "x" + (int) this.b + "  >  прямоугольника " + (int) anRectangle.a + "x" + (int) anRectangle.b + " - результат " + result);
//        else if (result == 0)
//                str = ("прямоугольник " + (int) this.a + "x" + (int) this.b + "  ==  прямоугольнику " + (int) anRectangle.a + "x" + (int) anRectangle.b + " - результат " + result);
//        else
//                str = ("прямоугольник " + (int) this.a + "x" + (int) this.b + "  <  прямоугольника " + (int) anRectangle.a + "x" + (int) anRectangle.b + " - результат " + result);
//
//        System.out.println(str);
//        return result;
//        System.out.println();
    }
}
