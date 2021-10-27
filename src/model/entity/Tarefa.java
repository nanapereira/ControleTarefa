//package model.entity;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity
//@Table(name = "tarefa")
//public class Tarefa {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	@ManyToMany
//	private Colaborador colaborador;
//	private String descricao;
//	private Date dataInicio;
//	private Date dataFim;
//	private String status;
//	private String prioridade;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Colaborador getColaborador() {
//		return colaborador;
//	}
//
//	public void setColaborador(Colaborador colaborador) {
//		this.colaborador = colaborador;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
//	public Date getDataInicio() {
//		return dataInicio;
//	}
//
//	public void setDataInicio(Date dataInicio) {
//		this.dataInicio = dataInicio;
//	}
//
//	public Date getDataFim() {
//		return dataFim;
//	}
//
//	public void setDataFim(Date dataFim) {
//		this.dataFim = dataFim;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getPrioridade() {
//		return prioridade;
//	}
//
//	public void setPrioridade(String prioridade) {
//		this.prioridade = prioridade;
//	}
//}