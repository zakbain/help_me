package tasks;

import java.util.HashMap;
import java.util.List;

import tasks.Task;
import users.User;

/**
 * Created by Zak_b on 8/10/2017.
 * Herds and implements interactions between list of users and tasks.
 */

public class TaskHerder {
    // List of all known user
    private List<User> allUsers;

    // Map between users and their known tasks
    private HashMap<User, Task> userTasks;
}
