# Jan

<img align="right" src="http://i.imgur.com/Q4fvRk0.png">

**Jan** is a purely functional programming language. It is named after **Jan Łukasiewicz**, a Polish logician and philosopher creator of the **Polish notation**, also known as **Prefix notation**, which is a form of notation for logic, arithmetic, and algebra. The distinguishing feature of this notation is that it places operators to the left of their operands. Given that the arity of the operators and functions in the language is fixed, the result is a syntax lacking parentheses or other brackets that can still be parsed without ambiguity. Although **Jan** is a general purpose language, it is intended as a language to learn.

## Characteristics

The language has the following characteristics:

* Pure functional
* All functions and operands use prefix notation
* Case sensitive
* There are no reserved words

## Syntax

A program written in **Jan** consists of a set of functions. A function consists of a set of expressions that are evaluated sequentially. An expression is a combination of explicit constants, parameters, operators and functions that are evaluated to return a value (or an empty result).

### Expressions

There are two types of expressions:

* Non-Conditional: these expressions are evaluated and returned as a result.
* Conditional: these expressions evaluate a condition in order to determine if a value is returned or not. There are two types of conditional expressions:

Simple: the condition is evaluated and if it's true, the expression returns a value, otherwise the execution continues to the next expression.

Example:

```common-lisp
? = n 0 "n is zero"
```

The previous expression can be read as: _if n is equal to zero then return the string "n is zero"_

In pseudocode it could be written as:

```pascal
if (n == 0) then
    return "n is zero"
end if
```

Complex: the condition is evaluated and if it's true, the expression returns the result of the consequent value, otherwise it returns the result of the alternative value.

Example:

```common-lisp
?? = n 0 "n is zero" "n is not zero"
```

The previous expression can be read as: _if n is equal to zero then return the string "n is zero", otherwise return "n is not zero"_

In pseudocode it could be written as:

```pascal
if (n == 0) then
    return "n is zero"
else
    return "n is not zero"
end if
```

## Types

Jan has the following data types:

### Numbers

Integers: whole numbers expressed in base 10, for example:

``42     -8     250    0     -67``

Floats: decimal numbers expressed in base 10, for example:

``12.34     -0.001     2.0     99.90     -50.71``

Notice that floats should be expressed like this ``0.123`` instead of ``.123``

## Operators

### Arithmetic