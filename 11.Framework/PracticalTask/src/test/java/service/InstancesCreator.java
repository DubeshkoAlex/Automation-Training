package service;

import model.Instances;

public class InstancesCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.instances.numberOfInstances";
    public static final String INSTANCES_PURPOSE = "testdata.instances.instancesPurpose";
    public static final String OPERATING_SYSTEM = "testdata.instances.operatingSystem";
    public static final String VM_CLASS = "testdata.instances.vmClass";
    public static final String SERIES = "testdata.instances.series";
    public static final String INSTANCE_TYPE = "testdata.instances.instanceType";
    public static final String GPU_NUMBERS = "testdata.instances.gpuNumbers";
    public static final String GPU_TYPE = "testdata.instances.gpuType";
    public static final String LOCAL_SSD = "testdata.instances.localSSD";
    public static final String DATA_CENTER_LOCATION = "testdata.instances.dataCenterLocation";
    public static final String COMMITED_USAGE = "testdata.instances.commitedUsage";

    public static Instances getParametersFromProperty(){
        return new Instances(Integer.parseInt(TestDataReader.getTestData(NUMBER_OF_INSTANCES)),
                TestDataReader.getTestData(INSTANCES_PURPOSE),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(VM_CLASS),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(INSTANCE_TYPE),
                Integer.parseInt(TestDataReader.getTestData(GPU_NUMBERS)),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                Integer.parseInt(TestDataReader.getTestData(COMMITED_USAGE))
                );
    }
}
