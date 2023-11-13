import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldFindMultipleTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 14);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 10);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket6, ticket2, ticket4};
        Ticket[] actual = manager.search("KGD", "PEE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 14);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 10);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("ARH", "KJA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 14);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 10);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("MMK", "VLG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 17);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 21);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = manager.search("KGD", "PEE", comparator);
        Ticket[] actual = {ticket6, ticket2, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 18);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 21);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = manager.search("KGD", "SVX", comparator);
        Ticket[] actual = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("KZN", "VLG", 1000, 22, 00);
        Ticket ticket2 = new Ticket("KGD", "PEE", 5000, 12, 18);
        Ticket ticket3 = new Ticket("KZN", "VLG", 2000, 17, 19);
        Ticket ticket4 = new Ticket("KGD", "PEE", 9000, 8, 21);
        Ticket ticket5 = new Ticket("MMK", "VLG", 3000, 20, 22);
        Ticket ticket6 = new Ticket("KGD", "PEE", 4000, 2, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = manager.search("MMK", "VLG", comparator);
        Ticket[] actual = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

}
