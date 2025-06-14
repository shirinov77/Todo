package uz.pdp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {
    private long id;
    private String title;
    private String description;
    private Status status;
    private long userId;

    public Todo(long id, String title, String description, Status status, long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "📌 ID: " + id +
                "\n📝 Sarlavha: " + title +
                "\n📄 Tavsif: " + description +
                "\n📍 Holat: " + status + "\n";
    }
}
