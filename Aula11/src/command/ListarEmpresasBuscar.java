package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Empresa;
import service.SindicoService;

public class ListarEmpresasBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		SindicoService vendedor = new SindicoService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = vendedor.listarEmpresas(chave);
		} else {
			lista = vendedor.listarEmpresas(chave);   //----------------------------------------------------------------------
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEmpresas.jsp");
		dispatcher.forward(request, response);
	}
}
