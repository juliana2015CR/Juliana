package orkut.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "COMUNIDADE")
public class Comunidade {
	@Id
	@Column(name = "COM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comid;

	@Column(name = "NOME")
	private String nome;

	// MANY-TO-MANY:
	@ManyToMany
	@JoinTable(name = "USUARIO_COMUNIDADES", joinColumns = @JoinColumn(name = "COM_ID", referencedColumnName = "COM_ID"), inverseJoinColumns = @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")

	)
	private List<Usuario> usuarios;

	/* MANY-TO-ONE */
	@Column(name = "ORK_ID", insertable = false, updatable = false, nullable = false)
	private Long orkId;

	/* many-to-one */
	@ManyToOne(optional = false)
	@JoinColumn(name = "ORK_ID", referencedColumnName = "ORK_ID")
	private OrkutQuixada orkutquixada;

	@Column(name = "CAT_ID", insertable = false, updatable = false, nullable = false)
	private Long catId;

	/* many-to-one */
	@ManyToOne(optional = false)
	@JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID")
	private Categoria categoria;

	@OneToMany(mappedBy = "comunidade", targetEntity = Forum.class, fetch = FetchType.EAGER)
	private Collection<Forum> forum;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Collection<Forum> getForum() {
		return forum;
	}

	public void setForum(Collection<Forum> forum) {
		this.forum = forum;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getNome() {
		return nome;
	}

	public Long getOrkId() {
		return orkId;
	}

	public void setOrkId(Long orkId) {
		this.orkId = orkId;
	}

	public OrkutQuixada getOrkutquixada() {
		return orkutquixada;
	}

	public void setOrkutquixada(OrkutQuixada orkutquixada) {
		this.orkutquixada = orkutquixada;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
