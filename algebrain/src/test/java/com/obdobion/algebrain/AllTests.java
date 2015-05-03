package com.obdobion.algebrain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Chris DeGreef
 * 
 */
@RunWith(Suite.class)
@SuiteClasses(
{
        TestAssignment.class, TestChaining.class, TestCompiling.class, TestEquations.class, TestPowers.class,
        TestPrecedence.class, TestRegisterFunction.class, TestReuse.class, TestTrig.class, TestVariableNames.class
})
public class AllTests
{
    // intentionally left blank
}
