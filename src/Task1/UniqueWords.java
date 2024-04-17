package Task1;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        // Создаем массив слов
            String[] words = {"Wine", "Tequila", "Wine", "Beer", "Tequila", "Wine", "Whiskey", "Whiskey", "Vodka", "Beer", "Tequila", "Vodka", "Vodka", "Whiskey"};

            // Создаем список из слов и удаляем дубликаты
            List<String> wordList = new ArrayList<>(Arrays.asList(words));
            List<String> uniqueWords = new ArrayList<>();
            for (String word : wordList) {
                if (!uniqueWords.contains(word)) {
                    uniqueWords.add(word);
                }
            }

            // Выводим список уникальных слов
            System.out.println("Уникальные слова: " + uniqueWords);

            // Создаем карту для подсчета количества повторов слов
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : uniqueWords) {
                wordCount.put(word, 0);
            }
            for (String word : wordList) {
                wordCount.put(word, wordCount.get(word) + 1);
            }

            // Выводим количество повторов каждого слова
            System.out.println("Количество повторов каждого слова: " + wordCount);
    }
}
