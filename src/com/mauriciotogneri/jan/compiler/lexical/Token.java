package com.mauriciotogneri.jan.compiler.lexical;

public class Token
{
    public final String lexeme;
    public final Type type;
    public final int line;
    public final int column;

    public enum Type
    {
        // general
        SYMBOL, //
        IMPORT, //
        ANONYMOUS_FUNCTION, //

        // delimiters
        SPACE, //
        TAB, //
        NEW_LINE, //

        // literals
        INTEGER, //
        FLOAT, //
        STRING, //
        BOOLEAN, //

        // arithmetic
        ARITHMETIC_ADD, //
        ARITHMETIC_SUBTRACT, //
        ARITHMETIC_MULTIPLICATION, //
        ARITHMETIC_DIVISION, //
        ARITHMETIC_POWER, //
        ARITHMETIC_MODULE, //
        ARITHMETIC_INCREMENT, //
        ARITHMETIC_DECREMENT, //

        // logic
        LOGIC_EQUAL, //
        LOGIC_NOT_EQUAL, //
        LOGIC_GREATER, //
        LOGIC_GREATER_EQUAL, //
        LOGIC_LESS, //
        LOGIC_LESS_EQUAL, //
        LOGIC_AND, //
        LOGIC_OR, //
        LOGIC_NEGATION, //

        // conditional
        CONDITIONAL_IF, //
        CONDITIONAL_IF_ELSE, //

        // arrays (lists and strings)
        ARRAY_INDEX, //
        ARRAY_REMOVE, //
        ARRAY_LENGTH, //

        // lists
        LIST_OPEN, //
        LIST_CLOSE;

        public boolean isSeparator()
        {
            return (this == SPACE) || (this == TAB);
        }

        public boolean isLiteral()
        {
            return (this == INTEGER) || //
                    (this == FLOAT) || //
                    (this == STRING) || //
                    (this == BOOLEAN);
        }

        private boolean isArithmeticToken()
        {
            return (this == ARITHMETIC_ADD) || //
                    (this == ARITHMETIC_SUBTRACT) || //
                    (this == ARITHMETIC_MULTIPLICATION) || //
                    (this == ARITHMETIC_DIVISION) || //
                    (this == ARITHMETIC_POWER) || //
                    (this == ARITHMETIC_MODULE) || //
                    (this == ARITHMETIC_INCREMENT) || //
                    (this == ARITHMETIC_DECREMENT);
        }

        private boolean isLogicToken()
        {
            return (this == LOGIC_EQUAL) || //
                    (this == LOGIC_NOT_EQUAL) || //
                    (this == LOGIC_GREATER) || //
                    (this == LOGIC_GREATER_EQUAL) || //
                    (this == LOGIC_LESS) || //
                    (this == LOGIC_LESS_EQUAL) || //
                    (this == LOGIC_AND) || //
                    (this == LOGIC_OR) || //
                    (this == LOGIC_NEGATION);
        }

        private boolean isConditionalToken()
        {
            return (this == CONDITIONAL_IF) || //
                    (this == CONDITIONAL_IF_ELSE);
        }

        private boolean isArrayToken()
        {
            return (this == ARRAY_INDEX) || //
                    (this == ARRAY_REMOVE) || //
                    (this == ARRAY_LENGTH);
        }

        private boolean isListToken()
        {
            return (this == LIST_OPEN) || //
                    (this == LIST_CLOSE);
        }

        public boolean isPrimitive()
        {
            return isConditionalToken() || //
                    isArithmeticToken() || //
                    isLogicToken() || //
                    isArrayToken() || //
                    isListToken();
        }

        public boolean isExpressionToken()
        {
            return (this == SYMBOL) || //
                    isConditionalToken() || //
                    isLiteral() || //
                    isArithmeticToken() || //
                    isLogicToken() || //
                    isArrayToken() || //
                    isListToken();
        }
    }

    public Token(String lexeme, Type type, int line, int column)
    {
        this.lexeme = lexeme;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString()
    {
        return lexeme;
    }
}