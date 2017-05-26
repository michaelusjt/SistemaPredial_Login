package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Empresa;
import service.EmpresaService;

public class ExcluirEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pcnpj = request.getParameter("cnpj");                  
    	String prazaoSocial = request.getParameter("razaoSocial");
    	String pconjunto = request.getParameter("conjunto");
    	String phorarioDeFuncionamento = request.getParameter("horarioDeFuncionamento");
    	String ptemperaturaDoArCondicionado = request.getParameter("temperaturaDoArCondicionado");
    	String phorarioDoArCondicionado = request.getParameter("horarioDoArCondicionado");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setCnpj(pcnpj);
		empresa.setRazaoSocial(prazaoSocial);
		empresa.setConjunto(pconjunto);
		empresa.setHorarioDeFuncionamento(phorarioDeFuncionamento);
		empresa.setTemperaturaDoArCondicionado(ptemperaturaDoArCondicionado);
		empresa.setHorarioDoArCondicionado(phorarioDoArCondicionado);
		
		EmpresaService es = new EmpresaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		es.excluir(empresa.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session
				.getAttribute("lista");
		lista.remove(busca(empresa, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarEmpresas.jsp");
		view.forward(request, response);

	}

	public int busca(Empresa empresa, ArrayList<Empresa> lista) {
		Empresa to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == empresa.getId()) {
				return i;
			}
		}
		return -1;
	}

}
