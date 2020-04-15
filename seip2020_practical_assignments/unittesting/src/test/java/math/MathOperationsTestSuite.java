package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A Test Suite class for executing the MyMathParameterizedTest and
 * ArithmeticOperationsTest classes
 * 
 * @author pandeliskirpoglou
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ MyMathTest.class, MyMathParameterizedTest.class })
public class MathOperationsTestSuite {

}
