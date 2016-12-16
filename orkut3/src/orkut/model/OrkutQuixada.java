package orkut.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "ORKUT_QUIXADA")
public class OrkutQuixada {
	@Id
	@Column(name = "ORK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orkid;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@OneToMany(mappedBy = "orkutquixada", targetEntity = Comunidade.class, fetch = FetchType.EAGER)
	private Collection<Comunidade> comunidades;

	@OneToMany(mappedBy = "orkutquixada", targetEntity = Usuario.class, fetch = FetchType.EAGER)
	private Collection<Usuario> usuarios;

	public Long getOrkid() {
		return orkid;
	}

	public void setOrkid(Long orkid) {
		this.orkid = orkid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Comunidade> getComunidade() {
		return comunidades;
	}

	public void setComunidade(Collection<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public Collection<Usuario> getUsuario() {
		return usuarios;
	}

	public void setUsuario(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
