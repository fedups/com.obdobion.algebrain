package com.obdobion.algebrain;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.codec.language.Metaphone;

/**
 * This is the main class for algebRain. Create an instance of this class and
 * send it an evaluate() message. The result is either a Double or a String
 * depending on the final function that was executed - almost always it will be
 * a double.
 * <p>
 * You can also register your own functions and operators by calling the static
 * methods registerFunction and registerOperator. These add to a static Map so
 * there are then available for the duration of your application.
 * <p>
 * A support instance can be handed to an instance of Equ with the setSupport()
 * method. This must be done prior to calling evaluate. When a variable is found
 * in the equation (i.e.: not a known function, like x or myvar) then the
 * support instance is asked to instantiate the variable. It is expected that it
 * will do what is necessary to come up with it. The test cases show a support
 * instance that maintains a local Map of variable name / value pairs. But a
 * database could be used as well, for instance.
 *
 * @author Chris DeGreef
 */
public class Equ
{
    private static Equ instance;

    static public Set<String> gatherVariables (final Collection<EquPart> tokens)
    {
        final Set<String> vars = new HashSet<>();
        for (final EquPart token : tokens)
        {
            if (token instanceof TokVariable)
            {
                vars.add(((TokVariable) token).getValue().toString());
            }
        }
        return vars;
    }

    public static Equ getInstance ()
    {
        return getInstance(false);
    }

    public static Equ getInstance (final boolean fresh)
    {
        if (instance == null || fresh)
        {
            final Equ newInstance = new Equ();
            try
            {
                newInstance.initialize();
            } catch (final Exception e)
            {
                e.printStackTrace();
            }
            instance = newInstance;
        }
        return instance;
    }

    private Map<String, Constructor<?>> functionMap;

    private Map<String, Constructor<?>> operatorMap;
    private java.sql.Date               baseDate;
    private EquationSupport             support;
    private String                      equ;

    private Collection<EquPart>         rpn;
    List<String>                        variablesThatExistedBeforePreviousEvaluation;

    private Metaphone                   cachedMetaphone;

    protected Equ()
    {
        super();
    }

    public Set<String> compile (final String _equ) throws Exception
    {
        this.equ = _equ;
        Collection<EquPart> tokens = tokenize();
        tokens = multiplize(tokens);
        countParameters(tokens);
        rpn = rpnize(tokens);

        return gatherVariables(tokens);
    }

    void countParameters (final Collection<EquPart> oldTokens)
    {
        final EquPart[] equParts = oldTokens.toArray(new EquPart[0]);
        /*
         * ... func(p1, p2 ... ,pN) ... find out what N is
         */
        for (int f = 0; f < equParts.length; f++)
            if (equParts[f] instanceof Function)
                ((Function) equParts[f]).updateParameterCount(equParts, f);
    }

    public Object evaluate () throws Exception
    {
        final ValueStack values = new ValueStack();

        if (rpn == null)
            return null;

        if (variablesThatExistedBeforePreviousEvaluation != null)
            for (final String varName : getSupport().getVariableNames())
            {
                if (variablesThatExistedBeforePreviousEvaluation.contains(varName))
                    continue;
                getSupport().removeVariable(varName);
            }
        /*
         * Save variable names that exist before the equation. If the equation
         * assigns values to variables then they will be new names.
         */
        variablesThatExistedBeforePreviousEvaluation = getSupport().getVariableNames();

        for (final Iterator<EquPart> parts = rpn.iterator(); parts.hasNext();)
        {
            final EquPart part = parts.next();
            part.setEqu(this);
            part.resolve(values);
        }

        final Object result = values.firstElement();
        values.clear();

        return result;
    }

    public Object evaluate (final String _equ) throws Exception
    {
        compile(_equ);
        return evaluate();
    }

    Function function (final TokVariable varTok) throws Exception
    {
        final String token = varTok.getValue().toString();
        final Constructor<?> constructor = functionMap.get(token.toLowerCase());
        if (constructor == null)
            return null;
        try
        {
            return (Function) constructor.newInstance(new Object[]
            {
                varTok
            });
        } catch (final Exception e)
        {
            throw new Exception("function construction", e);
        }
    }

    java.sql.Date getBaseDate ()
    {
        return baseDate;
    }

    public Metaphone getMetaphone ()
    {
        if (cachedMetaphone == null)
            cachedMetaphone = new Metaphone();
        return cachedMetaphone;
    }

    public EquationSupport getSupport ()
    {
        if (support == null)
        {
            setSupport(new DefaultEquationSupport());
            initializeSupport();
        }
        return support;
    }

