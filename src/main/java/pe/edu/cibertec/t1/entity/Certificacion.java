package pe.edu.cibertec.t1.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_certificacion database table.
 * 
 */
@Entity
@Table(name="tb_certificacion")
@NamedQuery(name="Certificacion.findAll", query="SELECT c FROM Certificacion c")
public class Certificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_certificacion")
	private int idCertificacion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_emision")
	private Date fecEmision;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_vencimiento")
	private Date fecVencimiento;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente tbCliente;

	//bi-directional many-to-one association to Especialista
	@ManyToOne
	@JoinColumn(name="id_especialista")
	private Especialista tbEspecialista;

	//bi-directional many-to-one association to Tipoauditoria
	@ManyToOne
	@JoinColumn(name="id_tipoAuditoria")
	private Tipoauditoria tbTipoauditoria;

	public Certificacion() {
	}

	public int getIdCertificacion() {
		return this.idCertificacion;
	}

	public void setIdCertificacion(int idCertificacion) {
		this.idCertificacion = idCertificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecEmision() {
		return this.fecEmision;
	}

	public void setFecEmision(Date fecEmision) {
		this.fecEmision = fecEmision;
	}

	public Date getFecVencimiento() {
		return this.fecVencimiento;
	}

	public void setFecVencimiento(Date fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}

	public Cliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(Cliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public Especialista getTbEspecialista() {
		return this.tbEspecialista;
	}

	public void setTbEspecialista(Especialista tbEspecialista) {
		this.tbEspecialista = tbEspecialista;
	}

	public Tipoauditoria getTbTipoauditoria() {
		return this.tbTipoauditoria;
	}

	public void setTbTipoauditoria(Tipoauditoria tbTipoauditoria) {
		this.tbTipoauditoria = tbTipoauditoria;
	}

}