package learn3;

public interface BuyVegetable {
    public int buyVegetableNum();
}

class BuySpinach implements BuyVegetable {

    public int buyVegetableNum() {
        return 3;
    }

}

class BuyCelery implements BuyVegetable {

    public int buyVegetableNum() {
        return 4;
    }

}