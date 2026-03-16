import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

class DNSCache {

    HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry) {
                System.out.println("Cache HIT");
                return entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        System.out.println("Cache MISS");

        String ip = "172.217.14.206"; // simulated DNS
        cache.put(domain, new DNSEntry(ip, 5000));

        return ip;
    }

    public static void main(String[] args) {

        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}