    protected void initialize () throws Exception
    {
        functionMap = new Hashtable<>();
        registerFunction("if", FuncIf.class);
        registerFunction("rate", FuncFlatRate.class);
        registerFunction("bandedrate", FuncBandedRate.class);
        registerFunction("tieredrate", FuncTieredRate.class);
        registerFunction("round", FuncRound.class);
        registerFunction("alpha", FuncAlpha.class);
        registerFunction("max", FuncMax.class);
        registerFunction("min", FuncMin.class);
        registerFunction("sin", FuncSin.class);
        registerFunction("tan", FuncTan.class);
        registerFunction("abs", FuncAbs.class);
        registerFunction("acos", FuncAcos.class);
        registerFunction("acotan", FuncAcotan.class);
        registerFunction("asin", FuncAsin.class);
        registerFunction("atan", FuncAtan.class);
        registerFunction("cos", FuncCos.class);
        registerFunction("deg", FuncRadsToDegrees.class);
        registerFunction("rad", FuncDegreesToRads.class);
        registerFunction("root", FuncRoot.class);
        registerFunction("sqrt", FuncSqrt.class);
        registerFunction("cbrt", FuncCubeRoot.class);
        registerFunction("log", FuncLog.class);
        registerFunction("log10", FuncLog10.class);
        registerFunction("trunc", FuncTrunc.class);
        registerFunction("not", FuncNot.class);
        registerFunction("match", FuncStringMatch.class);
        registerFunction("matches", FuncStringMatch.class);
        registerFunction("empty", FuncStringEmpty.class);
        registerFunction("isempty", FuncStringEmpty.class);
        registerFunction("cat", FuncStringCat.class);
        registerFunction("length", FuncStringLength.class);
        registerFunction("substr", FuncStringSubstr.class);
        registerFunction("rtrim", FuncStringRTrim.class);
        registerFunction("ltrim", FuncStringLTrim.class);
        registerFunction("trim", FuncStringTrim.class);
        registerFunction("indexOf", FuncStringIndexOf.class);
        registerFunction("date", FuncDate.class);
        registerFunction("toString", FuncToString.class);
        registerFunction("ucase", FuncStringUpCase.class);
        registerFunction("lcase", FuncStringLowerCase.class);
        registerFunction("metaphone", FuncStringMetaphone.class);

        operatorMap = new Hashtable<>();
        registerOperator("^", OpPower.class);
        registerOperator(",", OpComma.class);
        registerOperator(";", OpChain.class);
        registerOperator("*", OpMultiply.class);
        registerOperator("/", OpDivide.class);
        registerOperator("+", OpAdd.class);
        registerOperator("-", OpSubtract.class);
        registerOperator("(", OpLeftParen.class);
        registerOperator(")", OpRightParen.class);
        registerOperator("=", OpCompareEqual.class);
        registerOperator("!=", OpCompareNotEqual.class);
        registerOperator(">", OpCompareGreater.class);
        registerOperator("<=", OpCompareNotGreater.class);
        registerOperator("<", OpCompareLess.class);
        registerOperator(">=", OpCompareNotLess.class);
        registerOperator(":=", OpAssignment.class);
        registerOperator("&&", OpAnd.class);
        registerOperator("!&", OpNand.class);
        registerOperator("||", OpOr.class);
        registerOperator("%", OpMod.class);
        registerOperator("!", OpFactorial.class);
    }

    protected void initializeSupport ()
    {
        try
        {
            getSupport().assignVariable("PI", Math.PI);
            getSupport().assignVariable("E", Math.E);
            getSupport().assignVariable("true", new Boolean(true));
            getSupport().assignVariable("false", new Boolean(false));

        } catch (final Exception e)
        {
            /*
             * There is no reason to expect an error here even though one can
             * possibly be thrown.
             */
            e.printStackTrace();
        }
    }

    /**
     * put implied multipliers into the equation
     */
    protected Collection<EquPart> multiplize (final Collection<EquPart> oldTokens)
    {
        final EquPart[] equParts = oldTokens.toArray(new EquPart[0]);
        final EquPart[] fixed = new EquPart[equParts.length * 2];
        /*
         * )(, operand (, operand operand, operand function, ) operand, )
         * function
         */
        fixed[0] = equParts[0];

        EquPart m;
        int left = 0;

        for (int right = 1; right < equParts.length; right++)
        {
            if (fixed[left].multiplize(equParts[right]))
            {
                m = new OpMultiply(fixed[left]);
                left++;
                fixed[left] = m;
            }

            left++;
            fixed[left] = equParts[right];
        }

        final Collection<EquPart> tokens = new ArrayList<>();

        for (int i = 0; i < fixed.length; i++)
            if (fixed[i] != null)
                tokens.add(fixed[i]);

        return tokens;
    }

    Operator operator (final Token tok) throws Exception
    {
        final String token = tok.getValue().toString();
        final Constructor<?> constructor = operatorMap.get(token);
        if (constructor == null)
            return null;
        try
        {
            return (Operator) constructor.newInstance(new Object[]
            {
                tok
            });
        } catch (final Exception e)
        {
            throw new Exception("operator construction", e);
        }
    }

