package com.arseeniy.colllections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SolutionByStream {
    private static File textFile = new File("C:/CollectionsTest.txt");

    public static void main(String[] args) {
        wordsFromText();
    }

    public static void wordsFromText() {
        List<String> firstList = new ArrayList<>();
        Map<String, Long> wordsMap = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();

        // Подсчет количества повторений слов
        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            while (reader.ready()) {
                String line = reader.readLine();
                firstList.addAll(Arrays.asList(line.split("[^\\p{L}]+")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Подсчет количеста повторений слов
        firstList.stream().forEach(s -> {
            if (!wordsMap.containsKey(s)) {
                wordsMap.put(s, 1L);
            } else {
                wordsMap.put(s, wordsMap.get(s) + 1);
            }
        });

        // Выод списка уникальных слов
        wordsMap.entrySet().stream().filter(p -> p.getValue() == 1).forEach(p -> uniqueWords.add(p.getKey()));
        System.out.println(uniqueWords.toString());

        // Сортировка слов
        firstList = firstList.stream().sorted(Comparator.naturalOrder()).toList();
        System.out.println(firstList.toString());
    }
}
