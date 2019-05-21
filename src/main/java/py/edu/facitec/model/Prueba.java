package py.edu.facitec.model;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class Prueba {
	
	
public static void main(String[] args) {
	
	
	Pedido pedido=new Pedido();
	
	
	List<ItemPedido> items=new ArrayList<>();
	ItemPedido item=new ItemPedido();
	item.setPedido(pedido);
	items.add(item);
	
	pedido.setItemPedidos(items);
	
	
	System.out.println(pedido.toString());;
	
	
}

}
