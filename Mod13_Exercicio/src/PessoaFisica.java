public class PessoaFisica extends Pessoa {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public PessoaFisica(String name, String cpf) {
        super(name);
        this.cpf = cpf;
    }

    @Override
    public void print() {
        System.out.println("Nome: " + getName() + "." + " CPF: " + cpf + ".");
    }
}
