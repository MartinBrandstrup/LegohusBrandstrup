/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.DTO.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton used in LogicController
 *
 * @author Martin Brandstrup
 */
public class OrderDAO
{

    private static OrderDAO instance = null;

    private OrderDAO()
    {
    }

    public synchronized static OrderDAO getInstance()
    {
        if (instance == null)
        {
            instance = new OrderDAO();
        }
        return instance;
    }

    public List<OrderDTO> getAllOrders() throws DataException
    {
        String query
                = "SELECT * "
                + "FROM legohus.`Order`;";
        List<OrderDTO> orderList = new ArrayList<>();
        try
        {
            ResultSet rs = DBConnector.getConnection().createStatement().executeQuery(query);
            while (rs.next())
            {
                orderList.add(new OrderDTO(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"),
                        rs.getString("order_status"),
                        rs.getDate("order_send_date"),
                        rs.getDate("order_receive_date")
                ));
            }
        } catch (SQLException ex)
        {
            System.out.println("Error in OrderDAO.getAllOrders()\n" + ex.getErrorCode());
            throw new DataException("Error in OrderDAO.getAllOrders()\n");
        }

        return orderList;
    }

    public List<OrderDTO> getCustomerOrders(int customerId) throws DataException
    {
        String query
                = "SELECT * "
                + "FROM legohus.`Order` "
                + "WHERE user_id = " + customerId + ";";
        List<OrderDTO> orderList = new ArrayList<OrderDTO>();
        try
        {
            ResultSet rs = DBConnector.getConnection().createStatement().executeQuery(query);
            while (rs.next())
            {
                orderList.add(new OrderDTO(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"),
                        rs.getString("order_status"),
                        rs.getDate("order_send_date"),
                        rs.getDate("order_receive_date")
                ));
            }
        } catch (SQLException ex)
        {
            System.out.println("Error in OrderDAO.getCustomerOrders()\n" + ex.getErrorCode());
            throw new DataException("Error in OrderDAO.getCustomerOrders()\n");
        }

        return orderList;
    }

    public OrderDTO getOrder(int orderId) throws DataException
    {
        String query
                = "SELECT * "
                + "FROM legohus.`Order` "
                + "WHERE order_id = " + orderId + ";";
        OrderDTO order = null;
        try
        {
            ResultSet rs = DBConnector.getConnection().createStatement().executeQuery(query);
            while (rs.next())
            {
                order = new OrderDTO(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"),
                        rs.getString("order_status"),
                        rs.getDate("order_send_date"),
                        rs.getDate("order_receive_date")
                );
            }

            if (order == null || order.getOrderId() < 1)
            {
                throw new SQLException("No result found with id " + orderId + "");
            }

        } catch (SQLException ex)
        {
            System.out.println("Error in OrderDAO.getOrder(int orderId)\n" + ex.getErrorCode());
            throw new DataException("Error in OrderDAO.getOrder(int orderId)\n");
        }

        return order;
    }

    public void persistOrder(OrderDTO order) throws DataException
    {
        try
        {
            Connection con = DBConnector.getConnection();
//            String date = order.getOrderReceiveDate().toLocalDate().format(DateTimeFormatter.ISO_DATE);

            String query
                    = "INSERT INTO `Order`(`user_id`, `length`, `width`, `height`, `order_receive_date`, `order_status`, `order_send_date`) "
                    + "VALUES (?, ?, ?, ?, ?, DEFAULT, NULL);";

//                    + "VALUES "
//                    + "(" + order.getCustomerId()
//                    + ", " + order.getLength()
//                    + ", " + order.getWidth()
//                    + ", " + order.getHeight()
//                    + ", '" + date + "', DEFAULT, NULL);";
//            int result = DBConnector.getConnection().createStatement().executeUpdate(query);
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setDate(5, order.getOrderReceiveDate());
            ps.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("Error in OrderDAO.createOrder(int customerId, int length, int, width, int height)"
                    + "\nSomething went wrong and the order did not persist"
                    + "\n" + ex.getErrorCode());
            throw new DataException("Error in OrderDAO.createOrder(int customerId, int length, int, width, int height)");
        }
    }

    public void markOrderAsSent(int orderId) throws DataException
    {
        try
        {
            String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

            String query
                    = "UPDATE legohus.`Order` SET "
                    + "legohus.Order.order_status = 'sent' "
                    + "legohus.Order.order_send_date = '" + currentDate + "', "
                    + "WHERE legohus.Order.order_id = " + orderId + ";";

            int result = DBConnector.getConnection().createStatement().executeUpdate(query);

        } catch (SQLException ex)
        {
            System.out.println("Error in OrderDAO.markOrderAsSent(int orderId)\n" + ex.getErrorCode());
            throw new DataException("Error in OrderDAO.markOrderAsSent(int orderId)\n");
        }
    }

}
