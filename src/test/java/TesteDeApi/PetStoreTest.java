package TesteDeApi;

import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreTest {

    String ct = "application/json";
    String uriPost = "https://petstore.swagger.io/v2/";
    static int petId;
    static int orderId;

    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    @Test
    @Order(1)
    public void CadastroBichentoTest() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/jsonBodyPetPost.json");

        Response response = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriPost + "pet")
        .then()
                .statusCode(200)
                .log().all()
                .body("category.name", is("Gato"))
                .body("name", is("Bichento"))
                .body("tags.id", contains(15))
                .extract();
        petId = response.jsonPath().getInt("id");
    }

    @Test
    @Order(2)
    public void CadastroHermioneTest() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/jsonBodyUserPost.json");

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriPost + "user")
        .then()
                .statusCode(200)
                .log().all()
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is("48715226"));
    }

    @Test
    @Order(3)
    public void VendaPetTest() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/jsonBodyPetSell.json");

        Response response = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriPost + "store/order")
        .then()
                .statusCode(200)
                .log().all()
                .body("id", is(1))
                .body("petId", is(petId))
                .body("status", is("approved"))
                .extract();
        orderId = response.jsonPath().getInt("id");
    }

    @Test
    @Order(4)
    public void AtualizarPetTest() throws IOException {

        String jsonnBody = lerArquivoJson("src/test/resources/json/jsonBodyPetPut.json");

        given()
                .contentType(ct)
                .log().all()
                .body(jsonnBody)
        .when()
                .post(uriPost + "pet")
        .then()
                .statusCode(200)
                .log().all()
                .body("status", is("sold"));

    }

    @Test
    @Order(5)
    public void VerificarPetTest() {

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriPost + "pet/" + petId)
        .then()
                .statusCode(200)
                .log().all()
                .body("name", is("Bichento"))
                .body("status", is("sold"));

    }

    @Test
    @Order(6)
    public void ConsultarOrdemVendaPetTest() {

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriPost + "store/order/" + orderId)
        .then()
                .statusCode(200)
                .log().all()
                .body("id", is(1))
                .body("petId", is(petId))
                .body("status", is("approved"))
                .body("complete", is(true))
        ;

    }
}
