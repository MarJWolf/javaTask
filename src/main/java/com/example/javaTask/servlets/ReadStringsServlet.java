package com.example.javaTask.servlets;

import com.example.javaTask.data.StringData;
import com.example.javaTask.service.StringService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ReadStringsServlet", urlPatterns = {"/ReadStringsServlet"})
public class ReadStringsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringData stringData =  StringData.getInstance();
        request.setAttribute("Data", stringData.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/DataEdit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        int chosenPage = Integer.parseInt(request.getParameter("chosenPage"));
        String keyWord = request.getParameter("keyWord");

        StringService stringService = new StringService();

        List<String> strings = stringService.findStrings(keyWord);

        request.setAttribute("Data", strings);

        int nOfPages = strings.size() / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) { nOfPages++; }
        if (nOfPages == 0) {nOfPages = 1;}

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("chosenPage", chosenPage);
        request.setAttribute("beginValue", recordsPerPage*(chosenPage-1));
        request.setAttribute("endValue", (recordsPerPage*(chosenPage-1))+(recordsPerPage-1));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Result.jsp");
        dispatcher.forward(request, response);
    }



}