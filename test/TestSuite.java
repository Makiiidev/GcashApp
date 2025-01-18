package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    UserAuthenticationTest.class,
    CashInTest.class,
    CashTransferTest.class,
    CheckBalanceTest.class
})
public class TestSuite {
    // This class remains empty; it is used only as a holder for the above annotations
}
