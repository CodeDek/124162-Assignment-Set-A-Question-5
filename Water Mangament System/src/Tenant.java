public class Tenant {
    private String name;
    private int age;

    public Tenant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Tenant{name='" + name + "', age=" + age + "}";
    }
}
