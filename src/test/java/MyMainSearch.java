
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;
import yan.elements.SearchForecast;
import yan.pages.PogodaPage;
import yan.testdata.DayInfo;

import java.util.ArrayList;
import yan.testdata.PogodaInput;
import java.util.List;

/**
 * Created by Vladimir on 16.05.2018.
 */
public class MyMainSearch {

    public WebDriver driver;

    @BeforeTest
    public void loadStartPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/pogoda/voronezh");
    }

    @Parameters("filename")
    @Test
    public void SearchPogoda(String filename) {

        PogodaPage pogodaPage = new PogodaPage(driver);
        SearchForecast searchForecast = pogodaPage.getPogodaSearch();
        ArrayList<DayInfo> listFromSite = searchForecast.getListDays();

        // Если вдруг нет желания самостоятельно набивать файл-эталон - его можно сформировать этим методом
//        PogodaInput.writeIntoExcel("Test4.xls", listFromSite);

//        ArrayList<DayInfo> listFromEtaon = PogodaInput.readFromExcel("Test4.xls");
        ArrayList<DayInfo> listFromEtaon = PogodaInput.readFromExcel(filename);

        Assert.assertTrue(listFromSite.equals(listFromEtaon),"Результат не совпадает с файлом эталона");

//        В принципе, если проводить "исследовательское тестирование", то можно получить "развернутый ответ" о совпавших и несовпавших элементах
//        System.out.println(CollectionUtils.containsAll(list1,list2));
//        ArrayList<DayInfo> list3 = (ArrayList<DayInfo>) CollectionUtils.retainAll(list1,list2);
//        System.out.println(list3.size()); // количество совпавших элементов
//        System.out.println(list1.equals(list2)); // их список
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
