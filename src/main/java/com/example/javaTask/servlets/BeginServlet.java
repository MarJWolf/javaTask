package com.example.javaTask.servlets;

import com.example.javaTask.data.StringData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BeginServlet", urlPatterns = {"/"})
public class BeginServlet extends HttpServlet {
    StringData stringData =  StringData.getInstance();

    public void init() {
        stringData.Add("University");
        stringData.Add("Java");
        stringData.Add("JavaScript");
        stringData.Add("PHP");
        stringData.Add("HTML");
        stringData.Add("CSS");
        stringData.Add("Spring");
        stringData.Add("Vue");
        stringData.Add("Angular");
        stringData.Add("CSS");
        stringData.Add("CSS");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("El", stringData.getAll());
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

}
