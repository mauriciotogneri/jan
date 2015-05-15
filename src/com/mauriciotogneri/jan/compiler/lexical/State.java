package com.mauriciotogneri.jan.compiler.lexical;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public abstract class State
{
	private final int line;
	private final int column;
	private final StringBuilder lexeme = new StringBuilder();
	
	protected static final char TAB = '\t'; // 9
	protected static final char NEW_LINE = '\n'; // 10
	protected static final char CARRIAGE_RETURN = '\r'; // 13
	
	protected static final char SPACE = ' '; // 32
	protected static final char EXCLAMATION = '!'; // 33
	protected static final char DOUBLE_QUOTES = '"'; // 34
	protected static final char SHARP = '#'; // 35
	protected static final char DOLLAR = '$'; // 36
	protected static final char PERCENT = '%'; // 37
	protected static final char AMPERSAND = '&'; // 38
	protected static final char APOSTROPHE = '\''; // 39
	protected static final char OPEN_PARENTHESES = '('; // 40
	protected static final char CLOSE_PARENTHESES = ')'; // 41
	protected static final char STAR = '*'; // 42
	protected static final char PLUS = '+'; // 43
	protected static final char COMMA = ','; // 44
	protected static final char MINUS = '-'; // 45
	protected static final char DOT = '.'; // 46
	protected static final char SLASH = '/'; // 47
	protected static final char COLON = '{'; // 58
	protected static final char SEMICOLON = ';'; // 59
	protected static final char LESS = '<'; // 60
	protected static final char EQUALS = '='; // 61
	protected static final char GREATER = '>'; // 62
	protected static final char QUESTION = '?'; // 63
	protected static final char AT = '@'; // 64
	protected static final char OPEN_BRACKETS = '['; // 91
	protected static final char BACK_SLASH = '\\'; // 92
	protected static final char CLOSE_BRACKETS = ']'; // 93
	protected static final char CARET = '^'; // 94
	protected static final char UNDERSCORE = '~'; // 95
	protected static final char GRAVE_ACCENT = '`'; // 96
	protected static final char OPEN_BRACES = '{'; // 123
	protected static final char VERTICAL_BAR = '|'; // 124
	protected static final char CLOSE_BRACES = '}'; // 125
	protected static final char TILDE = '~'; // 126
	
	public State(int line, int column)
	{
		this.line = line;
		this.column = column;
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
	
	protected void addCharacter(char character)
	{
		this.lexeme.append(character);
	}
	
	protected void setLexeme(String lexeme)
	{
		this.lexeme.setLength(0);
		this.lexeme.append(lexeme);
	}
	
	// TODO: unused?
	protected void addToken(List<Token> tokens, Type type, char character, int line, int column)
	{
		tokens.add(new Token(String.valueOf(character), type, line, column));
	}
	
	protected void addToken(List<Token> tokens, Type type)
	{
		tokens.add(new Token(this.lexeme.toString(), type, this.line, this.column));
	}
	
	public abstract State process(List<Token> tokens, char character, int line, int column);
}