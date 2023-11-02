package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTestData {

    /*public static void main(String[] args) {
        System.out.println(getRandomGender());
        System.out.println(getRandomInt(1, 30));
        System.out.println(getRandomHobby());
        System.out.println(getRandomPicture());
        System.out.println(getRandomSubject());
    }*/

    Faker faker = new Faker(new Locale("en-GB"));
    private Map<String, String[]> stateAndCity = new HashMap<>();
    {   stateAndCity.put("NCR",            new String[] {"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh",  new String[] {"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana",        new String[] {"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan",      new String[] {"Jaipur", "Jaiselmer"});
    }
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

   public static int getRandomInt(int min, int max) {
         return ThreadLocalRandom.current().nextInt(min, max );
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"nature4.jpg", "nature5.jpg"};
        return getRandomItemFromArray(pictures);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Biology", "Geography", "Literature", "Chemistry"};
        return getRandomItemFromArray(subjects);
    }

    public String state(){
        stateAndCity.toString();
        return faker.options().option(stateAndCity.keySet().toArray()).toString();
    }

    public String city(String state){
        return faker.options().option(stateAndCity.get(state));
    }

}

