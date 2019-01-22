package com.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimanto;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimanto, Date dataPagamento ) {
		super(id, estado, pedido);
		this.dataVencimanto = dataVencimanto;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimanto() {
		return dataVencimanto;
	}

	public void setDataVencimanto(Date dataVencimanto) {
		this.dataVencimanto = dataVencimanto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
