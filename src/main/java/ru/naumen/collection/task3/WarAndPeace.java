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
        HashMap<String, Integer> wordToCount = new HashMap<>();
        new WordParser(WAR_AND_PEACE_FILE_PATH)
                .forEachWord(word -> {
                    if (!wordToCount.containsKey(word))
                    {
                        wordToCount.put(word, 0);
                    }
                    wordToCount.put(word, wordToCount.get(word) + 1);
        });

        //Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось
        System.out.println("Все слова:");
        for (String word : wordToCount.keySet())
        {
            System.out.println(word + " " + wordToCount.get(word));
        }
        System.out.println("");

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordToCount.entrySet());


        Collections.sort(entryList, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

        LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }


        //Топ-10 самых редких слов
        System.out.println("Топ-10 самых редких слов");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedHashMap.entrySet()) {
            if (count < 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
        System.out.println("");

        //Топ-10 самых частых слов
        System.out.println("Топ-10 самых частых слов");
        LinkedHashMap<String, Integer> reversedHashMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> reversedList = new ArrayList<>(sortedHashMap.entrySet());
        Collections.reverse(reversedList);
        for (Map.Entry<String, Integer> entry : reversedList) {
            reversedHashMap.put(entry.getKey(), entry.getValue());
        }
        int count1 = 0;
        for (Map.Entry<String, Integer> entry : reversedHashMap.entrySet()) {
            if (count1 < 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count1++;
            } else {
                break;
            }
        }
    }
}
