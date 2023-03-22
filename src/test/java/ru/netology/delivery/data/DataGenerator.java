package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        var cities = new String[] {"Майкоп", "Горно-Алтайск", "Уфа", "Махачкала", "Якутск"};
        return cities [new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}