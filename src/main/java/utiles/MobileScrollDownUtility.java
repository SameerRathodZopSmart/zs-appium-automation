package utiles;

import driver.MobileDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class MobileScrollDownUtility {
    public static void scrollDown(WebDriver driver) {

        Dimension dimension = driver.manage().window().getSize();
        int startX = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.9);
        int endX = (int) (dimension.getWidth() * 0.2);
        int endY = (int) (dimension.getHeight() * 0.1);

        // Create the PointerInput and Sequence
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        // Add the scroll actions to the Sequence
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the scroll action
        MobileDriverManager.getDriver().perform(Collections.singletonList(scroll));

    }
}
