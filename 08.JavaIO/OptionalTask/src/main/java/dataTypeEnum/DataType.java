package dataTypeEnum;

public enum DataType {
    INTEGER("integer"),
    DOUBLE("double"),
    CHAR("char"),
    WORD("word");

    private final String name;

    DataType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
