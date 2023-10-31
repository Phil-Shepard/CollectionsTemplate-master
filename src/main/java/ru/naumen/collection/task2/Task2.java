package ru.naumen.collection.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2 {
    public static String getProducts(Ticket ticket, Map<Ticket, String> map){
        return map.get(ticket);
    }

    public static void main(String[] args){
        Map<Ticket, String> map = new HashMap<>();

        Ticket ticket1 = new Ticket(123, "Philipp");
        Ticket ticket2 = new Ticket(1234, "Danil");
        Ticket ticket3 = new Ticket(1235, "Stas");
        Ticket ticket4 = new Ticket(1263, "Nikita");


        map.put(ticket1, "напитки");
        map.put(ticket2, "ничего");
        map.put(ticket3, "еда");
        map.put(ticket4, "напитки и еда");

        System.out.println(getProducts(ticket1, map));
    }
}
