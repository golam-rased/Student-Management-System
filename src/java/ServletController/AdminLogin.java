/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rashu
 */
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            String email = request.getParameter("admin_email");
            String password = request.getParameter("admin_password");

            if (AdminLoginModel.validateAdmin(email, password) != 0) {

                RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");

                rd.forward(request, response);

            } else {

                RequestDispatcher rd = request.getRequestDispatcher("admin_login.jsp");
                rd.include(request, response);
            }
            

        } catch (Exception e) {

        } finally {
            out.close();
        }

    }

}
