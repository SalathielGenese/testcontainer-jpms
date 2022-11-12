package name.genese.salathiel.testcontainerjpms;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Testcontainers
public class HttpdTest {
    @Container
    @SuppressWarnings("resource")
    public GenericContainer<?> httpd = new GenericContainer<>(
            DockerImageName.parse("httpd:alpine")
    ).withExposedPorts(80);

    @Test
    void noop() throws IOException {
        final var bytes = new URL("http://0.0.0.0:%d".formatted(httpd.getMappedPort(80)))
                .openConnection()
                .getInputStream()
                .readAllBytes();
        System.out.println(new String(bytes));
    }
}
