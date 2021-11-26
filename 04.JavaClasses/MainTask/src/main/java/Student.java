public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int yearOfStudy;
    private String group;

    public Student(int id, String firstName, String lastName, String middleName, String dateOfBirth, String address, String phoneNumber, String faculty, int yearOfStudy, String group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.group = group;
    }

    public Student(){
        int tempId = GetInfo.getInt("Please, input the ID: ");
        if(tempId>0){
            this.id = tempId;
        }
        else{
            throw new NumberFormatException("Negative ID!");
        }
        this.firstName = GetInfo.getString("Please, input the First Name: ");
        this.middleName = GetInfo.getString("Please, input the Middle Name: ");
        this.lastName = GetInfo.getString("Please, input the Last Name: ");
        this.dateOfBirth = GetInfo.getString("Please, input the Date of birth: ");
        this.address = GetInfo.getString("Please, input the Address: ");
        this.phoneNumber = GetInfo.getString("Please, input the Phone number: ");
        this.faculty = GetInfo.getString("Please, input the Faculty");
        int tempYearOfStudy = GetInfo.getInt("Please, input the Year of study: ");
        if(tempYearOfStudy>0){
            this.yearOfStudy = tempYearOfStudy;
        }
        else{
            throw new NumberFormatException("Negative Year of study!");
        }
        this.group = GetInfo.getString("Please, input the group: ");
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        if(id>0){
            this.id = id;
        }
        else {
            throw new NumberFormatException("Negative number! ");
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYearOfStudy(int yearOfStudy) {
        if(yearOfStudy>0){
            this.yearOfStudy = yearOfStudy;
        }
        else {
            throw new NumberFormatException("Negative number! ");
        }
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        String s = String.format("%-5d%-15s%-20s%-20s%-25s%-20s%-20s%-15s%-20d%-15s"
                ,id,firstName,middleName,lastName,dateOfBirth,address,phoneNumber,faculty,yearOfStudy,group);
    return s;
    }
}
