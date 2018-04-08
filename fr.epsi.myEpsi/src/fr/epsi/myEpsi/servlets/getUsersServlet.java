package fr.epsi.myEpsi.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.hsqlImpl.AnnonceDao;
import fr.epsi.myEpsi.dao.hsqlImpl.UserDao;

/**
 * Servlet implementation class getUsersServlet
 */
@WebServlet("/getUsersServlet")
public class getUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("LOGIN");
		IUserDao userDao = new UserDao();
//		annonceDao.getAnnonces(login);
		List<Utilisateur> myUsers = userDao.getAllUsers();

		request.setAttribute("USERS", myUsers);
		request.getRequestDispatcher("users.jsp").forward(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
