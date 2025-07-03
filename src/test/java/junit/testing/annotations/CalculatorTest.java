package junit.testing.annotations;

import junit.testing.Calculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Calculator Operations Test")
public class CalculatorTest {

    @Disabled("error")
    @Test
    @DisplayName("Test Addition of two numbers")
    public void addTest(){
        Calculator calculator=new Calculator();
        int add=calculator.add(1,2);
        assertEquals(3,add);

    }

    @Test
    @DisplayName("Test Substraction of two numbers #$%@")
    public void substractTest(){
        Calculator calculator=new Calculator();
        int sub=calculator.substract(2,1);
        assertEquals(1,sub);

    }
}
