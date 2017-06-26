package learn3;

public class EnumTest {
    public static void doW(Do doEnum) {
        switch (doEnum) {
            case CAO:
                System.out.println("SunLang&ZhangXun?");
                break;
            case KAO:
                System.out.println("SunLang&YuanFang?");
                break;
            case RI:
                System.out.println("SunLang&LiuLing?");
                break;
            case GAN:
                System.out.println("SunLang&ZhuanShengBenBanZhang?");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        doW(Do.CAO);
    }
}

enum Do {
    CAO, KAO, RI, GAN
}
