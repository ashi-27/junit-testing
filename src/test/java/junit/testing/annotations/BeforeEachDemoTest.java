package junit.testing.annotations;

import junit.testing.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeforeEachDemoTest {



    private Calculator calculator;
    @BeforeEach
    void testSetup(){
         calculator=new Calculator();

    }
    @Test
    @DisplayName("Test Addition of two numbers")
     void addTest(){

        int add=calculator.add(1,2);
        assertEquals(3,add);

    }

    @Test
    @DisplayName("Test Substraction of two numbers #$%@")
    void substractTest(){

        int sub=calculator.substract(2,1);
        assertEquals(1,sub);

    }

    @Test
    @DisplayName("Test Substraction of two numbers #$%@")
    void multiplyTest(){

        int mul=calculator.multiply(2,1);
        assertEquals(2,mul);
    }

    @Test
    @DisplayName("Test Substraction of two numbers #$%@")
     void divideTest(){

        int div=calculator.divide(2,1);
        assertEquals(2,div);
    }
}
