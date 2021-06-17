package com.example.javaTask.servlets;

import com.example.javaTask.service.StringService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ReadStrings", urlPatterns = {"/ReadStrings"})
public class ReadStrings extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        int chosenPage = Integer.parseInt(request.getParameter("chosenPage"));
        String keyWord = request.getParameter("keyWord");

        StringService stringService = new StringService();

        List<String> strings = stringService.findStrings(keyWord);

        request.setAttribute("Strings", strings);

        int nOfPages = strings.size() / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("chosenPage", chosenPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listCountries.jsp");
        dispatcher.forward(request, response);
    }
    public void destroy() {
    }
}