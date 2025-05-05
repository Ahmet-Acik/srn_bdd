package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.tasks.GetProductById;
import starter.tasks.GetAllProducts;
import starter.questions.ResponseCode;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

public class GetProductStepDefinitions {

    private final Actor user = Actor
            .named("API Tester")
            .whoCan(
                    CallAnApi.at("https://dummyjson.com"));

    @Given("the API is available")
    public void theApiIsAvailable() {
        // No action needed, just ensures the API is accessible
    }

    @When("the user fetches the product with ID {string}")
    public void theUserFetchesTheProductWithId(String productId) {
        user
                .attemptsTo(
                        GetProductById
                                .withId(productId));
    }

    @When("the user fetches all products")
    public void theUserFetchesAllProducts() {
        user
                .attemptsTo(
                        GetAllProducts.all());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        user
                .should(
                        seeThat(
                                ResponseCode.status(), equalTo(statusCode)));
    }
}