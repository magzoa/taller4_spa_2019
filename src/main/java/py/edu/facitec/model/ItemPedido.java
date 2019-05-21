package py.edu.facitec.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ItemPedido extends General {

	private int cantidadProducto;
	private BigDecimal subTotal;
	
	@ManyToOne
	private Producto producto;
	
	//El que no se visualizara en el JSON
	@JsonBackReference(value="item_pedido")
	@ManyToOne
	private Pedido pedido;
	
	public ItemPedido() {
		
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [cantidadProducto=" + cantidadProducto + ", subTotal=" + subTotal + ", producto=" + producto
				+ "]";
	}

	
	
	
	
	
}
