# com.obdobion.algebrain

Seriously, take a look at the [Wiki](https://github.com/fedups/com.obdobion.algebrain/wiki).

## Where can you get Algebrain?

Algebrain has been developed as a Maven application and can be incorporated into your application by adding a dependency to your POM.xml file.  See the "Maven Central" link below to get the dependency information for the specific release you are interested.

Algebrain is a JAR file and can be included in any non-Maven project by downloading just that artifact and putting it in your classpath.

## Where do you start?

Once you have the jar file associated with your application you can access the `Equ` class found in the Algebrain jar.  I might just refer you to the [JavaDocs](http://fedups.github.io/com.obdobion.algebrain/) at this point for all of the details but instead I will cover the most important ones here.

`long myResult = (long)Equ.evaluate("11 * 7");`

That'w pretty much it to get started.  Replace the `"11 * 7"`with something that makes sense to your application and cast the results accordingly.  If the equation evaluates to a long then leave it as I have it.  But if it is a floating point then cast it to a `double`.  Equ will not return `int` or `float`, just the longer ones.   This is a list of all of the types that can be returned.

- Long
- Double
- Boolean
- LocalDate
- LocalTime
- LocalDateTime

In my previous example I took advantage of Java's auto-boxing feature and cast it to a primitive.
