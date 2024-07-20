public abstract class Pessoa {
    private String name;

    public Pessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract void print();
}
