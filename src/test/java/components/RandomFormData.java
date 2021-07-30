package components;

import com.github.javafaker.Faker;

import java.util.*;

import static utils.RandomUtils.getRandomDate;
import static utils.RandomUtils.getRandomItem;

public class RandomFormData {

    private final Faker faker = new Faker();

    private final static List<String> genders = Arrays.asList("Male", "Female", "Other");
    private final static List<String> subjects = Arrays.asList("Accounting", "Arts", "Civics", "Chemistry"
            , "Commerce", "Computer Science", "Economics", "Maths", "Physics", "Social Studies");
    private final static List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
    private final static List<String> states = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    private final static Map<String, List<String>> cities = new HashMap<>() {{
        put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        put("Haryana", Arrays.asList("Karnal", "Panipat"));
        put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
    }};

    private final Calendar dateOfBirth = getRandomDate();

    public final String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomItem(genders),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            subject = getRandomItem(subjects),
            hobby = getRandomItem(hobbies),
            fileName = "foto.jpg",
            currentAddress = faker.address().fullAddress(),
            state = getRandomItem(states),
            city = getRandomItem(cities.get(state)),
            day = String.format("%02d", dateOfBirth.get(Calendar.DAY_OF_MONTH)),
            month = dateOfBirth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH),
            year = Integer.toString(dateOfBirth.get(Calendar.YEAR));

    public final Map<String,String> dataForCheck = new HashMap<>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", email);
        put("Gender", gender);
        put("Mobile", mobileNumber);
        put("Date of Birth", day + " " + month + "," + year);
        put("Subjects", subject);
        put("Hobbies", hobby);
        put("Picture", fileName);
        put("Address", currentAddress);
        put("State and City", state + " " + city);
    }};
}
