package model;
import java.io.Serializable;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String cnpj;
	private String razaoSocial;
	private String conjunto;
	private String horarioDeFuncionamento;
	private String temperaturaDoArCondicionado;
	private String horarioDoArCondicionado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getConjunto() {
		return conjunto;
	}

	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	public String getHorarioDeFuncionamento() {
		return horarioDeFuncionamento;
	}

	public void setHorarioDeFuncionamento(String horarioDeFuncionamento) {
		this.horarioDeFuncionamento = horarioDeFuncionamento;
	}

	public String getTemperaturaDoArCondicionado() {
		return temperaturaDoArCondicionado;
	}

	public void setTemperaturaDoArCondicionado(String temperaturaDoArCondicionado) {
		this.temperaturaDoArCondicionado = temperaturaDoArCondicionado;
	}

	public String getHorarioDoArCondicionado() {
		return horarioDoArCondicionado;
	}

	public void setHorarioDoArCondicionado(String horarioDoArCondicionado) {
		this.horarioDoArCondicionado = horarioDoArCondicionado;

	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", CNPJ=" + cnpj + ", razão Social=" + razaoSocial + ", conjunto=" + conjunto
				+ ", horario de Funcionamento=" + horarioDeFuncionamento + ", temperatura do Ar condicionado="
				+ temperaturaDoArCondicionado + ", horario Do Ar Condicionado=" + horarioDoArCondicionado + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		if (horarioDeFuncionamento == null) {
			if (other.horarioDeFuncionamento != null)
				return false;
		} else if (!horarioDeFuncionamento.equals(other.horarioDeFuncionamento))
			return false;
		if (id != other.id)
			return false;
		if (temperaturaDoArCondicionado == null) {
			if (other.temperaturaDoArCondicionado != null)
				return false;
		} else if (!temperaturaDoArCondicionado.equals(other.temperaturaDoArCondicionado))
			return false;
		if (horarioDoArCondicionado == null) {
			if (other.horarioDoArCondicionado != null)
				return false;
		} else if (!horarioDoArCondicionado.equals(other.horarioDoArCondicionado))
			return false;
		return true;
	}

}


