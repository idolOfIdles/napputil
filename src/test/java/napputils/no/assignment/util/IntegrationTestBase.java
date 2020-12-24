package napputils.no.assignment.util;

import napputils.no.assignment.AssignmentApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = {AssignmentApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration(initializers = {IntegrationTestBase.Initializer.class})
@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestPropertySource(locations = {"classpath:application-integration-test.properties"})

public abstract class IntegrationTestBase {
    private static final String IMAGE_VERSION = "mongo:4.0.10";
    private static final Integer MONGODB_PORT = 27017;

    public static MongoDBContainer mongoDBContainer = new MongoDBContainer(IMAGE_VERSION)
            .withExposedPorts(MONGODB_PORT);

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            mongoDBContainer.start();
            TestPropertyValues.of(
                    "spring.data.mongodb.host=" + mongoDBContainer.getContainerIpAddress(),
                    "spring.data.mongodb.port=" + mongoDBContainer.getMappedPort(MONGODB_PORT)
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }}
