package helpers;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    public static String getRandomItem(List<String> items) {
        return items.get(new Random().nextInt(items.size()));
    }

    public static Calendar getRandomDate() {
        Faker faker = new Faker();
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(faker.date().birthday());
        return dateOfBirth;
    }
}