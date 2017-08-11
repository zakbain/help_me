package tasks;

import java.util.HashMap;

import users.User;

/**
 * Created by Zak_b on 8/10/2017.
 */

public interface TaskListView {
    /**
     * Refreshes the UI element that shows tasks
     */
    void refreshTaskList(HashMap<User, Task> userTasks);
}
