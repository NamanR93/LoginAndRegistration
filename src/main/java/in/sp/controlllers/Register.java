package in.sp.controlllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;

import in.sp.dbcon.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationForm")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mypassword = req.getParameter("password1");
		String mycity = req.getParameter("city1");

		try {

			java.sql.Connection con = DbConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO register values(?,?,?,?)");

			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypassword);
			ps.setString(4, mycity);

			int count = ps.executeUpdate();

			if (count >0) {

				out.println("<h1> Registration Successful </h1>");

				RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
				rd.include(req, res);

			} else {
				out.println("<h1 style='background-color:red'> Registration  not successful </h1>");

				RequestDispatcher rd = req.getRequestDispatcher("/Register.html");
				rd.include(req, res);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
