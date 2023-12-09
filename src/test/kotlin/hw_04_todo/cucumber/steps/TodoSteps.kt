package hw_04_todo.cucumber.steps

import data.Priority
import data.Task
import data.TasksRepositoryMemory
import io.cucumber.java8.En
import io.github.serpro69.kfaker.Faker
import kotlin.test.assertEquals

class TodoSteps : En {

    init {
        lateinit var tasks: TasksRepositoryMemory

        val faker = Faker()
        val name = faker.theOffice.quotes()
        val priority = Priority.entries.random()
        val testTask = Task( name = name, priority = priority)

        Given("User launches the app") {
        tasks = TasksRepositoryMemory()
        }

        When("User adds a task") {
            tasks.addTask(testTask)
        }

        Then("Task should appear in the task list") {
            assertEquals(name, tasks.getTasks().first().name)
        }

        When("User completes the task") {
            val taskId = tasks.addTask(testTask)
            tasks.completeTask(taskId)
        }

        Then("Task should appear in the completed list") {
            assertEquals(true, tasks.getTasks(completed = true).isNotEmpty())
        }
    }
}