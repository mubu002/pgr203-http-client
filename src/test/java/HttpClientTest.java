import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {
    @Test
    void dummyTest(){
        assertEquals(35, 7*5);
    }
    @Test
    void shouldGet200ResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(200, client.getStatusCode());
    }
    @Test
    void shouldGet401ResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/401");
        assertEquals(401, client.getStatusCode());
    }

    @Test
    void shouldReadResponseHeaders() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals("text/html; charset=utf-8", client.getHeader("Content-Type"));
    }
    @Test
    void shouldReadContentLength() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(3741, client.getContentLength());

    }
    @Test
    void shouldReadMessageBody() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertTrue(
                client.getMessageBody().startsWith("<!DOCTYPE html>\n<html"),
                "Should be html: " + client.getMessageBody()
        );
    }
}