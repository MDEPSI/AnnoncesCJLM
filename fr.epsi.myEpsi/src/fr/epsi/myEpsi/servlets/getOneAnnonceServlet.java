package fr.epsi.myEpsi.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.mockImpl.AnnonceDao;

/**
 * Servlet implementation class getOneAnnonceServlet
 */
@WebServlet("/getOneAnnonceServlet")
public class getOneAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getOneAnnonceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		IAnnonceDao annonceDao = new AnnonceDao();
		
		//TO DO récupérer l'id 
		annonceDao.deleteAnnonce(id);

		super.doDelete(req, resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		IAnnonceDao annonceDao = new AnnonceDao();
		
		//TO DO récupérer l'id 
		Annonce myAnnonce = annonceDao.getAnnonceById(id);
		System.out.println(myAnnonce);
		request.setAttribute("ANNONCES", myAnnonce);
		request.getRequestDispatcher("oneAnnonce.jsp").forward(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = request.getParameter("titre");
		int id = Integer.valueOf(request.getParameter("id"));
		IAnnonceDao annonceDao = new AnnonceDao();
		annonceDao.getAnnonceById(id);
		RequestDispatcher rd = request.getRequestDispatcher("getAnnoncesServlet");
		rd.forward(request,response);
//		doGet(request, response);
//		System.out.println(titre);
	}
	
	//ajouter delete

}
