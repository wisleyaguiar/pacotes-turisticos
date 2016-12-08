package br.com.aguiarweb.pacotesturisticos.servico.excecoes;

public class ServicoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public ServicoException(String msg, Integer codigo) {
		super(msg);
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
}