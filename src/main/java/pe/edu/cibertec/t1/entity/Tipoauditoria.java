package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipoauditoria database table.
 * 
 */
@Entity
@Table(name="tb_tipoauditoria")
@NamedQuery(name="Tipoauditoria.findAll", query="SELECT t FROM Tipoauditoria t")
public class Tipoauditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_tipoAuditoria;

	private String desc_tipoAuditoria;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="tbTipoauditoria")
	private List<Certificacion> tbCertificacions;

	public Tipoauditoria() {
	}

	public int getId_tipoAuditoria() {
		return this.id_tipoAuditoria;
	}

	public void setId_tipoAuditoria(int id_tipoAuditoria) {
		this.id_tipoAuditoria = id_tipoAuditoria;
	}

	public String getDesc_tipoAuditoria() {
		return this.desc_tipoAuditoria;
	}

	public void setDesc_tipoAuditoria(String desc_tipoAuditoria) {
		this.desc_tipoAuditoria = desc_tipoAuditoria;
	}

	public List<Certificacion> getTbCertificacions() {
		return this.tbCertificacions;
	}

	public void setTbCertificacions(List<Certificacion> tbCertificacions) {
		this.tbCertificacions = tbCertificacions;
	}

	public Certificacion addTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().add(tbCertificacion);
		tbCertificacion.setTbTipoauditoria(this);

		return tbCertificacion;
	}

	public Certificacion removeTbCertificacion(Certificacion tbCertificacion) {
		getTbCertificacions().remove(tbCertificacion);
		tbCertificacion.setTbTipoauditoria(null);

		return tbCertificacion;
	}

}