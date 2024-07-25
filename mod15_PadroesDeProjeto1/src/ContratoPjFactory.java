/**
 * @author gusta
 */
public class ContratoPjFactory extends Factory {
    @Override
    Car retrieveCar(String requisitarCategoria) {
        if ("A".equals(requisitarCategoria)) {
            return new PanameraCar(450, "gasolina", "preta", "Panamera");
        } else {
            return new CivicCar(190, "alcool", "branca", "Civic");
        }
    }
}
