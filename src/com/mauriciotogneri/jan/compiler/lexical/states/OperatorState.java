package com.mauriciotogneri.jan.compiler.lexical.states;

import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

import java.util.List;

public class OperatorState extends State
{
    public OperatorState(List<Token> tokens, Character character, int line, int column)
    {
        super(tokens, line, column);

        addCharacter(character);
    }

    @Override
    public State process(Character character, int line, int column)
    {
        if (character.isDelimiter())
        {
            Character operatorCharacter = Character.get(getLexeme().charAt(0));

            if (operatorCharacter != null)
            {
                return createToken(character, operatorCharacter.getOperatorType(), line, column);
            }
            else
            {
                throw new LexicalException(character, line, column);
            }
        }
        else
        {
            throw new LexicalException(character, line, column);
        }
    }
}