package uz.pdp.Service;


import uz.pdp.DB.DB;
import uz.pdp.Model.Status;
import uz.pdp.Model.Todo;
import uz.pdp.Util.Input;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TodoService {

    public static void showMyTodos() {
        List<Todo> myTodos = DB.TODOS.stream()
                .filter(todo -> todo.getUserId() == DB.CURRENT_USER.getId())
                .collect(Collectors.toList());

        if (myTodos.isEmpty()) {
            System.out.println("🚫 Sizda hech qanday vazifa yo‘q.");
            return;
        }

        System.out.println("--- 📋 Vazifalaringiz ---");
        for (Todo todo : myTodos) {
            System.out.println(todo);
        }
    }

    public static void addTodo() {
        long id = Math.abs(new Random().nextLong(100000));
        String title = Input.str("📝 Vazifa sarlavhasi: ");
        String description = Input.str("📄 Vazifa tavsifi: ");

        Todo todo = new Todo(id, title, description, Status.NEW, DB.CURRENT_USER.getId());
        DB.TODOS.add(todo);
        System.out.println("✅ Vazifa muvaffaqiyatli qo‘shildi!");
    }

    public static void changeStatus() {
        long id = Input.lon("O‘zgartirmoqchi bo‘lgan vazifa ID sini kiriting: ");
        for (Todo todo : DB.TODOS) {
            if (todo.getId() == id && todo.getUserId() == DB.CURRENT_USER.getId()) {
                System.out.println("Hozirgi holati: " + todo.getStatus());
                System.out.println("""
                        1 - NEW
                        2 - IN_PROGRESS
                        3 - DONE
                        """);
                int statusChoice = Input.num("Yangi holatni tanlang: ");
                switch (statusChoice) {
                    case 1 -> todo.setStatus(Status.NEW);
                    case 2 -> todo.setStatus(Status.IN_PROGRESS);
                    case 3 -> todo.setStatus(Status.DONE);
                    default -> {
                        System.out.println("❌ Noto‘g‘ri tanlov!");
                        return;
                    }
                }
                System.out.println("✅ Holat muvaffaqiyatli o‘zgartirildi.");
                return;
            }
        }
        System.out.println("❌ Vazifa topilmadi yoki sizga tegishli emas.");
    }

    public static void deleteTodo() {
        long id = Input.lon("O‘chirmoqchi bo‘lgan vazifa ID sini kiriting: ");
        for (Todo todo : DB.TODOS) {
            if (todo.getId() == id && todo.getUserId() == DB.CURRENT_USER.getId()) {
                DB.TODOS.remove(todo);
                System.out.println("🗑️ Vazifa o‘chirildi.");
                return;
            }
        }
        System.out.println("❌ Vazifa topilmadi yoki sizga tegishli emas.");
    }
}
