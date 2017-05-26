package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Usuario;
import model.UsuarioLogin;

public class UsuarioDAO {
	public int criar(Usuario usuario) throws IOException {
		String sqlInsert = "INSERT INTO usuario(nome, cpf, rg, endereco, dataDeNascimento, nomeEmpresa) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getCpf());
				stm.setString(3, usuario.getRg());
				stm.setString(4, usuario.getEndereco());
				stm.setString(5, usuario.getDataDeNascimento());
				stm.setString(6, usuario.getNomeEmpresa());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						usuario.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) throws IOException {
		String sqlUpdate = "UPDATE usuario SET nome=?, cpf=?, rg=?, endereco=?, dataDeNascimento=?, nomeEmpresa=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getCpf());
				stm.setString(3, usuario.getRg());
				stm.setString(4, usuario.getEndereco());
				stm.setString(5, usuario.getDataDeNascimento());
				stm.setString(6, usuario.getNomeEmpresa());
				stm.setInt(7, usuario.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
	}

	public void excluir(int id) throws IOException {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}

	}

	public Usuario carregar(int id) throws IOException {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, cpf, rg, endereco, dataDeNascimento, nomeEmpresa FROM usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, usuario.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						usuario.setNome(rs.getString("nome"));
						usuario.setCpf(rs.getString("cpf"));
						usuario.setRg(rs.getString("rg"));
						usuario.setEndereco(rs.getString("endereco"));
						usuario.setDataDeNascimento(rs.getString("dataDeNascimento"));
						usuario.setNomeEmpresa(rs.getString("nomeEmpresa"));
					} else {
						usuario.setId(-1);
						usuario.setNome(null);
						usuario.setCpf(null);
						usuario.setRg(null);
						usuario.setEndereco(null);
						usuario.setDataDeNascimento(null);
						usuario.setNomeEmpresa(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return usuario;
	}

	public ArrayList<Usuario> listarUsuarios() throws IOException {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, cpf, rg, endereco, dataDeNascimento, nomeEmpresa FROM usuario;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNome(rs.getString("nome"));
						usuario.setCpf(rs.getString("cpf"));
						usuario.setRg(rs.getString("rg"));
						usuario.setEndereco(rs.getString("endereco"));
						usuario.setDataDeNascimento(rs.getString("dataDeNascimento"));
						usuario.setNomeEmpresa(rs.getString("nomeEmpresa"));

						lista.add(usuario);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return lista;
	}

	public ArrayList<Usuario> listarUsuarios(String chave) throws IOException {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, cpf, rg, endereco, dataDeNascimento, nomeEmpresa FROM usuario where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNome(rs.getString("nome"));
						usuario.setCpf(rs.getString("cpf"));
						usuario.setRg(rs.getString("rg"));
						usuario.setEndereco(rs.getString("endereco"));
						usuario.setDataDeNascimento(rs.getString("dataDeNascimento"));
						usuario.setNomeEmpresa(rs.getString("nomeEmpresa"));

						lista.add(usuario);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return lista;
	}

}
