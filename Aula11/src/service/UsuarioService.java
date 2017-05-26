package service;

import java.io.IOException;
import java.util.List;

import dao.UsuarioDAO;
import model.Empresa;
import model.Usuario;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();

	public int criar(Usuario usuario) throws IOException {
		return dao.criar(usuario);
	}

	public void atualizar(Usuario usuario) throws IOException {
		dao.atualizar(usuario);
	}

	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}

	public Usuario carregar(int id) throws IOException {
		return dao.carregar(id);
	}

}
