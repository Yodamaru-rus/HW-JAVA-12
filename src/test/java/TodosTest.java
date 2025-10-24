import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    SimpleTask simpleTaskSecond = new SimpleTask(0, "Выполнить домашнее задание");


    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    String[] subtasksNext = {"кружка", "чашка", "ложка"};
    Epic epicSecond = new Epic(9, subtasksNext);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Meeting meetingTomorrow = new Meeting(
            678,
            "Проверка после наката",
            "Приложение СЭД",
            "В среду до обеда"
    );

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.add(meetingTomorrow);
        todos.add(epicSecond);
        todos.add(simpleTaskSecond);
    }

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting, meetingTomorrow, epicSecond, simpleTaskSecond};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosSimpleTaskPositive() {
        Task[] expected = new SimpleTask[]{simpleTask};
        Task[] actual = todos.search("род");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosEpicPositive() {
        Task[] expected = new Epic[]{epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosMeetingTopicPositive() {
        Task[] expected = new Meeting[]{meeting};
        Task[] actual = todos.search("версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosMeetingProjectPositive() {
        Task[] expected = new Meeting[]{meeting};
        Task[] actual = todos.search("Банк");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosMoreTwoPositive() {
        Task[] expected = new Task[]{meeting, meetingTomorrow, epicSecond};
        Task[] actual = todos.search("лож");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTodosNegative() {
        Task[] expected = new Task[]{};
        Task[] actual = todos.search("Вампир");
        Assertions.assertArrayEquals(expected, actual);
    }
}
