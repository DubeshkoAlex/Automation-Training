package service;

public class ConstantData {

    public static final String SEARCHING_REQUEST="testdata.constant.searchingRequest";
    public static final String EXPECTED_COST="testdata.constant.expectedCost";

    public static String getSearchingRequest(){
        return TestDataReader.getTestData(SEARCHING_REQUEST);
    }

    public static String getExpectedCost(){
        return TestDataReader.getTestData(EXPECTED_COST);
    }
}
