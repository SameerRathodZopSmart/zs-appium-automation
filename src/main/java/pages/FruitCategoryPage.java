package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public class FruitCategoryPage {
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add'])[1]")
    private WebElement addIcon;
    public FruitCategoryPage(){
        PageFactory.initElements(MobileDriverManager.getDriver(),this);
    }
    public void clickOnAddIcon(String testname){
        MobileExplicitWaitFactories.click(addIcon, WaitStrategy.CLICKABLE,"User clicked on add icon to add product into the cart");
        MobileTestLog.logTestStep(testname,"Click Add  Button","User clicked on add icon to add product into the cart");
    }
}
