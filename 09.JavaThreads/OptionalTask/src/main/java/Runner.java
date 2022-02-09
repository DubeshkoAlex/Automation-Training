import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        List<Plane> planes = Arrays.asList(
                new Plane("PLANE_1"),
                new Plane("PLANE_2"),
                new Plane("PLANE_3"),
                new Plane("PLANE_4"),
                new Plane("PLANE_5"),
                new Plane("PLANE_6"),
                new Plane("PLANE_7"),
                new Plane("PLANE_8"),
                new Plane("PLANE_9"),
                new Plane("PLANE_10")
        );
        int runwaysCount = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(runwaysCount);
        for (Plane plane:planes) {
            executorService.execute(new Runway(plane));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all planes");
    }
}
