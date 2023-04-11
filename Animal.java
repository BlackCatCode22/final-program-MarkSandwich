// dH 10 Apr 23

// Animal.java
// sample Animal Class for final Java program
// sample code from chatGPT 10 Apr 23, code edited by dH 10 Apr 23.

// References:
// https://www.scaler.com/topics/tostring-method-in-java/


public class Animal {
    private static int numOfAnimals = 0;
    private String id;
    private String species;
    private String name;
    private int age;
    private String birthDate;
    private String color;
    private String gender;
    private int weight;
    private String origin;
    private String arrivalDate;

    // Constructor
    public Animal(String id, String species, String name, int age, String birthDate, String color, String gender, int weight, String origin, String arrivalDate) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.color = color;
        this.gender = gender;
        this.weight = weight;
        this.origin = origin;
        this.arrivalDate = arrivalDate;
        numOfAnimals++;
    }

    // Override the toString() method
    @Override
    public String toString() {
        return id + " " +
                species + " " +
                name + " " +
                age + " " +
                birthDate + " " +
                color + " " +
                gender + " " +
                weight + " " +
                origin + " " +
                arrivalDate;
    }

    // Getters and setters
    // Getter methods
    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getColor() {
        return color;
    }

    public String getGender() {
        return gender;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public int getNumOfAnimals() {
        return numOfAnimals;
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
