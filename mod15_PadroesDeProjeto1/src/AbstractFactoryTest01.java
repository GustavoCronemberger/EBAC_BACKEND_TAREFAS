
/**
 * @author gusta
 */
public class AbstractFactoryTest01 {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("B", false);
        Factory factory = getFactory(cliente);
        Car car = factory.create(cliente.getCategoria());
        car.startEngine();
    }

    private static Factory getFactory(Cliente cliente) {
        if (cliente.temPj()) {
            return new ContratoPjFactory();
        } else {
            return new ContratoPfFactory();
        }
    }
}
