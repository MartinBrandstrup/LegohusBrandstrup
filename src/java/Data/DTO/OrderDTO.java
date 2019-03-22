/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.DTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martin Brandstrup
 */
public class OrderDTO
{

    private int orderId;
    private int customerId;
    private int length;
    private int width;
    private int height;
    private String orderStatus;
    private Date orderSendDate;
    private Date orderReceiveDate;

    //For listing instances from the database
    public OrderDTO(int orderId, int customerId, int length, int width, int height, String orderStatus, Date orderSendDate, Date orderReceiveDate)
    {
        this.orderId = orderId;
        this.customerId = customerId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderStatus = orderStatus;
        this.orderSendDate = orderSendDate;
        this.orderReceiveDate = orderReceiveDate;
    }

    //For persisting new instances to the database
    public OrderDTO(int customerId, int length, int width, int height, Date orderReceiveDate)
    {
        this.customerId = customerId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderReceiveDate = Date.valueOf(LocalDate.now());
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Date getOrderSendDate()
    {
        return orderSendDate;
    }

    public void setOrderSendDate(Date orderSendDate)
    {
        this.orderSendDate = orderSendDate;
    }

    public Date getOrderReceiveDate()
    {
        return orderReceiveDate;
    }

    public void setOrderReceiveDate(Date orderReceiveDate)
    {
        this.orderReceiveDate = orderReceiveDate;
    }

}
