package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int counter = 0;
       for (int i = 1; i < elements.length; i++) {
        int j = i;
        while (j > 0 && elements[j - 1] > elements[j]) {
            int swapElement = elements[j];
            elements[j] = elements[j - 1];
            elements[j - 1] = swapElement;
            j--;
            counter++;
        }
       }
       System.out.println("INSERTION SORT: Number of loop iterations: " + counter);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int counter = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            int min = elements[i];
            int minIdx = i;
            for (int j = i + 1; j < elements.length; j++) {
                counter++;
                if (elements[j] < min) {
                    min = elements[j];
                    minIdx = j;
                }
            }
            elements[minIdx] = elements[i];
            elements[i] = min;
        }
        System.out.println("SELECTION SORT: Number of loop iterations: " + counter);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int counter = 0;
        for (int i = 1; i < words.size(); i++) {
            int j = i;
            while (j > 0 && words.get(j).compareTo(words.get(j - 1)) < 0) {
                words.set(j - 1, words.set(j, words.get(j - 1)));
                j--;
                counter++;
            }
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + counter);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int counter = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            String firstWord = words.get(i);
            int firstWordIdx = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).compareTo(firstWord) < 0) {
                    firstWord = words.get(j);
                    firstWordIdx = j;
                }
            }
            words.set(firstWordIdx, words.set(i, firstWord));
        }
        System.out.println("SELECTION SORT: Number of loop iterations: " + counter);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
        int[] arrA = {106,102,152,132,61,97,75,78,124,84,144,76,125,155,92,73,54,112,142,98,95,170,137,167,145,109,150,171,179,176,62,181,127,134,118,108,86,169,52,81,99,65,94,123,50,172,175,64,173,178,166,111,180,89,158,91,63,85,114,131,126,160,53,90,162,156,55,148,104,57,60,140,116,68,146,105,58,129,71,135,74,139,96,67,56,59,77,80,103,107,117,174,66,141,182,138,128,154,122,164};
        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        int[] arrB = {106,102,152,132,61,97,75,78,124,84,144,76,125,155,92,73,54,112,142,98,95,170,137,167,145,109,150,171,179,176,62,181,127,134,118,108,86,169,52,81,99,65,94,123,50,172,175,64,173,178,166,111,180,89,158,91,63,85,114,131,126,160,53,90,162,156,55,148,104,57,60,140,116,68,146,105,58,129,71,135,74,139,96,67,56,59,77,80,103,107,117,174,66,141,182,138,128,154,122,164};
        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB));
    }
}