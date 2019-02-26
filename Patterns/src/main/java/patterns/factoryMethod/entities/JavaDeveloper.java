package patterns.factoryMethod.entities;

import patterns.factoryMethod.entities.interfaces.Developer;

public class JavaDeveloper implements Developer {

    private int id;
    private String name;
    private int experience;

    public JavaDeveloper(int id, String name, int experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
    }

    public void writeCode(){
        System.out.println("Java developer wrote java code");
    }

    @Override
    public String toString() {
        return "JavaDeveloper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
