/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.LogicController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin Brandstrup
 */
@WebServlet(name = "FrontController", urlPatterns =
{
    "/FrontController"
})
public class FrontControllerLego extends HttpServlet
{

    private final LogicController ctrl = LogicController.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String commandKey = request.getParameter("command");
        Command command = CommandController.commandFrom(commandKey);
        try
        {
            String target = command.execute(request, ctrl);
            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        } catch (CommandException ce)
        {
            request.setAttribute("message", ce.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(ce.getTarget());
            dispatcher.forward(request, response);
        } catch (Exception ex)
        {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head><title>PANIC Page</title></head>");
            out.println("  <body>");
            out.println("    <h3>" + ex.getMessage() + "</h3><hr/>");
            out.println("    <pre>");
            out.print("</pre>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException
//    {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter())
//        {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FrontController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FrontController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException
//    {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException
//    {
//        processRequest(request, response);
//    }
}
