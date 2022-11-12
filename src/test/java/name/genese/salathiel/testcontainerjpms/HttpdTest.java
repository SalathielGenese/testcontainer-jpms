package name.genese.salathiel.testcontainerjpms;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(new String(bytes, UTF_8), "<html><body><h1>It works!</h1></body></html>\n");
    }
}