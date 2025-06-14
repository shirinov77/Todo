import uz.pdp.Service.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Assalamu alaykum dasturga xush kelibsiz🙂");
        while (true) {
            System.out.println("""
                    1 - Ro'xyatdan o'tish
                    2 - Dasturga kirish
                    0 - Chiqish
                    """);
            switch (uz.pdp.Util.Input.num("Bo'limlardan birini tanlang")) {
                case 1 -> {
                    UserService.register();
                }
                case 2 -> {
                    UserService.login();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
}