import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore parkingPlace = new Semaphore(3);
        List<Car> cars = Arrays.asList(
                new Car("Audi",parkingPlace,5,25),
                new Car("BMW",parkingPlace,10,10),
                new Car("Lada",parkingPlace,15,5),
                new Car("Honda",parkingPlace,15,5),
                new Car("Nissan",parkingPlace,15,5)
        );
        for (Car car:cars) {
            new Thread(car).start();
        }
    }
}
