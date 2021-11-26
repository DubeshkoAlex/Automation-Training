package cars;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootCarsObject {
    @JsonProperty("businessCar")
    public BusinessCar[] businessCar;
    @JsonProperty("comfortCar")
    public ComfortCar[] comfortCar;
    @JsonProperty("economyCar")
    public EconomyCar[] economyCar;
    @JsonProperty("familyCar")
    public FamilyCar[] familyCar;

    public RootCarsObject(){}

    public List<Car> toList(){
        List<Car> cars = new ArrayList<Car>();
        cars.addAll(Arrays.asList(businessCar));
        cars.addAll(Arrays.asList(comfortCar));
        cars.addAll(Arrays.asList(economyCar));
        cars.addAll(Arrays.asList(familyCar));
        return cars;
    }
}
