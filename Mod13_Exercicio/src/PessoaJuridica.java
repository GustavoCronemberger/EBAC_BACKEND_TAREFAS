public class PessoaJuridica extends Pessoa {
    private String CNPJ;

    public String getCNPJ() {
        return CNPJ;
    }

    public PessoaJuridica(String name, String CNPJ) {
        super(name);
        this.CNPJ = CNPJ;


    }

    @Override
    public void print() {
        System.out.println("Empresa: " + getName() + "." + " CNPJ: " + getCNPJ() + ".");
    }
}
