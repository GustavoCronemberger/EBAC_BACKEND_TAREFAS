public class ExercicioMod13Test {
    public static void main(String[] args) {
        Pessoa pessoa1 = new PessoaFisica("Rodrigo", "765467888-00");
        Pessoa pessoa2 = new PessoaJuridica("PiresLTDA", "213248.33/0001-99");


        pessoa1.print();
        pessoa2.print();
    }
}