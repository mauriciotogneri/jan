package com.mauriciotogneri.jan.compiler.lexical.states;

import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

import java.util.List;

public class InitialState extends State
{
    public InitialState(List<Token> tokens, int line, int column)
    {
        super(tokens, line, column);
    }

    @Override
    public State process(Character character, int line, int column)
    {
        State state = this;

        if (character.isLetter())
        {
            state = new SymbolState(getTokens(), character, line, column);
        }
        else if (character.isDigit())
        {
            state = new IntegerState(getTokens(), character, line, column);
        }
        else
        {
            switch (character)
            {
                case SPACE:
                case TAB:
                case NEW_LINE:
                case CARRIAGE_RETURN:
                    addCharacter(character);
                    addToken(character.getDelimiterType());
                    break;

                case PLUS:
                    state = new AddState(getTokens(), line, column);
                    break;

                case MINUS:
                    state = new SubtractState(getTokens(), line, column);
                    break;

                case DOUBLE_QUOTES:
                    state = new StringState(getTokens(), line, column);
                    break;

                case EXCLAMATION:
                    state = new NegationState(getTokens(), line, column);
                    break;

                case GREATER:
                    state = new GreaterState(getTokens(), line, column);
                    break;

                case LESS:
                    state = new LessState(getTokens(), line, column);
                    break;

                case QUESTION:
                    state = new IfState(getTokens(), line, column);
                    break;

                case SEMICOLON:
                    state = new CommentState(getTokens(), line, column);
                    break;

                case STAR:
                case SLASH:
                case SHARP:
                case CARET:
                case PERCENT:
                case EQUAL:
                case AMPERSAND:
                case VERTICAL_BAR:
                case DOLLAR:
                case BACK_SLASH:
                case OPEN_BRACKETS:
                case CLOSE_BRACKETS:
                case AT:
                case DOT:
                case COLON:
                case TILDE:

                    // case COMMA:
                    // case APOSTROPHE:
                    // case UNDERSCORE:
                    // case GRAVE_ACCENT:
                    // case OPEN_PARENTHESES:
                    // case CLOSE_PARENTHESES:
                    // case OPEN_BRACES:
                    // case CLOSE_BRACES:

                    state = new OperatorState(getTokens(), character, line, column);
                    break;

                default:
                    throw new LexicalException(character, line, column);
            }
        }

        return state;
    }
}