package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetProductById implements Task {
    private final String productId;

    public GetProductById(String productId) {
        this.productId = productId;
    }

    public static GetProductById withId(String productId) {
        return instrumented(GetProductById.class, productId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/products/" + productId)
        );
    }
}