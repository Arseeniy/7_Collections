package com.arseeniy.colllections;

import java.io.*;
import java.util.*;

public class Solution {
    private static File textFile = new File("C:/CollectionsTest.txt");

    public static void main(String[] args) {
        wordsFromText();
    }

    public static void wordsFromText() {
        List<String> firstList = new ArrayList<>();
        Map<String, Long> wordsMap = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            while (reader.ready()) {
                String line = reader.readLine();
                firstList.addAll(Arrays.asList(line.split("[^\\p{L}]+")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Подсчет количества повторений слов
        for (String word : firstList) {
            if (wordsMap.containsKey(word)) {
                wordsMap.replace(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1L);
            }
        }

        // Вывод списка уникальных слов
        for (Map.Entry<String, Long> pair : wordsMap.entrySet()) {
            if (pair.getValue() == 1) {
                uniqueWords.add(pair.getKey());
            }
        }
        System.out.println("Список уникальных слов:");
        System.out.println(uniqueWords.toString());

        //Сортировка слов
        Collections.sort(firstList, Comparator.naturalOrder());
        System.out.println(firstList.toString());
    }
}
