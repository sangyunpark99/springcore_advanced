package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.Client;
import hello.proxy.pureproxy.proxy.code.Proxy;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        Client client = new Client(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        Client client = new Client(proxy);

        client.execute();
        client.execute();
        client.execute();
    }
}
