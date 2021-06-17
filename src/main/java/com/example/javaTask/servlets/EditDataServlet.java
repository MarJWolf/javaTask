package com.example.javaTask.servlets;

import com.example.javaTask.data.StringData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditDataServlet", value = "/EditDataServlet")
public class EditDataServlet extends HttpServlet {

    StringData stringData =  StringData.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delEl = request.getParameter("delElement");
        stringData.Del(delEl);
        request.setAttribute("El", stringData.getAll());
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newEl = request.getParameter("newElement");
        if(!newEl.isEmpty()){
            stringData.Add(newEl);
        }
        request.setAttribute("El", stringData.getAll());
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }
}
