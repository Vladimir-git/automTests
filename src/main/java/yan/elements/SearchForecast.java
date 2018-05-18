package yan.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Named;
import yan.testdata.DayInfo;

import java.util.ArrayList;
import java.util.List;

@FindBy(css = ".forecast-briefly__days")
public class SearchForecast extends HtmlElement {
    @FindBy(css = ".forecast-briefly__day")
    private List<WebElement> brieflyDays;

    public ArrayList<DayInfo> getListDays() {
        List<WebElement> resultSearch = brieflyDays;
        ArrayList<DayInfo> days = new ArrayList<>();
        for (WebElement elem : resultSearch){
            DayInfo day = new DayInfo();
            day.nameDay = elem.findElement(By.cssSelector(".forecast-briefly__name")).getAttribute("textContent");
            day.temperature = elem.findElement(By.cssSelector(".temp__value")).getAttribute("textContent");
            days.add(day);
        }
//        микро костылик что бы заменить название первого дня в списке с "Сегодня" на название дня недели
        days.get(0).nameDay = days.get(7).nameDay;

       return days;
    }
}
