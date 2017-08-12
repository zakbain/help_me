package tasks;

import java.util.ArrayList;
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

    public TaskHerder() {
        allUsers = new ArrayList<User>();
        userTasks = new HashMap<User, Task>();
    }

    // Builds one task per each user
    public void easyBuildOwnersTasks(String[] names, String[]
            descriptions) {

        // Create a user for each given name and give them a task from the array
        for (int i = 0; i < names.length; i++) {
            User owner = new User(names[i]);
            this.allUsers.add(owner);

            // Create a task; either use the description that is the same index as the owner name or
            // the last element in the descriptions array
            Task t = new Task(owner, descriptions[Math.max(i, descriptions.length - 1)]);
            this.userTasks.put(owner, t);
        }

    }

}
