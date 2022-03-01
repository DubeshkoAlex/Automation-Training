package model;

import java.util.Locale;
import java.util.Objects;

public class Instances {

    private int numberOfInstances;
    private String instancesPurpose;
    private String operatingSystem;
    private String vmClass;
    private String series;
    private String instanceType;
    private int gpuNumbers;
    private String gpuType;
    private String localSSD;
    private String dataCenterLocation;
    private int commitedUsage;

    public Instances(){}

    public Instances(int numberOfInstances, String instancesPurpose,
                     String operatingSystem, String vmClass,
                     String series, String instanceType, int gpuNumbers,
                     String gpuType, String localSSD,
                     String dataCenterLocation, int commitedUsage)
    {
        this.numberOfInstances = numberOfInstances;
        this.instancesPurpose = instancesPurpose;
        this.operatingSystem = operatingSystem;
        this.vmClass = vmClass;
        this.series = series;
        this.instanceType = instanceType;
        this.gpuNumbers = gpuNumbers;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getInstancesPurpose() {
        return instancesPurpose;
    }

    public void setInstancesPurpose(String instancesPurpose) {
        this.instancesPurpose = instancesPurpose;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public int getGpuNumbers() {
        return gpuNumbers;
    }

    public void setGpuNumbers(int gpuNumbers) {
        this.gpuNumbers = gpuNumbers;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public int getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(int commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instances instances = (Instances) o;
        return numberOfInstances == instances.numberOfInstances
                && gpuNumbers == instances.gpuNumbers
                && Objects.equals(instancesPurpose, instances.instancesPurpose)
                && Objects.equals(operatingSystem, instances.operatingSystem)
                && Objects.equals(vmClass, instances.vmClass)
                && Objects.equals(series, instances.series)
                && Objects.equals(instanceType, instances.instanceType)
                && Objects.equals(gpuType, instances.gpuType)
                && Objects.equals(localSSD, instances.localSSD)
                && Objects.equals(dataCenterLocation, instances.dataCenterLocation)
                && commitedUsage == instances.commitedUsage;
    }

    public boolean equalsBySmokeTestParam(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instances instances = (Instances) o;
        return Objects.equals(vmClass.toLowerCase(Locale.ROOT), instances.vmClass.toLowerCase(Locale.ROOT))
                && Objects.equals(instanceType.toLowerCase(Locale.ROOT), instances.instanceType.toLowerCase(Locale.ROOT))
                && Objects.equals(localSSD.toLowerCase(Locale.ROOT), instances.localSSD.toLowerCase(Locale.ROOT))
                && Objects.equals(dataCenterLocation.toLowerCase(Locale.ROOT), instances.dataCenterLocation.toLowerCase(Locale.ROOT))
                && commitedUsage == instances.commitedUsage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, instancesPurpose, operatingSystem, vmClass, series, instanceType,
                gpuNumbers, gpuType, localSSD, dataCenterLocation, commitedUsage);
    }

    @Override
    public String toString() {
        return "Instances{" +
                "numberOfInstances=" + numberOfInstances +
                ", instancesPurpose='" + instancesPurpose + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", gpuNumbers=" + gpuNumbers +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }
}
