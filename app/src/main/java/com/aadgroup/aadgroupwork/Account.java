package com.aadgroup.aadgroupwork;
import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private Boolean isClinician = false;

    public Account(String user, String pass, Boolean is_clinician)
    {
        username = user;
        password = pass;
        isClinician = is_clinician;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public Boolean getIsClinician()
    {
        return isClinician;
    }
}
