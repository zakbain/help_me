package com.blackprince.tasks;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.blackprince.users.User;

/**
 * Created by Zak_b on 8/10/2017.
 * Anything a human being can do. This is not restricted to a programming notion of task but is
 * rather open ended to tasks that can be completed in the real world.
 */

public class Task {
    // The owner of this task
    private User owner;

    // Description of the task
    private String description;

    // The date it was created
    private Date dateCreated;

    // The desired date of completion
    private Date deadline;

    // Whether the deadline exists
    private boolean hasDeadline;

    // Whether the task is completed
    private boolean isCompleted;

    // List of questions that can be answered for a task
    private List<QuestionAnswer> questionsToAnswer;

    /**
     * Constructor - Creates a task with the given owner and description
     * @param owner
     *  The owner of this task
     * @param description
     *  The description of this task
     */
    public Task(User owner, String description) {
        this.owner = owner;
        this.description = description;

        // Set the date created as the current time
        this.dateCreated = Calendar.getInstance().getTime();

        // By default there is no deadline
        this.hasDeadline = false;
    }
}
