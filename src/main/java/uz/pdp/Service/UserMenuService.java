package uz.pdp.Service;


import uz.pdp.DB.DB;
import uz.pdp.Util.Input;

public class UserMenuService {
    public static void userMenu() {
        while (true) {
            System.out.println("\n--- 📋 Foydalanuvchi menyusi ---");
            System.out.println("""
                    1. 📝 Mening vazifalarim
                    2. ➕ Yangi vazifa qo‘shish
                    3. ✅ Vazifa holatini o‘zgartirish
                    4. ❌ Vazifani o‘chirish
                    0. 🔚 Chiqish
                    """);

            switch (Input.num("Tanlovingizni kiriting: ")) {
                case 1 -> TodoService.showMyTodos();
                case 2 -> TodoService.addTodo();
                case 3 -> TodoService.changeStatus();
                case 4 -> TodoService.deleteTodo();
                case 0 -> {
                    DB.CURRENT_USER = null;
                    System.out.println("🔒 Logout bo‘ldingiz. Asosiy menyuga qaytildi.\n");
                    return;
                }
                default -> System.out.println("⚠️ Noto‘g‘ri tanlov! Qaytadan urinib ko‘ring.");
            }
        }
    }
}
