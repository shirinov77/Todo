package uz.pdp.DB;

import uz.pdp.Model.Todo;
import uz.pdp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static final List<User> USERS = new ArrayList<>();
    public static final List<Todo> TODOS = new ArrayList<>();
    public static User CURRENT_USER = null;
}
