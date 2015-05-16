package com.mauriciotogneri.jan.compiler.lexical;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

public abstract class State
{
	private final int line;
	private final int column;
	private final StringBuilder lexeme = new StringBuilder();
	private final List<Token> tokens;
	
	public static final char TAB = '\t'; // 9
	public static final char NEW_LINE = '\n'; // 10
	public static final char CARRIAGE_RETURN = '\r'; // 13
	public static final char SPACE = ' '; // 32
	public static final char EXCLAMATION = '!'; // 33
	public static final char DOUBLE_QUOTES = '"'; // 34
	public static final char SHARP = '#'; // 35
	public static final char DOLLAR = '$'; // 36
	public static final char PERCENT = '%'; // 37
	public static final char AMPERSAND = '&'; // 38
	public static final char APOSTROPHE = '\''; // 39
	public static final char OPEN_PARENTHESES = '('; // 40
	public static final char CLOSE_PARENTHESES = ')'; // 41
	public static final char STAR = '*'; // 42
	public static final char PLUS = '+'; // 43
	public static final char COMMA = ','; // 44
	public static final char MINUS = '-'; // 45
	public static final char DOT = '.'; // 46
	public static final char SLASH = '/'; // 47
	public static final char COLON = ':'; // 58
	public static final char SEMICOLON = ';'; // 59
	public static final char LESS = '<'; // 60
	public static final char EQUAL = '='; // 61
	public static final char GREATER = '>'; // 62
	public static final char QUESTION = '?'; // 63
	public static final char AT = '@'; // 64
	public static final char OPEN_BRACKETS = '['; // 91
	public static final char BACK_SLASH = '\\'; // 92
	public static final char CLOSE_BRACKETS = ']'; // 93
	public static final char CARET = '^'; // 94
	public static final char UNDERSCORE = '_'; // 95
	public static final char GRAVE_ACCENT = '`'; // 96
	public static final char OPEN_BRACES = '{'; // 123
	public static final char VERTICAL_BAR = '|'; // 124
	public static final char CLOSE_BRACES = '}'; // 125
	public static final char TILDE = '~'; // 126
	
	public State(List<Token> tokens, int line, int column)
	{
		this.tokens = tokens;
		this.line = line;
		this.column = column;
	}
	
	protected int getLine()
	{
		return this.line;
	}
	
	protected int getColumn()
	{
		return this.column;
	}
	
	protected boolean isNewLine(char character)
	{
		return (character == CARRIAGE_RETURN) || (character == NEW_LINE);
	}
	
	protected boolean isDelimiter(char character)
	{
		return (character == SPACE) || (character == TAB) || (character == CARRIAGE_RETURN) || (character == NEW_LINE);
	}
	
	protected boolean isDigit(char character)
	{
		return (character >= '0') && (character <= '9');
	}
	
	protected boolean isLetter(char character)
	{
		return (((character >= 'a') && (character <= 'z')) || ((character >= 'A') && (character <= 'Z')));
	}
	
	protected Type getDelimiterType(char character)
	{
		if (character == SPACE)
		{
			return Type.SPACE;
		}
		else if (character == TAB)
		{
			return Type.TAB;
		}
		else if (character == NEW_LINE)
		{
			return Type.NEW_LINE;
		}
		else
		{
			return null;
		}
	}
	
	protected Type getOperatorType(char character)
	{
		if (character == STAR)
		{
			return Type.ARITHMETIC_MULTIPLICATION;
		}
		else if (character == SLASH)
		{
			return Type.ARITHMETIC_DIVISION;
		}
		else if (character == CARET)
		{
			return Type.ARITHMETIC_POWER;
		}
		else if (character == PERCENT)
		{
			return Type.ARITHMETIC_MODULE;
		}
		else if (character == EQUAL)
		{
			return Type.LOGIC_EQUAL;
		}
		else if (character == AMPERSAND)
		{
			return Type.LOGIC_AND;
		}
		else if (character == VERTICAL_BAR)
		{
			return Type.LOGIC_OR;
		}
		else if (character == QUESTION)
		{
			return Type.CONDITIONAL_IF;
		}
		else if (character == DOLLAR)
		{
			return Type.ARRAY_INDEX;
		}
		else if (character == OPEN_BRACKETS)
		{
			return Type.ARRAY_OPEN;
		}
		else if (character == CLOSE_BRACKETS)
		{
			return Type.ARRAY_CLOSE;
		}
		else if (character == AT)
		{
			return Type.IMPORT;
		}
		else if ((character == DOT) || (character == COLON))
		{
			return Type.BOOLEAN;
		}
		else
		{
			return null;
		}
	}
	
	protected void addCharacter(char character)
	{
		this.lexeme.append(character);
	}
	
	protected void setLexeme(String lexeme)
	{
		this.lexeme.setLength(0);
		this.lexeme.append(lexeme);
	}
	
	protected String getLexeme()
	{
		return this.lexeme.toString();
	}
	
	protected List<Token> getTokens()
	{
		return this.tokens;
	}
	
	protected void addToken(Type type, char character, int line, int column)
	{
		this.tokens.add(new Token(String.valueOf(character), type, line, column));
	}
	
	protected void addToken(Type type)
	{
		this.tokens.add(new Token(getLexeme(), type, this.line, this.column));
	}
	
	protected State createToken(char character, Type type, int line, int column)
	{
		addToken(type);
		addToken(getDelimiterType(character), character, line, column);
		
		return new InitialState(this.tokens, line, column);
	}
	
	public abstract State process(char character, int line, int column);
}