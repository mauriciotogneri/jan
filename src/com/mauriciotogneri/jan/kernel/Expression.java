package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.List;

public class Expression
{
	private final List<Symbol> symbols = new ArrayList<>();
	
	public void add(Symbol symbol)
	{
		this.symbols.add(0, symbol);
	}
	
	public List<Symbol> getSymbol()
	{
		return this.symbols;
	}
}