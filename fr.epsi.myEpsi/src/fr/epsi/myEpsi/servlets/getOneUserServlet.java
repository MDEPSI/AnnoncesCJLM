package fr.epsi.myEpsi.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.mockImpl.UserDao;

/**
 * Servlet implementation class getOneUserServlet
 */
@WebServlet("/getOneUserServlet")
public class getOneUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getOneUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ID");
		System.out.println(id);
		IUserDao userDao = new UserDao();
		
		//TO DO récupérer l'id 
		Utilisateur myUser = userDao.getUtilisateur("ID");

		request.setAttribute("USERS", myUser);
		request.getRequestDispatcher("oneUser.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ad et update
		doGet(request, response);
	}

	
	//ajouter delete
}
