package Recursos;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.Assertions.*;

@Suite
@SelectClasses({CaracteresTest.class, MaxIdTest.class})

class SuiteTest {

}