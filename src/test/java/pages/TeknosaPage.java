package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeknosaPage {

    public TeknosaPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }

    List<Integer> intFiyatListesi = new ArrayList<>();

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[4]")
    public WebElement atlaButonu;

    @FindBy(xpath = "//*[@text='Filtrele']")
    public WebElement filtereButonu;

    @FindBy(xpath = "//*[@text='Marka']")
    private WebElement markaButonu;

    @FindBy(xpath = "//*[@text='Sonuçları Göster']")
    public WebElement sonuclariGosterButonu;

    @FindBy(xpath = "//*[@class='android.widget.TextView']")
    public List<WebElement> fiyatList;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement markaAramaKutusu;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[25]")
    public WebElement kutucukTik;


    public void markaSecimi(String markaAdi){
        markaButonu.click();
        ReusableMethods.bekle(1);
        markaAramaKutusu.sendKeys(markaAdi);
        ReusableMethods.bekle(1);
        kutucukTik.click();
        sonuclariGosterButonu.click();



    }



    public void checkIfSortedInDescendingOrder() {
        // WebElement listesindeki text'leri alarak işlemi yapıyoruz
        List<Integer> intValues = fiyatList.stream()
                .map(WebElement::getText)  // WebElement'ten text'i alıyoruz
                .map(text -> text.replace(",", "").replace(" TL", ""))  // Virgül ve 'TL' ifadesini kaldırıyoruz
                .map(Integer::parseInt)  // Integer'a çeviriyoruz
                .collect(Collectors.toList());

        // Listemizi azalan sıraya göre kontrol ediyoruz
        boolean isSorted = true;
        for (int i = 0; i < intValues.size() - 1; i++) {
            if (intValues.get(i) < intValues.get(i + 1)) {
                isSorted = false; // Eğer herhangi bir eleman bir sonrakinden küçükse sıralama hatalıdır
                break;
            }
        }

        // Sonucu ekrana yazdırıyoruz
        if (isSorted) {
            System.out.println("Liste azalan sırada sıralanmıştır.");
        } else {
            System.out.println("Liste azalan sırada sıralanmamıştır.");
        }
    }

}
