package com.blackprince.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.blackprince.users.User;

/**
 * Created by Zak_b on 8/10/2017.
 * Herds and implements interactions between list of users and tasks.
 */

public class TaskHerder {
    // List of all known user
    private List<User> allUsers;

    // Map between users and their known tasks
    private HashMap<User, Task> userTasks;

    public static boolean isSingletonInitialized;
    public static TaskHerder singleton;

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

    public List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (User user: this.allUsers) {
            names.add(user.getName());
        }

        return names;
    }

    public void addUser(String name) {
        User user = new User(name);
        allUsers.add(user);
    }

    public static TaskHerder getSingleton() {
        if (!isSingletonInitialized) {
            singleton = new TaskHerder();


            String[] names = {"Leann", "Jonathan", "Amy", "Belinda", "Veronica", "Julie", "Katie",
                    "Caleb", "America", "Monica", "Kanye", "Drake", "Elphaba"};

            String[] descs = {"FUCK THIS", "I hate most developers", "this developer behind me is a " +
                    "shitead", "I can't even talk to them", "They think they're the best at " +
                    "everything", "I used to think that", "My emotional wellbeing matters", "I care " +
                    "about life", "Oh god", "This is depressing", "oooh aaah", "Fucking ey", "JK",
                    "They're not so bad", "It's just they're emotional melody", "is quite " +
                    "unattractive"};

            singleton.easyBuildOwnersTasks(names, descs);

            isSingletonInitialized = true;
        }


        return singleton;
    }
}
