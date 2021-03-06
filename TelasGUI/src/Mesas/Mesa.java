package Mesas;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import parteFuncionario.FunCAD;
import partePedidos.pedCAD;

public class Mesa implements Comparable<Mesa> {
     private IntegerProperty numeroPessoas;
     private IntegerProperty numeroDaMesa;
     private BooleanProperty disponivel;
     private StringProperty nomeMesa;
     private StringProperty nomeReserva;
     private IntegerProperty numeroReservas;
     private String dis;
     private ArrayList<pedCAD> pedidos;
     private double preco;
     private double precoMesa;
     
    
     public double getPrecoMesa() {
		return preco(pedidos);
	}


	public void setPrecoMesa(double precoMesa) {
		this.precoMesa = precoMesa;
	}


	public double getPreco() {
		return preco(this.pedidos);
	}


	public void setPreco(double preco) {
		this.preco = preco;
		
	}

   public void resetarMesa() {
	   this.pedidos.clear();
   }
	public String getNomeReserva() {
    	return nomeReserva.get();
	}
	
	public double preco(ArrayList<pedCAD> p) {
		double preco = 0;
		for(int i = 0;i <p.size();i++) {
			preco = preco + p.get(i).getValor() * p.get(i).getQuantidade();
		}
		return preco;
	}


	public void setNomeReserva(String nomeReserva) {
		this.nomeReserva.set(nomeReserva);
	}


	public Mesa(int numeroPessoas,int numeroDaMesa) {
    	this.numeroDaMesa = new SimpleIntegerProperty(numeroDaMesa);
    	this.numeroPessoas = new SimpleIntegerProperty(numeroPessoas);
    	this.disponivel = new SimpleBooleanProperty(true);
    	this.nomeMesa = new SimpleStringProperty("Mesa");
    	this.nomeReserva = new SimpleStringProperty("");
    	this.numeroReservas  = new SimpleIntegerProperty();
    	
    	this.pedidos = new ArrayList<pedCAD>();
    }
    
 
	/*public String getNomeMesa() {
		return nomeMesa;
	}


	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa = nomeMesa;
	}


	public boolean getDisponivel() {
	return disponivel;
}

    public void setDisponivel(boolean disponivel) {
	  this.disponivel = disponivel;
     }

	public int getNumeroPessoas() {
		return numeroPessoas;
	}
	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas = numeroPessoas;
	}
	public int getNumeroDaMesa() {
		return numeroDaMesa;
	}
	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
	}*/
	
	public void cadastrarPedido(pedCAD p) {
		boolean pedidoExiste = false;
		for(pedCAD d : pedidos) {
			if (d.getNome() == p.getNome()) {
				pedidoExiste = true;
				d.setQuantidade(d.getQuantidade()+p.getQuantidade());
			}
		}
		if(!pedidoExiste) {
			pedidos.add(p);
		}	
	}
	public void removerPedido(int p) {
		if(pedidos.size() == 1) {
			pedidos.clear();
		}else {
			pedidos.remove(p);
			}
		
		
	}
	public ArrayList<pedCAD> getPedidos() {
		
			return pedidos;
		
	}


	public void setPedidos(ArrayList<pedCAD> pedidos) {
		this.pedidos = pedidos;
	}


	public int getNumeroReservas() {
		return numeroReservas.get();
	}


	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas.set(numeroReservas);;
	}


	public String toString() {
    	return String.format("Mesa "+getNumeroDaMesa()+" cabe  "+getNumeroPessoas()+ " pessoas.");
    }


	@Override
	public int compareTo(Mesa outra) {
		
		return (this.getNumeroPessoas() - outra.getNumeroPessoas());
	}


	public int getNumeroPessoas() {
		return numeroPessoas.get();
	}


	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas.set(numeroPessoas);
	}


	public int getNumeroDaMesa() {
		return numeroDaMesa.get();
	}


	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa.set(numeroDaMesa);;
	}


	public boolean getDisponivel() {
		return disponivel.get();
	}


	public void setDisponivel(boolean disponivel) {
		this.disponivel.set(disponivel);;
	}


	public String getNomeMesa() {
		return nomeMesa.get();
	}


	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa.set(nomeMesa);;
	}

	
	public String getDis() {
		return disp(getDisponivel());
	}


	public void setDis(String dis) {
		this.dis = dis;
	}


	public String disp(Boolean b) {
		if (b) return "Disponivel";
		else return "Indisponível";
	}

	
}
