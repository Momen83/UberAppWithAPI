package com.example.demo.core;

public  abstract class Person {
    
    protected String userName;
    protected String userPassword;
    protected String userEmail;
    protected String userPhoneNumber;
    protected String userId;
    protected Boolean AccountState;
    protected double userBalance;
    protected String birthDay="";
    public Person ( ) {
        AccountState=false;
    }

    public String getUserId ( ) {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public void setUserPassword ( String Password ) {
        this.userPassword = Password;
    }

    public void setUserEmail ( String userEmail ) {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber ( String userPhoneNumber ) {
        this.userPhoneNumber = userPhoneNumber;
    }
    
    public String getUserName ( ) {
        return userName;
    }

    public String getUserPassword ( ) {
        return userPassword;
    }

    public String getUserEmail ( ) {
        return userEmail;
    }

    public String getUserPhoneNumber ( ) {
        return userPhoneNumber;
    }

    public Boolean getAccountState ( ) {
        return AccountState;
    }

    public void setAccountState ( Boolean accountState ) {
        AccountState = accountState;
    }

    public double getUserBalance ( ) {
        return userBalance;
    }

    public void setUserBalance ( double userBalance ) {
        this.userBalance = userBalance;
    }

    public Person ( String userName , String userPassword , String userEmail , String userPhoneNumber , String userId , Boolean accountState ) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userId = userId;
        AccountState = accountState;
    }

    public String getBirthDay ( ) {
        return birthDay;
    }

    public void setBirthDay ( String birthDay ) {
        this.birthDay = birthDay;
    }
}
