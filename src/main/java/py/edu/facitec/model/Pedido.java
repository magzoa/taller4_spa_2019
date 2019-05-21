package py.edu.facitec.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Pedido extends General{
	
	private Date fechaToma;
	private Date fechaEntrega;
	private BigDecimal total;
	@ManyToOne
	private Usuario usuario;
	
	
	//Cuando la lista es importante
	//esta lista es que se vera en el JSON
	@JsonManagedReference(value="item_pedido")
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;
	
	
	@ManyToOne
	private Cliente cliente;
	
	
	public Pedido() {
	
	}


	public Date getFechaToma() {
		return fechaToma;
	}


	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}


	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Pedido [fechaToma=" + fechaToma + ", fechaEntrega=" + fechaEntrega + ", total=" + total + ", usuario="
				+ usuario + ", itemPedidos=" + itemPedidos + ", cliente=" + cliente + "]";
	}
	

	
	
	
	
}
