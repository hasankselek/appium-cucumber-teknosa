package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.TeknosaPage;
import utils.Driver;
import utils.ReusableMethods;

public class Teknosa {

    TeknosaPage page=new TeknosaPage();

    @Given("Uygulama baslatilir")
    public void uygulama_baslatilir() {
        Driver.getAndroidDriver();
        ReusableMethods.bekle(3);
    }
    @Given("Ilk ekran bolumunden atlaya tiklanir")
    public void ılk_ekran_bolumunden_atlaya_tiklanir() {
        page.atlaButonu.click();
        ReusableMethods.bekle(2);

    }
    @Given("footer bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumune_tiklanir(String footerSecim) {
        ReusableMethods.scrollWithUiScrollableAndClick(footerSecim);
    }
    @Given("kategoriler bolumunden {string} bolumune tiklanir")
    public void kategoriler_bolumunden_telefon_bolumune_tiklanir(String kategoriSecim) {
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriSecim);
    }
    @Given("telefon sayfasindan cihaz {string} secimi yapilir")
    public void telefon_sayfasindan_cihaz_secimi_yapilir(String cihazSecim) {
        ReusableMethods.scrollWithUiScrollableAndClick(cihazSecim);
    }
    @Given("filtrele bolumune tiklanir")
    public void filtrele_bolumune_tiklanir() {
        page.filtereButonu.click();
    }
    @Given("Marka bolumunden marka secimi {string} yapilir")
    public void marka_bolumunden_marka_secimi_yapilir(String markaSecim) {
        page.markaSecimi(markaSecim);


    }

    @Given("siralama yapilirak {string} secilir")
    public void siralama_yapilirak_azalan_fiyat_secilir(String siralamaTipi) {
        ReusableMethods.scrollWithUiScrollableAndClick(siralamaTipi);
        ReusableMethods.bekle(2);

    }
    @Given("fiyatlarin azalan duzende oldugu test edilir")
    public void fiyatlarin_azalan_duzende_oldugu_test_edilir() {
        page.checkIfSortedInDescendingOrder();

    }
}
