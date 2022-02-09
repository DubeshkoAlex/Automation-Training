import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable{

    private String carName;
    private final Semaphore parkingPlace;
    private long countSeconds;
    private long timeout;

    public Car(String carName, Semaphore parkingPlace, long countSeconds, long timeout) {
        this.carName = carName;
        this.parkingPlace = parkingPlace;
        this.countSeconds = countSeconds;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            if (parkingPlace.tryAcquire(timeout,TimeUnit.SECONDS)) {
                System.out.println(carName + " is using the parking place");
                Thread.sleep(TimeUnit.SECONDS.toMillis(countSeconds));
            }
            else {
                System.out.println(carName + " left this parking and went to another one");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(carName + " release the parking place");
            parkingPlace.release();
        }
    }
}
