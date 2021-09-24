import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {
    @Test
    void dummyTest(){
        assertEquals(35, 7*5);
    }
    @Test
    void shouldGetSuccessfulResponseCode() {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(200, client.getStatusCode());
    }
    @Test
    void shouldGetFailureResponseCode() {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/403");
        assertEquals(401, client.getStatusCode());
    }

}