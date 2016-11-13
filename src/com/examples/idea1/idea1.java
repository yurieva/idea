package com.example.idea1;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class idea1 {
    public static Boolean isCharInMass(char[] initMass, char symbol) {
        for (int i = 0; i < initMass.length; i++) {
            if (initMass[i] == symbol)
                return false;
        }
        return true;
    }

    public static int getLengthWithoutNull(char[] arr) { // длина массива обрезаная
        int count = 0;
        for (char el : arr) {
            if (el != 0) {
                ++count;
            }
        }
        return count;
    }

    public static void clear(char[] mass) { // для обнуления массива
        for (int i = 0; i < mass.length; i++) mass[i] = 0;
    }

    /*
    public static int getIndexWithMaxValue(int[] mass) { //находим слово число различных символов в котором максимально
        int value = 0;
        int index = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > value) {
                value = mass[i];
                index = i;
            }
        }
        return index;
    }
    */

    public static int getIndexWithMinValue(int[] mass) { //находим слово число различных символов в котором минимально
        int value = 26; //букв в алфавите или найти максимум и отталкиваясь от него искать минимум
        int index = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < value) {
                value = mass[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] getMassWithDifValues(String[] line) { //считаем число различных символов в каждом слове
        int[] globalMassWithDifSymbols = new int[line.length];
        int i;
        char[] dif = new char[10];

        for (i = 0; i < line.length; i++) {
            char[] word = line[i].toCharArray();

            for (int k = 0; k < word.length; k++) {
                int c = 0;
                dif[c] = word[k];
                for (int j = 0; j < word.length; j++) {
                    if (word[k] != word[j]) {
                        if (isCharInMass(dif, word[j])) { //массив и буква, проверка если уже эта буква в массиве
                            c++;
                            dif[c] = word[j];
                        }
                    }
                }
                break;
            }
            globalMassWithDifSymbols[i] = getLengthWithoutNull(dif);
            clear(dif);
        }
        return globalMassWithDifSymbols;
    }

    public static String[] getInputWords() { // считываем слова и собираем в массив
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слова:");
        String l = scan.nextLine();
        String[] words = l.split(" ");
        return words;
    }

    public static int[] getWordsLength(String[] line) { //длина каждого слова в массиве
        int[] wordsLength =new int[line.length];
        for (int i = 0; i < line.length; i++) {
            char[] word = line[i].toCharArray();
            wordsLength[i]=word.length;
        }
        return wordsLength;
    }
/*
    public static boolean isNumericWord(String word) { //???
        if (word.matches("[0-9]")) {
            System.out.println("numeric");
            return true;
        }
        return false;
    }

    public static void findFirstOrSecondNumeric(String[] word) { //???
        List<String> test = new ArrayList<String>();
        for (String line : word)
        {
            if (isNumericWord(line))
            {
                test.add(line);
            }
        }
        if (test.size()>0)
        System.out.println("Слово состоит только из цифр: " + test.get(0));
        else System.out.println("Второе слово состоит только из цифр: " + test.get(1));
    }
    */


    public static void main(String[] args) {
        String[] words = getInputWords(); //вводим слова и сплитим в массив
        //- Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если таких слов несколько, найти первое из них.
        int[] globalMassWithDifSymbols = getMassWithDifValues(words); // считаем число различных символов в каждом слове
        int minIndex = getIndexWithMinValue(globalMassWithDifSymbols); //находим индекс слова с минимальным количеством различных символов
        System.out.println("Минимальное число различных символов в слове: "+words[minIndex]);
        //- Ввести n слов с консоли. Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.
        int[] globalWordsLength = getWordsLength(words);
        for (int i=0; i<words.length; i++)
        {
            if (globalMassWithDifSymbols[i]== globalWordsLength[i])
            {System.out.println("Слово состоящее только из различных символов: "+words[i]);
            break;}
            //System.out.println("Нет слов состоящих только из различных символов");
        }

        //- Ввести n слов с консоли. Найти слово, состоящее только из цифр. Если таких слов больше одного, найти второе из них.
        //findFirstOrSecondNumeric(words);

    }


}