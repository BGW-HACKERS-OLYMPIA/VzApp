package io.pivotal.quotes.exception;

/**
 * Exception representing that a quote symbol cannot be found.
 * 
 *
 */
public class SymbolNotFoundException extends Exception {

	public SymbolNotFoundException(String message ) {
		super(message);
	}
}
