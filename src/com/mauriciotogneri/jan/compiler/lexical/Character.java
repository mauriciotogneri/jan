package com.mauriciotogneri.jan.compiler.lexical;

import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public enum Character
{
	TAB('\t'), // 9
	NEW_LINE('\n'), // 10
	CARRIAGE_RETURN('\r'), // 13
	SPACE(' '), // 32
	EXCLAMATION('!'), // 33
	DOUBLE_QUOTES('"'), // 34
	SHARP('#'), // 35
	DOLLAR('$'), // 36
	PERCENT('%'), // 37
	AMPERSAND('&'), // 38
	APOSTROPHE('\''), // 39
	OPEN_PARENTHESES('('), // 40
	CLOSE_PARENTHESES(')'), // 41
	STAR('*'), // 42
	PLUS('+'), // 43
	COMMA(','), // 44
	MINUS('-'), // 45
	DOT('.'), // 46
	SLASH('/'), // 47
	COLON(':'), // 58
	SEMICOLON(';'), // 59
	LESS('<'), // 60
	EQUAL('='), // 61
	GREATER('>'), // 62
	QUESTION('?'), // 63
	AT('@'), // 64
	OPEN_BRACKETS('['), // 91
	BACK_SLASH('\\'), // 92
	CLOSE_BRACKETS(']'), // 93
	CARET('^'), // 94
	UNDERSCORE('_'), // 95
	GRAVE_ACCENT('`'), // 96
	OPEN_BRACES('{'), // 123
	VERTICAL_BAR('|'), // 124
	CLOSE_BRACES('}'), // 125
	TILDE('~'), // 126
	
	NUMBER_0('0'), // 48
	NUMBER_1('1'), // 49
	NUMBER_2('2'), // 50
	NUMBER_3('3'), // 51
	NUMBER_4('4'), // 52
	NUMBER_5('5'), // 53
	NUMBER_6('6'), // 54
	NUMBER_7('7'), // 55
	NUMBER_8('8'), // 56
	NUMBER_9('9'), // 57
	
	A('A'), // 65
	B('B'), // 66
	C('C'), // 67
	D('D'), // 68
	E('E'), // 69
	F('F'), // 70
	G('G'), // 71
	H('H'), // 72
	I('I'), // 73
	J('J'), // 74
	K('K'), // 75
	L('L'), // 76
	M('M'), // 77
	N('N'), // 78
	O('O'), // 79
	P('P'), // 80
	Q('Q'), // 81
	R('R'), // 82
	S('S'), // 83
	T('T'), // 84
	U('U'), // 85
	V('V'), // 86
	W('W'), // 87
	X('X'), // 88
	Y('Y'), // 89
	Z('Z'), // 90
	
	a('a'), // 97
	b('b'), // 98
	c('c'), // 99
	d('d'), // 100
	e('e'), // 101
	f('f'), // 102
	g('g'), // 103
	h('h'), // 104
	i('i'), // 105
	j('j'), // 106
	k('k'), // 107
	l('l'), // 108
	m('m'), // 109
	n('n'), // 110
	o('o'), // 111
	p('p'), // 112
	q('q'), // 113
	r('r'), // 114
	s('s'), // 115
	t('t'), // 116
	u('u'), // 117
	v('v'), // 118
	w('w'), // 119
	x('x'), // 120
	y('y'), // 121
	z('z'); // 122
	
	private final char character;
	
	private Character(char character)
	{
		this.character = character;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.character);
	}
	
	public boolean isNewLine()
	{
		return (this == CARRIAGE_RETURN) || (this == NEW_LINE);
	}
	
	public boolean isDelimiter()
	{
		return (this == SPACE) || (this == TAB) || (this == CARRIAGE_RETURN) || (this == NEW_LINE);
	}
	
	public boolean isDigit()
	{
		return (this == NUMBER_0) || //
			(this == NUMBER_1) || //
			(this == NUMBER_2) || //
			(this == NUMBER_3) || //
			(this == NUMBER_4) || //
			(this == NUMBER_5) || //
			(this == NUMBER_6) || //
			(this == NUMBER_7) || //
			(this == NUMBER_8) || //
			(this == NUMBER_9);
	}
	
	public boolean isLetter()
	{
		return isLowercaseLetter() || isUppercaseLetter();
	}
	
	public boolean isUppercaseLetter()
	{
		return (this == A) || //
			(this == B) || //
			(this == C) || //
			(this == D) || //
			(this == E) || //
			(this == F) || //
			(this == G) || //
			(this == H) || //
			(this == I) || //
			(this == J) || //
			(this == K) || //
			(this == L) || //
			(this == M) || //
			(this == N) || //
			(this == O) || //
			(this == P) || //
			(this == Q) || //
			(this == R) || //
			(this == S) || //
			(this == T) || //
			(this == U) || //
			(this == V) || //
			(this == W) || //
			(this == X) || //
			(this == Y) || //
			(this == Z);
	}
	
	public boolean isLowercaseLetter()
	{
		return (this == a) || //
			(this == b) || //
			(this == c) || //
			(this == d) || //
			(this == e) || //
			(this == f) || //
			(this == g) || //
			(this == h) || //
			(this == i) || //
			(this == j) || //
			(this == k) || //
			(this == l) || //
			(this == m) || //
			(this == n) || //
			(this == o) || //
			(this == p) || //
			(this == q) || //
			(this == r) || //
			(this == s) || //
			(this == t) || //
			(this == u) || //
			(this == v) || //
			(this == w) || //
			(this == x) || //
			(this == y) || //
			(this == z);
	}
	
	public Type getDelimiterType()
	{
		if (this == SPACE)
		{
			return Type.SPACE;
		}
		else if (this == TAB)
		{
			return Type.TAB;
		}
		else if (this == NEW_LINE)
		{
			return Type.NEW_LINE;
		}
		else
		{
			return null;
		}
	}
	
	public Type getOperatorType()
	{
		if (this == STAR)
		{
			return Type.ARITHMETIC_MULTIPLICATION;
		}
		else if (this == SLASH)
		{
			return Type.ARITHMETIC_DIVISION;
		}
		else if (this == CARET)
		{
			return Type.ARITHMETIC_POWER;
		}
		else if (this == PERCENT)
		{
			return Type.ARITHMETIC_MODULE;
		}
		else if (this == EQUAL)
		{
			return Type.LOGIC_EQUAL;
		}
		else if (this == AMPERSAND)
		{
			return Type.LOGIC_AND;
		}
		else if (this == VERTICAL_BAR)
		{
			return Type.LOGIC_OR;
		}
		else if (this == DOLLAR)
		{
			return Type.IMPORT;
		}
		else if (this == AT)
		{
			return Type.LIST_INDEX;
		}
		else if (this == SHARP)
		{
			return Type.LIST_LENGTH;
		}
		else if (this == OPEN_BRACKETS)
		{
			return Type.LIST_OPEN;
		}
		else if (this == CLOSE_BRACKETS)
		{
			return Type.LIST_CLOSE;
		}
		else if ((this == DOT) || (this == COLON))
		{
			return Type.BOOLEAN;
		}
		else if (this == BACK_SLASH)
		{
			return Type.ANONYMOUS_FUNCTION;
		}
		else
		{
			return null;
		}
	}
	
	public String getCharacter()
	{
		if (this == TAB)
		{
			return "\\t";
		}
		else if (this == CARRIAGE_RETURN)
		{
			return "\\r";
		}
		else if (this == NEW_LINE)
		{
			return "\\n";
		}
		else
		{
			return toString();
		}
	}
	
	public static Character get(char chr)
	{
		Character[] characters = Character.values();
		
		for (Character character : characters)
		{
			if (character.character == chr)
			{
				return character;
			}
		}
		
		return null;
	}
}