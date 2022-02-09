import java.util.concurrent.TimeUnit;

public class Runway implements Runnable{

    private final Plane plane;

    public Runway(Plane plane) {
        this.plane = plane;
    }

    public String getPlaneName() {
        return plane.getPlaneName();
    }

    @Override
    public void run() {
        System.out.println(this.getPlaneName() + " began to move to LINE_" + Thread.currentThread().getName().charAt(Thread.currentThread().getName().length()-1));
        timeToOperation(1);
        System.out.println("the LINE_" + Thread.currentThread().getName().charAt(Thread.currentThread().getName().length()-1) + " received the " + this.getPlaneName());
        timeToOperation(1);
        System.out.println(this.getPlaneName() + " took off from LINE_" + Thread.currentThread().getName().charAt(Thread.currentThread().getName().length()-1));
        timeToOperation(1);
        System.out.println("LINE_" + Thread.currentThread().getName().charAt(Thread.currentThread().getName().length()-1) + " is free");
    }

    private void timeToOperation(int timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