    public void registerFunction (final String name, final Class<?> functionSubclass) throws Exception
    {
        final String token = name.toLowerCase();
        if (functionMap.containsKey(name))
            throw new Exception("duplicate function: " + token);
        try
        {
            functionMap.put(token, functionSubclass.getConstructor(new Class<?>[]
            {
                TokVariable.class
            }));
        } catch (final Exception e)
        {
            throw new Exception("register function: " + token, e);
        }
    }

    public void registerOperator (final String name, final Class<?> operatorSubclass) throws Exception
    {
        final String token = name.toLowerCase();
        if (operatorMap.containsKey(name))
            throw new Exception("duplicate operator: " + token);
        try
        {
            operatorMap.put(token, operatorSubclass.getConstructor(new Class<?>[]
            {
                EquPart.class
            }));
        } catch (final Exception e)
        {
            throw new Exception("register operator: " + token, e);
        }
    }

    /**
     * Create a reverse Polish notation form of the equation
     */
    protected Collection<EquPart> rpnize (final Collection<EquPart> oldTokens)
    {
        final Collection<EquPart> _rpn = new Stack<>();
        final Stack<EquPart> ops = new Stack<>();
        Operation leftOp;
        Operation rightOp;

        for (final EquPart token : oldTokens)
        {

            if (token instanceof Token)
                _rpn.add(token);
            else
            {
                rightOp = (Operation) token;

                if (ops.empty())
                {

                    if (rightOp.includeInRpn())
                        ops.push(rightOp);
                } else
                {
                    leftOp = (Operation) ops.peek();

                    if (leftOp.preceeds(rightOp))
                    {
                        _rpn.add(ops.pop());

                        /*
                         * while knocking one off scan back as long as the level
                         * doesn't change. A left paren causes the level to
                         * increase and the left paren has that new level. A
                         * right paren causes the level to decrease and has this
                         * new lesser level. So the right paren is one level
                         * less than the operators within the parens. Since we
                         * want to only scan those operators we have to adjust
                         * for the level that they are.
                         */
                        int level = rightOp.getLevel();
                        if (rightOp instanceof OpRightParen)
                            level = level + 1;

                        Operation compareOp = rightOp;
                        while (!ops.empty())
                        {
                            leftOp = (Operation) ops.peek();
                            if (leftOp.getLevel() < level)
                                break;
                            if (leftOp.preceeds(compareOp))
                            {
                                _rpn.add(ops.pop());
                                compareOp = leftOp;
                            } else
                                break;
                            break;
                        }
                    }

                    if (rightOp.includeInRpn())
                        ops.push(rightOp);
                }
            }
        }

        while (!ops.empty())
            _rpn.add(ops.pop());

        return _rpn;
    }

    public void setBaseDate (final java.sql.Date newBaseDate)
    {
        baseDate = newBaseDate;
    }

    public void setSupport (final EquationSupport newSupport)
    {
        support = newSupport;
    }

    public String showRPN () throws Exception
    {
        final StringBuilder sb = new StringBuilder();
        showRPN(sb);
        return sb.toString();
    }

    public void showRPN (final StringBuilder sb) throws Exception
    {
        for (final EquPart part : rpn)
        {
            sb.append(part.toString());
            sb.append("\n");
        }
    }

    protected Collection<EquPart> tokenize () throws Exception
    {
        /*
         * break apart obvious tokens, realizing that some may need further
         * breakage and some may need to be merged back again
         */
        final Collection<EquPart> tokens = new ArrayList<>();
        Token token = null;
        char c;
        int level = 0;

        for (int a = 0; a < equ.length(); a++)
        {
            c = equ.charAt(a);
            final boolean isWhitespace = Character.isWhitespace(c);

            if (isWhitespace)
                if (!(token != null && token instanceof TokLiteral && token.accepts(c)))
                {
                    /*
                     * spaces are allowed inside of literals
                     */
                    if (token != null)
                    {
                        token.addTo(tokens);
                    }
                    token = null;
                    continue;
                }

            if (c == '(')
                level++;

            if (c == ')')
                level--;

            if (token != null && token.accepts(c))
            {
                token.put(c);
            } else
            {

                if (token != null)
                    token.addTo(tokens);

                token = Token.instanceFor(c);
                token.setLevel(level);
                token.put(c);
            }
        }

        if (token != null)
            token.addTo(tokens);

        return tokens;
    }

    @Override
    public String toString ()
    {
        return equ;
    }

    public void unregisterFunction (final String name) throws Exception
    {
        final String token = name.toLowerCase();
        if (!functionMap.containsKey(token))
            throw new Exception("unknown function: " + token);
        functionMap.remove(token);
    }

    public void unregisterOperator (final String name) throws Exception
    {
        final String token = name.toLowerCase();
        if (!operatorMap.containsKey(token))
            throw new Exception("unknown operator: " + token);
        operatorMap.remove(token);
    }
}
