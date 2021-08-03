package components;

import com.github.javafaker.Faker;

import java.util.*;

import static utils.RandomUtils.getRandomDate;
import static utils.RandomUtils.getRandomItem;

public class RandomFormData {

    private final static List<String> GENDERS = Arrays.asList("Male", "Female", "Other");
    private final static List<String> SUBJECTS = Arrays.asList("Accounting", "Arts", "Civics", "Chemistry"
            , "Commerce", "Computer Science", "Economics", "Maths", "Physics", "Social Studies");
    private final static List<String> HOBBIES = Arrays.asList("Sports", "Reading", "Music");
    private final static List<String> STATES = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    private final static Map<String, List<String>> CITIES = new HashMap<String, List<String>>() {{
        put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
        put("Haryana", Arrays.asList("Karnal", "Panipat"));
        put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
    }};

    private final Faker faker = new Faker();
    private final Calendar dateOfBirth = getRandomDate();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = getRandomItem(GENDERS);
    public String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String subject = getRandomItem(SUBJECTS);
    public String hobby = getRandomItem(HOBBIES);
    public String fileName = "foto.jpg";
    public String currentAddress = faker.address().fullAddress();
    public String state = getRandomItem(STATES);
    public String city = getRandomItem(CITIES.get(state));
    public String day = String.format("%02d", dateOfBirth.get(Calendar.DAY_OF_MONTH));
    public String month = dateOfBirth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    public String year = Integer.toString(dateOfBirth.get(Calendar.YEAR));

    public Map<String, String> dataForCheck = new HashMap<String, String>() {{
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
