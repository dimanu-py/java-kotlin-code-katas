package org.dimanu.deployservice.infra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.dimanu.deployservice.domain.Clock;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeployserviceApplicationTests {

    @LocalServerPort
    private int port;

    @MockBean
    private Clock clock;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void should_get_deployment_history() {
        givenVersion1WasDeployedAtDate1WithSuccess();
        givenVersion2WasDeployedAtDate1WithRollback();

        Response response = whenIFetchDeploymentHistory();

        thenTheDeploymentListShouldContainTheseDeployments(response);
    }

    private void thenTheDeploymentListShouldContainTheseDeployments(Response response) {
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", equalToFixture("deployment-history.json"));
    }

    private Matcher<?> equalToFixture(String fileName) {
        String fileContent = readFile(fileName);
        return equalTo(new JsonPath(fileContent).get(""));
    }

    private String readFile(String fileName) {
        try {
            java.net.URL url = getClass().getClassLoader().getResource(fileName);
            java.nio.file.Path restPath = java.nio.file.Paths.get(url.toURI());
            return new String(java.nio.file.Files.readAllBytes(restPath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Response whenIFetchDeploymentHistory() {
        return given().get("/deployments");
    }

    private void givenVersion2WasDeployedAtDate1WithRollback() {
        when(clock.now()).thenReturn(LocalDateTime.of(2020, 3, 15, 15, 49, 57));
        createDeployment("second-deploy.json");
    }

    private void createDeployment(String fileName) {
        given()
                .body(readFile(fileName))
                .contentType(ContentType.JSON)
                .post("/deployments")
                .then()
                .statusCode(201);
    }

    private void givenVersion1WasDeployedAtDate1WithSuccess() {
        when(clock.now()).thenReturn(LocalDateTime.of(2020, 3, 15, 10, 12, 34));
        createDeployment("first-deploy.json");
    }
}