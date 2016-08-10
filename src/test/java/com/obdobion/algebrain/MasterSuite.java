package com.obdobion.algebrain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>MasterSuite class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
@RunWith(Suite.class)
@SuiteClasses({ TestAndOr.class, TestAssignment.class, TestChaining.class, TestCompiling.class, TestConstants.class,
        TestDates.class, TestEquations.class, TestFactorial.class, TestLogs.class, TestModulus.class, TestPowers.class,
        TestPrecedence.class, TestRegisterFunction.class, TestReuse.class, TestRoots.class, TestStrings.class,
        TestTrig.class, TestVariableNames.class })
public class MasterSuite
{

}
