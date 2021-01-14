package fr.iv.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet.
 * Class TestDbServlet validates the connection 
 * to a database web_calorie_tracker_ui with method toGet.
 * 
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//  connection url
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_calorie_tracker_ui?useSSL=false&serverTimezone=UTC";
		// connection user name
		String user = "healthybody";
		// connection password 
		String password = "beauty";
		//connection driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// connection object
		Connection connection = null;

		//Output stream object. It will write text response in browser for client. 
	   	try (PrintWriter out = response.getWriter()){
			Class.forName(driver);
			//Create connection to the database
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			out.println("Connection to database: " + jdbcUrl+" ... ");
			out.println("success");
		}catch(ClassNotFoundException e){
			e.getMessage();
		}catch (SQLException e) {		
			e.getMessage();
		} finally {
			if (connection != null) {
				try {
					//close connection 
					connection.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
			
		}
	}
}
