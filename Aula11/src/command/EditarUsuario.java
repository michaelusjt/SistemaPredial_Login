package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class EditarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("CPF");
		String pRg = request.getParameter("RG");
		String pEndereco = request.getParameter("Endereço");
		String pDataDeNascimento = request.getParameter("Data de nascimento");
		String pNomeEmpresa = request.getParameter("Nome da empresa");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(pNome);
		usuario.setCpf(pCpf);
		usuario.setRG(pRg);
		usuario.setEndereco(pEndereco);
		usuario.setDataDeNascimento(pDataDeNascimento);
		usuario.setpNomeEmpresa(pNomeEmpresa);
		UsuarioService us = new usuarioService();

;
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		usuario = us.carregar(usuario.getId());
		request.setAttribute("usuario", cliente);
		view = request.getRequestDispatcher("AlterarUsuario.jsp");		
		
		view.forward(request, response);

	}

	public int busca(Usuario usuario, ArrayList<Usuario> lista) {
		Usuario to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == usuario.getId()){
				return i;
			}
		}
		return -1;
	}

}
