import java.util.*;

class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList());
    }

    public void printAll() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class lesson6_2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-900-123-45-67");
        phoneBook.add("Петров", "+7-900-987-65-43");
        phoneBook.add("Иванов", "+7-901-111-22-33");
        phoneBook.add("Сидоров", "+7-900-123-45-68");
        phoneBook.add("Васечкин", "+7-900-123-45-69");
        phoneBook.add("Пупкин", "+7-900-123-45-12");
        phoneBook.add("Краснов", "+7-900-123-45-23");
        phoneBook.add("Желтков", "+7-900-123-45-45");
        phoneBook.add("Васечкин", "+7-900-123-45-90");
        List<String> ivanovNumbers = phoneBook.get("Иванов");
        System.out.println("Номера Иванова: " + ivanovNumbers);
        List<String> petrovNumbers = phoneBook.get("Петров");
        System.out.println("Номера Петрова: " + petrovNumbers);
        List<String> sidorovNumbers = phoneBook.get("Сидоров");
        System.out.println("Номера Сидорова: " + sidorovNumbers);
        List<String> vasechkinNumbers = phoneBook.get("Васечкин");
        System.out.println("Номера Васечкина: " + vasechkinNumbers);
        List<String> pupkinNumbers = phoneBook.get("Пупкин");
        System.out.println("Номера Пупкина: " + pupkinNumbers);
        List<String> krasnovNumbers = phoneBook.get("Краснов");
        System.out.println("Номера Краснова: " + krasnovNumbers);
        List<String> zheltkovNumbers = phoneBook.get("Желтков");
        System.out.println("Номера Желткова: " + zheltkovNumbers);
    }
}
