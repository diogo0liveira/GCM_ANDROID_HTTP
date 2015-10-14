package com.diogo.mobile.app.model;

/**
 * Created on 08/10/2015 16:24.
 *
 * @author Diogo Oliveira.
 */
public class Cliente
{
    private int id;
    private String registrationId;
    private long registrationDate;

    public Cliente(String registrationId)
    {
        this.registrationId = registrationId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRegistrationId()
    {
        return registrationId;
    }

    public void setRegistrationId(String registrationId)
    {
        this.registrationId = registrationId;
    }

    public long getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(long registrationDate)
    {
        this.registrationDate = registrationDate;
    }
}
