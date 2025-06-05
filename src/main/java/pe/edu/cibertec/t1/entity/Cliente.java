package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_clientes database table.
 * 
 */
@Entity
@Table(name="tb_clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="correo_empresa")
	private String correoEmpresa;

	@Column(name="nom_empresa")
	private String nomEmpresa;

	private String ruc;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="tbCliente")
	private List<Certificacion> tbCertificacions;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreoEmpresa() {
		return this.correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getNomEmpresa() {
		return this.nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public List<Certificacion> getTbCertificacions() {
		return this.tbCertificacions;
	}

	public void setTbCertificacions(List<Certificacion> tbCertificacions) {
		this.tbCertificacions = tbCertificacions;
	}

	public Certificacion addTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().add(tbCertificacion);
		tbCertificacion.setTbCliente(this);

		return tbCertificacion;
	}

	public Certificacion removeTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().remove(tbCertificacion);
		tbCertificacion.setTbCliente(null);

		return tbCertificacion;
	}

}