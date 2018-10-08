package datastructure.hierarchical;

public abstract class Animal {
    int age = 0;
    String name = "";
    AnimalType species;
    public Animal(int age, String name, AnimalType species){
	this.age = age;
	this.name = name;
	this.species = species;
    }
    
    public abstract void bark();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getSpecies() {
        return species;
    }

    public void setSpecies(AnimalType species) {
        this.species = species;
    }
}