Equation Syntax
======================

<ul id="ProjectSubmenu">
    <li><a href="/projects/markdown/" title="Markdown Project Page">Main</a></li>
    <li><a href="/projects/markdown/basics" title="Markdown Basics">Basics</a></li>
    <li><a class="selected" title="Markdown Syntax Documentation">Syntax</a></li>
    <li><a href="/projects/markdown/license" title="Pricing and License Information">License</a></li>
    <li><a href="/projects/markdown/dingus" title="Online Markdown Web Form">Dingus</a></li>
</ul>


The @Arg annotation is used to annotate class instance variables (non-static).  A variable that is annotated in this
way will be made available on the command-line as a run-time argument.  The simplest @Arg annotation is with no
parameters and this provides for a command line argument that is the same as the variable name.  See the [basics] page 
for an example of this.

*   [Overview](#overview)
    *   [Philosophy](#philosophy)
*   [Operators](#operators)
    *   [Numeric](#numericOperators)
        *   [^](#power)
        *   [*](#multiply)
        *   [/](#divide)
        *   [+](#add)
        *   [-](#subtract)
        *   [%](#mod)
        *   [!](#factorial)
    *   [Comparison](#comparisonOperators)
        *   [=](#equal)
        *   [!=](#notEqual)
        *   [>](#greaterThan)
        *   [<=](#notGreaterThan)
        *   [<](#lessThan)
        *   [>=](#notLessThan)
    *   [Assignment](#assignmentOperators)
        *   [:=](#assignment)
    *   [Boolean](#booleanOperators)
        *   [&&](#and)
        *   [||](#or)
        *   [!&](#nand)
        *   [!|](#nor)
        *   [~|](#xor)
        *   [!~|](#xnor)
*   [Functions](#functions)
    *  [Numeric](#numericFunctions)
        *   [abs](#abs)
        *   [acos](#acos)
        *   [acotan](#acotan)
        *   [alpha](#alpha)
        *   [asin](#asin)
        *   [atan](#atan)
        *   [cbrt](#cbrt)
        *   [cos](#cos)
        *   [deg](#deg)
        *   [log10](#log10)
        *   [log](#log)
        *   [max](#max)
        *   [min](#min)
        *   [rad](#rad)
        *   [root](#root)
        *   [round](#round)
        *   [sin](#sin)
        *   [sqrt](#sqrt)
        *   [tan](#tan)
        *   [trunc](#trunc)
        *   [toString](#toString)
    *  [Boolean](#booleanFunctions)
        *   [if](#if)
        *   [not](#not)
    *  [String](#stringFunctions)
        *   [cat](#cat)
        *   [empty](#empty)
        *   [indexof](#indexof)
        *   [isEmpty](#isEmpty)
        *   [lcase](#lcase)
        *   [length](#length)
        *   [ltrim](#ltrim)
        *   [match | matches](#matches)
        *   [metaphone](#metaphone)
        *   [rtrim](#rtrim)
        *   [replace](#replace)
        *   [substr](#substr)
        *   [toHex](#toHex)
        *   [toInt](#toInt)
        *   [toFloat](#toFloat)
        *   [trim](#trim)
        *   [ucase](#ucase)
    *  [Date / Time](#dateTimeFunctions)
        *   [date](#date)
        *   [time](#time)
        *   [dateTime](#dateTime)
        *   [dateFmt](#dateFmt)
        *   [timeFmt](#timeFmt)
        *   [dateTimeFmt](#dateTimeFmt)
    *  [Rate](#rateFunctions)
        *   [bandedRate](#bandedRate)
        *   [rate](#rate)
        *   [tieredRate](#tieredRate)
*   [Constants](#constants)
    *   [PI](#pi)
    *   [E](#e)
    *   [true](#true)
    *   [false](#false)
    *   [today](#today)
    *   [now](#now)

<h2 id="overview">Overview</h2>

<h3 id="philosophy">Philosophy</h3>

<h2 id="operators">Operators</h2>

<h3 id="numericOperators">Numeric Operators</h3>

<h4 id="^">power</h4>
<h4 id="*">multiply</h4>
<h4 id="/">divide</h4>
<h4 id="+">add</h4>
<h4 id="-">subtract</h4>
<h4 id="%">mod</h4>
<h4 id="!">factorial</h4>
        
<h3 id="comparisonOperators">Comparison Operators</h3>

<h4 id="=">equal</h4>
<h4 id="!=">notEqual</h4>
<h4 id=">">greaterThan</h4>
<h4 id="<=">notGreaterThan</h4>
<h4 id="<">lessThan</h4>
<h4 id=">=">notLessThan</h4>

<h3 id="assignmentOperators">Assignment Operators</h3>

<h4 id=":=">assignment</h4>

<h3 id="booleanOperators">Boolean Operators</h3>

<h4 id="&&">and</h4>
<h4 id="||">or</h4>
<h4 id="!&">nand</h4>
<h4 id="!|">nor</h4>
<h4 id="~|">xor</h4>
<h4 id="!~|">xnor</h4>

<h2 id="functions">Functions</h2>

<h3 id="numericFunctions">Numeric Functions</h3>

<h4 id="abs">abs</h4>
<h4 id="acos">acos</h4>
<h4 id="acotan">acotan</h4>
<h4 id="alpha">alpha</h4>
<h4 id="asin">asin</h4>
<h4 id="atan">atan</h4>
<h4 id="cbrt">cbrt</h4>
<h4 id="cos">cos</h4>
<h4 id="deg">deg</h4>
<h4 id="log10">log10</h4>
<h4 id="log">log</h4>
<h4 id="max">max</h4>
<h4 id="min">min</h4>
<h4 id="rad">rad</h4>
<h4 id="root">root</h4>
<h4 id="round">round</h4>
<h4 id="sin">sin</h4>
<h4 id="sqrt">sqrt</h4>
<h4 id="tan">tan</h4>
<h4 id="trunc">trunc</h4>
<h4 id="toString">toString</h4>

<h3 id="booleanFunctions">Boolean Functions</h3>

<h4 id="if">if</h4>
<h4 id="not">not</h4>

<h3 id="stringFunctions">String Functions</h3>

<h4 id="cat">cat</h4>
<h4 id="empty">empty</h4>
<h4 id="indexof">indexof</h4>
<h4 id="isEmpty">isEmpty</h4>
<h4 id="lcase">lcase</h4>
<h4 id="length">length</h4>
<h4 id="ltrim">ltrim</h4>
<h4 id="match | matches">matches</h4>
<h4 id="metaphone">metaphone</h4>
<h4 id="rtrim">rtrim</h4>
<h4 id="replace">replace</h4>
<h4 id="substr">substr</h4>
<h4 id="toHex">toHex</h4>
<h4 id="toInt">toInt</h4>
<h4 id="toFloat">toFloat</h4>
<h4 id="trim">trim</h4>
<h4 id="ucase">ucase</h4>

<h3 id="dateTimeFunctions">Date / Time Functions</h3>

<h4 id="date">date</h4>
<h4 id="time">time</h4>
<h4 id="dateTime">dateTime</h4>
<h4 id="dateFmt">dateFmt</h4>
<h4 id="timeFmt">timeFmt</h4>
<h4 id="dateTimeFmt">dateTimeFmt</h4>

<h3 id="rateFunctions">Rate Functions</h3>

<h4 id="bandedRate">bandedRate</h4>
<h4 id="rate">rate</h4>
<h4 id="tieredRate">tieredRate</h4>

<h2 id="constants">Constants</h2>

<h3 id="PI">pi</h3>
<h3 id="E">e</h3>
<h3 id="true">true</h3>
<h3 id="false">false</h3>
<h3 id="today">today</h3>
<h3 id="now">now</h3>