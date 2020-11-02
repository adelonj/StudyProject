package algorithms;

import java.util.LinkedList;
import java.util.List;

public class PhoneBook {
    private static String[] alphabet =
            {"A", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Х", "Ц", "Ф", "Э", "Ю", "Я"};
    private List<Contact> phoneBook;

    public PhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public Contact findByPhone(int phone) {
        return null;
    }
}
