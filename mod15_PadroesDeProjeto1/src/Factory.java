/**
 * @author gusta
 */
public abstract class Factory {

    public Car create(String requisitarCategoria) {
        Car car = retrieveCar(requisitarCategoria);
        car = prepareCar(car);
        return car;
    }
    private Car prepareCar(Car car){
        car.verificarMecanica();
        car.limpar();
        car.completarCombustivel();
        return car;
    }
    abstract Car retrieveCar(String requisitarCategoria);
}
