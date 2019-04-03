package br.senai.sc.sevices.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String msg) {
		super(msg);
	}

}
