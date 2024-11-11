package ru.netology.javaqa95.HWmvn15.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    AviaSouls ticket = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Сочи", 4500, 6_00, 8_00); //2h
    Ticket ticket2 = new Ticket("Казань", "Москва", 4500, 4_00, 6_00);
    Ticket ticket3 = new Ticket("СПБ", "Москва", 5500, 9_00, 11_00);
    Ticket ticket4 = new Ticket("Москва", "СПБ", 5200, 13_00, 15_00);
    Ticket ticket5 = new Ticket("Уфа", "Москва", 7800, 14_00, 17_00);
    Ticket ticket6 = new Ticket("Москва", "Сочи", 7500, 20_00, 23_00); //3h
    Ticket ticket7 = new Ticket("Казань", "Москва", 8300, 17_00, 19_00);
    Ticket ticket8 = new Ticket("СПБ", "Москва", 4200, 15_00, 17_00);
    Ticket ticket9 = new Ticket("Москва", "Сочи", 4500, 16_00, 18_50); //2.5h
    Ticket ticket10 = new Ticket("Уфа", "Краснодар", 4500, 6_00, 9_00);

    @Test
    public void sortTest() {

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);

        Assertions.assertArrayEquals(new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10}, ticket.findAll());
        Assertions.assertArrayEquals(new Ticket[]{ticket1, ticket9, ticket6}, ticket.search("Москва", "Сочи"));
        Assertions.assertArrayEquals(new Ticket[]{ticket10}, ticket.search("Уфа", "Краснодар"));
        Assertions.assertArrayEquals(new Ticket[]{}, ticket.search("Тайвань", "Сочи"));
    }

    @Test
    public void sortComparatorTest() {
        Ticket ticket11 = new Ticket("Москва", "Сочи", 4500, 12_00, 14_50); //2.5h

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Assertions.assertArrayEquals(new Ticket[]{ticket1, ticket9, ticket11, ticket6}, ticket.search("Москва", "Сочи", comparator));
        Assertions.assertArrayEquals(new Ticket[]{ticket10}, ticket.search("Уфа", "Краснодар", comparator));
        Assertions.assertArrayEquals(new Ticket[]{}, ticket.search("Тайвань", "Сочи", comparator));

    }
}