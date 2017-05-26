package service;

import java.util.List;
import java.io.IOException;

import dao.EmpresaDAO;
import model.Empresa;



public class EmpresaService {

	EmpresaDAO dao = new EmpresaDAO();

	public int criar(Empresa empresa) throws IOException {
		return dao.criar(empresa);
	}

	public void atualizar(Empresa empresa) throws IOException {
		dao.atualizar(empresa);
	}

	public void excluir(int id) throws IOException {
		dao.excluir(id);
	}

	public Empresa carregar(int id) throws IOException {
		return dao.carregar(id);
	}
	
}
