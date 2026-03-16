import java.util.*;

class TokenBucket {

    int tokens;
    long lastRefill;

    TokenBucket(int limit) {
        tokens = limit;
        lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();
    int limit = 5;

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(limit));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        RateLimiter r = new RateLimiter();

        System.out.println(r.checkRateLimit("abc"));
        System.out.println(r.checkRateLimit("abc"));
    }
}