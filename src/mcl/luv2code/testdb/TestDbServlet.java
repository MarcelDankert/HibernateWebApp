package mcl.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 * Als Servlets bezeichnet man Java-Klassen, deren Instanzen innerhalb eines Webservers 
 * Anfragen von Clients entgegennehmen und beantworten. Der Inhalt der Antworten kann dabei dynamisch, 
 * also im Moment der Anfrage, erstellt werden und muss nicht bereits statisch 
 * (etwa in Form einer HTML-Seite) für den Webserver verfügbar sein
 */

//@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Verbindungsvariablen erstellen
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_tutorial?serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pw = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Verbindung überprüfen
		try {
			PrintWriter out  = response.getWriter();
			
			out.println("Verbinde zur Datenbank: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			out.println("Verbindung erfolgreich!!!");
			
			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
