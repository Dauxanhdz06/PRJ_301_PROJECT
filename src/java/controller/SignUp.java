package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import model.*;
/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns={"/signup"})
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name").trim();
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("pass").trim();
        String repass = request.getParameter("repass").trim();
        String email = request.getParameter("email").trim();
        String phone = request.getParameter("phone").trim();
        UserDAO userdao = new UserDAO();
        if (!name.matches("[A-Z][a-z]*")){
            request.setAttribute("msg", "NAME must have the first letter capitalized");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        }
        else if (user.contains(" ") || pass.contains(" ")) {
            request.setAttribute("msg", "USERNAME or PASSWORD contains space character ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        } 
        else if (user.length() > 30 || pass.length() > 30) {
            request.setAttribute("msg", "USERNAME or PASSWORD must not exceed 30 characters ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
            }
        else if (pass.length() < 4) {
            request.setAttribute("msg", "PASSWORD is too weak ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        } 
        else if (user.equals(pass)) {
            request.setAttribute("msg", "USERNAME or PASSWORD do not overlap ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        } 
        else if (!pass.equals(repass)) {
            request.setAttribute("msg", "PASSWORD and REPEAT PASSWORD do not match ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        }
        else if (!email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+") && !email.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+[.][a-z]+")) {
            request.setAttribute("msg", "EMAIL does not exist ");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        }
        else if (phone == null || !phone.matches("\\d{10}")) {
            request.setAttribute("msg", "Phone number must be exactly 10 digits");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        }
        else if (phone.length() != 10){
            request.setAttribute("msg", "PHONE NUMBER must be 10 digits");
            request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
        }
        
        else{
            User acc = userdao.getAccountByUser(user);
            if(acc != null){
                request.setAttribute("msg", "Account already exists ");
                request.getRequestDispatcher("Hoang_SignUp.jsp").forward(request, response);
            }
            else{
                userdao.createNewAccountUser(name, user, pass, phone, email);
                request.setAttribute("msg2", "Sign Up successfully ");
                request.getRequestDispatcher("Hoang_SignIn.jsp").forward(request, response);
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
