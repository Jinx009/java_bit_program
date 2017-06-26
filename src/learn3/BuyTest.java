package learn3;

public class BuyTest {
    public static void main(String[] args) {
        BuyVegetable buy = new BuySpinach();

        System.out.println(buy.buyVegetableNum());

        BuyVegetable buy1 = new BuyCelery();

        System.out.println(buy1.buyVegetableNum());

        BuyVegetable1 bv = new BuyNum();

        String whatYouSee = "spinach";

        System.out.println(bv.buyVegetable(whatYouSee));
    }
}
