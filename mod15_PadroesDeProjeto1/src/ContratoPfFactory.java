/**
 * @author gusta
 */
public class ContratoPfFactory extends Factory{
    @Override
    Car retrieveCar(String requisitarCategoria) {
        if ("A".equals(requisitarCategoria)) {
            return new YarisCar(100, "cheio", "azul", "Yaris");
        } else {
            return new OnixCar(80, "alcool", "branca", "Onix");
        }
    }
}
