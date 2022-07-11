package common;

public class Validate {
    //Customer & Employee

    public static final String NUMBER_PHONE = "^09[0|1][0-9]{7}$";
    public static final String NAME = "^([A-Z][a-z]*)+(\\s([A-Z][a-z]*))*$";
    public static final String ID_CARD = "^[0-9]{9}$";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String POSITIVE_NUMBER = "^[1-9][0-9]*";

    //Facility
    public static final String FACILITY_NAME = "^[A-Z]{1}[a-zA-Z0-9]*";

    public static boolean check (String name){
        return name.matches(ID_CARD);
    }
}
