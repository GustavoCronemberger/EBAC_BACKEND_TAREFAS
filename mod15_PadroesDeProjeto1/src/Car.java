/**
 * @author gusta
 */
public abstract class Car {

    private int potenciaMotor;
    private String tipoCombustivel;
    private String cor;
    private String nome;

    public Car(int potenciaMotor, String tipoCombustivel, String cor, String nome) {
        this.potenciaMotor = potenciaMotor;
        this.tipoCombustivel = tipoCombustivel;
        this.cor = cor;
        this.nome = nome;
    }

    public void startEngine() {
        System.out.println("O " + nome + " está construido e tem " + potenciaMotor + " cavalos de potência!");
    }

    public void limpar() {
        System.out.println("O carro foi lavado, e a lataria de cor " + cor.toLowerCase() + " está brilhando!");
    }

    public void verificarMecanica() {
        System.out.println("O carro foi analisado pelo mecânico, tudo está ok!");
    }

    public void completarCombustivel() {
        System.out.println("O carro está com o tanque cheio de " + tipoCombustivel.toLowerCase() + "!");
    }
}
