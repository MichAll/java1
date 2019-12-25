package ru.progwards.java1.lessons.arrays;

public class Eratosthenes {
//чтобы узнать, я является ли число n простым,
// нужно взять значение по индексу в массиве. sieve[n].
// Значение true, означает простое число, false - составное.

    private boolean[] sieve;
    // должен разместить массив sieve с размером в N и заполнить его значениями true,
// после чего вызвать метод sift()
    public Eratosthenes(int N) {
        boolean [] sieve = new boolean[N];
        this.sieve = sieve;
        java.util.Arrays.fill(this.sieve, true);
        sift();
    }
    // реализует алгоритм Эратосфена, просеивая составные числа.
    private void sift() {

        int N = sieve.length;
        for (int i=2; i<N-1; i++) {
            for (int j=1; j<N-1; j++) {
                if (i*j>N-1)
                    break;
                else if (i*j==i)
                    continue;
                sieve[i*j] = false;
            }
        }
    }
    // который возвращает sieve[n], что бы можно было узнать,
// простое число n или составное
    public boolean isSimple(int n) {
        int N = sieve.length;
        if (n<0 || n>N-1)
            return false;
        else
            return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes newMass = new Eratosthenes(33);
        System.out.println(newMass.isSimple(11));
    }
}