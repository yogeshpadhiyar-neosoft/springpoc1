package com.neosoft.springPOC1.Constant;

public class Regex {
    public final static String USERNAME="^[a-z][a-z0-9]{5,15}$";
    public final static String EMAILID="^([a-z0-9_\\-\\.]+)@([a-z0-9_\\-\\.]+)\\.([a-z]{2,5})$";
    public final static String PASSWORD="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#$%]).{8,20})";
    public final static String MOBILENO="^[1-9][0-9]{9}$";
    public final static String PINCODE="^\\d\\d\\d\\d\\d\\d$";
    public final static String PERCENTAGE="^\\d\\d.\\d\\d$";
    public final static String YEAR="^[1-9][0-9]{3}$";
}
