package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class UserAuthenticationTest {

    @Test
    public void testAuthenticateValidUser() {
        UserAuthentication auth = new UserAuthentication();
        boolean result = auth.authenticate(1); // Assuming 1 is a valid user ID
        assertTrue(result, "Authentication should succeed for valid user ID");
    }

    @Test
    public void testAuthenticateInvalidUser() {
        UserAuthentication auth = new UserAuthentication();
        boolean result = auth.authenticate(-1); // Assuming -1 is an invalid user ID
        assertFalse(result, "Authentication should fail for invalid user ID");
    }
}
