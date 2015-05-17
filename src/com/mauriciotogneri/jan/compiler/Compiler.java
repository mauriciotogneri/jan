package com.mauriciotogneri.jan.compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.LexicalAnalyzer;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticAnalyzer;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticAnalyzer;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.symbols.Operand.Type;
import com.mauriciotogneri.jan.kernel.symbols.Operator;
import com.mauriciotogneri.jan.kernel.symbols.Parameter;
import com.mauriciotogneri.jan.kernel.symbols.Primitive;
import com.mauriciotogneri.jan.kernel.symbols.operands.NumberOperand;

public class Compiler
{
	public Program compile(String sourcePath)
	{
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
		List<Token> tokens = lexicalAnalyzer.analyze(sourcePath);
		
		// for (Token token : tokens)
		// {
		// System.out.println(token);
		// }
		
		SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
		ProgramDefinition program = syntacticAnalyzer.analyze(tokens);
		
		// System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(program).toString());
		
		SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
		Type type = semanticAnalyzer.analyze(program);
		
		System.out.println("TYPE: " + type);
		
		return getSampleProgram();
	}
	
	public Expression getExpression(String line)
	{
		return null;
	}
	
	private Program getFibonacciProgram()
	{
		// fibonacci n
		// ? (= n 0) 0
		// ? (= n 1) 1
		// + (fibonacci -- n) (fibonacci - n 2)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("fibonacci");
		function.addParameter(n);
		
		Expression e1 = new Expression();
		e1.add(Primitive.getPrimitive("?"));
		e1.add(Primitive.getPrimitive("="));
		e1.add(n);
		e1.add(new NumberOperand(0));
		e1.add(new NumberOperand(0));
		function.addExpression(e1);
		
		Expression e2 = new Expression();
		e2.add(Primitive.getPrimitive("?"));
		e2.add(Primitive.getPrimitive("="));
		e2.add(n);
		e2.add(new NumberOperand(1));
		e2.add(new NumberOperand(1));
		function.addExpression(e2);
		
		Expression e3 = new Expression();
		e3.add(Primitive.getPrimitive("+"));
		e3.add(new Operator("fibonacci"));
		e3.add(Primitive.getPrimitive("--"));
		e3.add(n);
		e3.add(new Operator("fibonacci"));
		e3.add(Primitive.getPrimitive("-"));
		e3.add(n);
		e3.add(new NumberOperand(2));
		function.addExpression(e3);
		
		// ---------------------------
		
		Expression anonymousExpression = new Expression();
		anonymousExpression.add(new Operator("fibonacci"));
		anonymousExpression.add(new NumberOperand(12));
		
		Function anonymousFunction = new Function("");
		anonymousFunction.addExpression(anonymousExpression);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		functions.put(anonymousFunction.name, anonymousFunction);
		
		return new Program(functions);
	}
	
	private Program getFactorialProgram()
	{
		// factorial n
		// ? (< n 2) 1
		// * n (factorial -- n)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("factorial");
		function.addParameter(n);
		
		Expression e1 = new Expression();
		e1.add(Primitive.getPrimitive("?"));
		e1.add(Primitive.getPrimitive("<"));
		e1.add(n);
		e1.add(new NumberOperand(2));
		e1.add(new NumberOperand(1));
		function.addExpression(e1);
		
		Expression e2 = new Expression();
		e2.add(Primitive.getPrimitive("*"));
		e2.add(n);
		e2.add(new Operator("factorial"));
		e2.add(Primitive.getPrimitive("--"));
		e2.add(n);
		function.addExpression(e2);
		
		// ---------------------------
		
		Expression anonymousExpression = new Expression();
		anonymousExpression.add(new Operator("factorial"));
		anonymousExpression.add(new NumberOperand(5));
		
		Function anonymousFunction = new Function("");
		anonymousFunction.addExpression(anonymousExpression);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		functions.put(anonymousFunction.name, anonymousFunction);
		
		return new Program(functions);
	}
	
	private Program getSampleProgram()
	{
		// double n
		// * n n
		
		// double + 3 2
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("double");
		function.addParameter(n);
		
		Expression e = new Expression();
		e.add(Primitive.getPrimitive("*"));
		e.add(n);
		e.add(n);
		
		function.addExpression(e);
		
		// ---------------------------
		
		Expression anonymousExpression = new Expression();
		anonymousExpression.add(new Operator("double"));
		anonymousExpression.add(Primitive.getPrimitive("+"));
		anonymousExpression.add(new NumberOperand(3));
		anonymousExpression.add(new NumberOperand(2));
		
		Function anonymousFunction = new Function("");
		anonymousFunction.addExpression(anonymousExpression);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		functions.put(anonymousFunction.name, anonymousFunction);
		
		return new Program(functions);
	}
	
	private Program getEvenProgram()
	{
		// even n
		// = 0 (% n 2)
		
		Parameter n = new Parameter("n", 0);
		
		Function function = new Function("even");
		function.addParameter(n);
		
		Expression e = new Expression();
		e.add(Primitive.getPrimitive("="));
		e.add(new NumberOperand(0));
		e.add(Primitive.getPrimitive("%"));
		e.add(n);
		e.add(new NumberOperand(2));
		
		function.addExpression(e);
		
		// ---------------------------
		
		Expression anonymousExpression = new Expression();
		anonymousExpression.add(new Operator("even"));
		anonymousExpression.add(new NumberOperand(3));
		
		Function anonymousFunction = new Function("");
		anonymousFunction.addExpression(anonymousExpression);
		
		// ---------------------------
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		functions.put(anonymousFunction.name, anonymousFunction);
		
		return new Program(functions);
	}
}