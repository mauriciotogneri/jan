package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.symbols.Operator;
import com.mauriciotogneri.jan.kernel.symbols.Parameter;
import com.mauriciotogneri.jan.kernel.symbols.Primitive;
import com.mauriciotogneri.jan.kernel.symbols.operands.IntOperand;

public class SyntacticAnalyzer
{
	public Program analyze(List<Token> tokens)
	{
		// TODO
		return getExapleProgram();
	}
	
	private Program getExapleProgram()
	{
		Parameter a = new Parameter("a", 0);
		
		Function function = new Function("double");
		function.addParameter(a);
		
		Expression e = new Expression();
		e.add(Primitive.getPrimitive("*"));
		e.add(a);
		e.add(a);
		
		function.addExpression(e);
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("double"));
		entryPoint.add(Primitive.getPrimitive("+"));
		entryPoint.add(new IntOperand(3));
		entryPoint.add(new IntOperand(2));
		
		return new Program(functions, entryPoint);
	}
}