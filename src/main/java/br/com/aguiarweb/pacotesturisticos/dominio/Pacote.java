package br.com.aguiarweb.pacotesturisticos.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_pacote")
public class Pacote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPacote;
	private String nome;
	private Integer diarias;
	
	@ManyToOne
	@JoinColumn(name="hotel")
	@JsonIgnore
	private Hotel hotel;
	
	@OneToMany(mappedBy="pacote")
	@JsonIgnore
	private List<Contrato> contratos;
	
	@OneToMany(mappedBy="pacote")
	@JsonIgnore
	private List<Item> itens;
	
	public Pacote()
	{
		contratos = new ArrayList<>();
		itens = new ArrayList<>();
	}

	public Pacote(Integer codPacote, String nome, Integer diarias, Hotel hotel) {
		super();
		this.codPacote = codPacote;
		this.nome = nome;
		this.diarias = diarias;
		this.hotel = hotel;
		contratos = new ArrayList<>();
		itens = new ArrayList<>();
	}

	public Integer getCodPacote() {
		return codPacote;
	}

	public void setCodPacote(Integer codPacote) {
		this.codPacote = codPacote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDiarias() {
		return diarias;
	}

	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addContratos(Contrato x){
		this.contratos.add(x);
		x.setPacote(this);
	}
	
	public void removeContratos(Contrato x){
		this.contratos.remove(x);
	}
	
	public void addItens(Item x){
		this.itens.add(x);
		x.setPacote(this);
	}
	
	public void removeItens(Item x){
		this.itens.remove(x);
	}

	@Override
	public String toString() {
		return "Pacote [codPacote=" + codPacote + ", nome=" + nome + ", diarias=" + diarias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPacote == null) ? 0 : codPacote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		if (codPacote == null) {
			if (other.codPacote != null)
				return false;
		} else if (!codPacote.equals(other.codPacote))
			return false;
		return true;
	}
	
	public BigDecimal precoTotal(){
		BigDecimal total = new BigDecimal("0.00");
		for(Item i : itens){
			total = total.add(i.getPasseio().getPreco());
		}
		BigDecimal totalDiarias = hotel.getDiaria().multiply(new BigDecimal(this.getDiarias()));
		total = total.add(totalDiarias);
		return total;
	}
	
	public BigDecimal precoPasseios(){
		BigDecimal soma = new BigDecimal("0.00");
		for(Item i : itens){
			soma = soma.add(i.getPasseio().getPreco());
		}
		return soma;
	}
	
}
