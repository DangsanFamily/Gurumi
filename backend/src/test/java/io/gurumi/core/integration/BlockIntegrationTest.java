package io.gurumi.core.integration;

import static org.assertj.core.api.Assertions.assertThat;

import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.net.URI;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class BlockIntegrationTest {

    @Test
    void readBlock() {
        // given

        // when

        // then
    }

    @Test
    void createBlock() {
        RestAssured
            .given()
            .request()
            .contentType(ContentType.JSON)
            .body(BlockRequest.of("text", "hello gurumi"))

            .when()
            .post("/blocks")

            .then()
            .statusCode(HttpStatus.CREATED.value())
            .assertThat().header("location", CoreMatchers.notNullValue());
    }

    @Test
    void createBlock2(@Autowired TestRestTemplate restTemplate) {
        ResponseEntity<BlockResponse> responseEntity = restTemplate.postForEntity(
            URI.create("/blocks"),
            BlockRequest.of("text", "hello gurumi"),
            BlockResponse.class
        );
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getHeaders().get("location")).containsExactly("abcd");
    }
}
