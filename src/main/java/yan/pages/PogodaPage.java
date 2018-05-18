package yan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import yan.elements.SearchForecast;

public class PogodaPage {
    private WebDriver driver;
    private SearchForecast searchForecast;
    public PogodaPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public SearchForecast getPogodaSearch() {
        return this.searchForecast;
    }

}
