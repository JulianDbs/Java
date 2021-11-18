import com.supermarket.CountdownSuperMarket;
import com.supermarket.products.*;

public class Main {
  public static void main(String[] args) {
    CountdownSuperMarket superMarket = new CountdownSuperMarket();
    superMarket.addProductToList(new CountdownCheeseBlockEdam());
    superMarket.addProductToList(new CountdownLiteMilk());
    superMarket.addProductToList(new CountdownLiteMilk());
    superMarket.addProductToList(new HellersSausagesPrecooked());
    superMarket.addProductToList(new CountdownBurgerBunsSesame());
    superMarket.addProductToList(new CountdownNZBeefMinceGrassFed());
    superMarket.addProductToList(new DairyworksCheeseSlicesCheddar());
    superMarket.addProductToList(new HeinzTomatoKetchup());
    superMarket.addProductToList(new HeinzTomatoKetchup());
    superMarket.addProductToList(new HaagenBeerStrong());
    superMarket.addProductToList(new HaagenBeerStrong());
    superMarket.addProductToList(new HaagenBeerStrong());
    System.out.format(superMarket.getTicket());
  }
}
