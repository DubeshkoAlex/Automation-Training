import java.util.Arrays;
import java.util.List;

import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

public class AirportTest {

    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @Test
    public void shouldGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> expectedMilitaryTransportPlanes = Arrays.asList(
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(expectedMilitaryTransportPlanes,
                airport.getTransportMilitaryPlanes(),
                "Expected and result list of transport military planes aren't the same");
    }

    @Test
    public void shouldGetPassengerPlaneWithMaxPassengersCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        Assert.assertEquals(planeWithMaxPassengerCapacity,
                (airport.getPassengerPlaneWithMaxPassengersCapacity()),
                "Expected and result passenger plane with max passengers capacity aren't the same");
    }

    @Test
    public void shouldGetAirportSortedByMaxLoadCapacity() {
        List<Plane> expectedSortedByMaxLoadCapacityPlanes = Arrays.asList(
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Airport airport = new Airport(planes);
        Airport expectedSortByMaxLoadCapacityAirport = new Airport(expectedSortedByMaxLoadCapacityPlanes);
        Assert.assertEquals(expectedSortByMaxLoadCapacityAirport,
                airport.sortByMaxLoadCapacity(),
                "Expected and result airport of sorted by max load capacity planes aren't the same");
    }

    @Test
    public void shouldGetBomberMilitaryPlanes() {
        List<MilitaryPlane> expectedBomberMilitaryPlanes = Arrays.asList(
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER)
        );
        Airport airport = new Airport(planes);
        Assert.assertEquals(expectedBomberMilitaryPlanes,
                airport.getBomberMilitaryPlanes(),
                "Expected and result list of bomber military planes aren't the same");
    }
}
