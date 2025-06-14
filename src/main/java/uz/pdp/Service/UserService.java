package uz.pdp.Service;


import uz.pdp.DB.DB;
import uz.pdp.Model.User;
import uz.pdp.Util.Input;

import java.util.Random;

public class UserService {

    public static void register() {
        String username;
        while (true) {
            username = Input.str("Iltimos username kiriting: ");
            String finalUsername = username;
            boolean exists = DB.USERS.stream()
                    .anyMatch(u -> u.getUsername().equals(finalUsername));
            if (exists) {
                System.out.println("❌ Bu username band. Iltimos boshqasini tanlang.");
            } else {
                break;
            }
        }

        Random random = new Random();
        long id = Math.abs(random.nextLong(100000));

        User user = new User(
                id,
                Input.str("Iltimos ismingizni kiriting: "),
                Input.str("Iltimos familyangizni kiriting: "),
                username,
                Input.str("Parolingizni kiriting: ")
        );

        DB.USERS.add(user);
        System.out.println("✅ Muvaffaqiyatli ro‘yxatdan o‘tdingiz!");
    }

    public static void login() {
        String username = Input.str("Username kiriting: ");
        String password = Input.str("Parol kiriting: ");

        for (User user : DB.USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                DB.CURRENT_USER = user;
                System.out.println("✅ Xush kelibsiz, " + user.getName() + "!");
                UserMenuService.userMenu();
                return;
            }
        }

        System.out.println("❌ Username yoki parol noto‘g‘ri!");
    }
}
