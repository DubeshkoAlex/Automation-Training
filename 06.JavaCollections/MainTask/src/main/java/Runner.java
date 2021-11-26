import cars.RootCarsObject;
import utils.FileWriterUtil;
import utils.JsonUtil;

public class Runner {
    public static void main(String[] args) {
        String sourceFile = "src/sourceFiles/allCars.json";
        String resultFile = "src/outputFiles/result.txt";
        RootCarsObject rootCarsObject = JsonUtil.fromJsonFile(sourceFile, RootCarsObject.class);
        TaxiPark taxiPark = new TaxiPark(rootCarsObject.toList());
        FileWriterUtil.toTextFile(
                resultFile,
                false,
                "Taxi Park cost:",String.valueOf(taxiPark.TaxiParkCost())
        );
        FileWriterUtil.toTextFile(
                resultFile,
                true,
                "Sorting by fuel consumption:",
                taxiPark.sortByFuelConsumption().toString()
        );
        FileWriterUtil.toTextFile(
                resultFile,
                true,
                "Car with setting range speed:",
                taxiPark.findCarsInSpeedRange(100,300).toString()
        );
    }
}
