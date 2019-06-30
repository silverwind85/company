package pl.slcieslar.company.model.controllers;

import com.jayway.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEmplyee() {

    }

    @Test
    public void create() {
        given().contentType(ContentType.JSON).body("{\"name\":\"mike2\"}")
                .when().post("v1/employees")
                .then().statusCode(200);
    }

    @Test
    public void update() {
    }
}
