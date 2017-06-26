package learn3;

public interface BuyVegetable1 {
    public int buyVegetable(String nameOfVegetableThatYouSee0);
}

class BuyNum implements BuyVegetable1 {

    public int buyVegetable(String nameOfVegetableThatYouSee0) {
        if (nameOfVegetableThatYouSee0 == "spinach") {
            return 3;
        } else if (nameOfVegetableThatYouSee0 == "celery") {
            return 4;
        } else {
            return 0;
        }
    }

}