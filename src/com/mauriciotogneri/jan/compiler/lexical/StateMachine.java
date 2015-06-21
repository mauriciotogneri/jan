package com.mauriciotogneri.jan.compiler.lexical;

import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

import java.util.ArrayList;
import java.util.List;

class StateMachine
{
    private int line = 1;
    private int column = 0;

    public List<Token> getTokens(char[] characters)
    {
        List<Token> tokens = new ArrayList<>();
        State state = new InitialState(tokens, line, column);

        for (char chr : characters)
        {
            Character character = Character.get(chr);

            if (character != null)
            {
                if (character == Character.NEW_LINE)
                {
                    line++;
                    column = 0;
                }

                if (character == Character.TAB)
                {
                    column += 3;
                }

                if (!character.isNewLine())
                {
                    column++;
                }

                state = state.process(character, line, column);
            }
            else
            {
                throw new LexicalException(chr, line, column);
            }
        }

        state.process(Character.NEW_LINE, line, column);

        return tokens;
    }
}