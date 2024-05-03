import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {
    private Map<String, UserSession> activeSessions;

    public SessionManager() {
        this.activeSessions = new HashMap<>();
    }

    // Simulates user login by creating a new session
    public void loginUser(String userId) {
        // Simulate checking user credentials and validating login
        if (validateUserCredentials(userId)) {
            // Invalidate previous session if exists
            if (activeSessions.containsKey(userId)) {
                activeSessions.remove(userId);
            }
            // Create new session
            UserSession newSession = createNewSession(userId);
            activeSessions.put(userId, newSession);
            System.out.println("User " + userId + " logged in with session ID: " + newSession.getSessionId());
        } else {
            System.out.println("Login failed for user: " + userId);
        }
    }

    // Validates user credentials (Dummy implementation)
    private boolean validateUserCredentials(String userId) {
        // In real scenario, add logic to check user's credentials
        return true; // Assuming validation is always successful
    }

    // Create a new session for a user
    private UserSession createNewSession(String userId) {
        return new UserSession(UUID.randomUUID().toString(), userId);
    }

    // User session inner class
    class UserSession {
        private String sessionId;
        private String userId;

        public UserSession(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }
    }
}
