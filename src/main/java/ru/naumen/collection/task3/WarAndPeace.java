package ru.naumen.collection.task3;

import java.nio.file.Path;
import java.util.*;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");

    public static void main(String[] args) {
        HashMap<String, Integer> wordToCount = new LinkedHashMap<>();
        new WordParser(WAR_AND_PEACE_FILE_PATH)
                .forEachWord(word -> {
                    if (!wordToCount.containsKey(word))
                    {
                        wordToCount.put(word, 0);
                    }
                    wordToCount.put(word, wordToCount.get(word) + 1);
        });

        List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordToCount.entrySet());
        Collections.sort(wordCountList, Map.Entry.comparingByValue());
        Collections.reverse(wordCountList);
        System.out.println("Наиболее используемые слова:");
        for (int i = 0; i < 10; i++) {
            System.out.println(wordCountList.get(i).getKey() + " " + wordCountList.get(i).getValue());
        }
        System.out.println("");

        Collections.reverse(wordCountList);
        System.out.println("Наименее используемые слова:");
        for (int i = 0; i < 10; i++) {
            System.out.println(wordCountList.get(i).getKey() + " " + wordCountList.get(i).getValue());
        }
    }
}
