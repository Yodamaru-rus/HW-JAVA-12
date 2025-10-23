import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    SimpleTask exampleSimpleTask = new SimpleTask(2, "Купить хлеб");

    String[] subtasks = {"Математика", "Физика", "Химия", "Информатика", "Биология", "Астрология", "Геометрия", "Геология"};
    Epic exampleEpic = new Epic(13, subtasks);

    Meeting exampleMeeting = new Meeting(
            45,
            "Обсуждение задач для будущего релиза",
            "Программа повышения квалификации \"Узнавайка\"",
            "Понедельник 12:30"
    );

    @Test
    public void getSimpleTaskId() {
        int expected = 2;
        int actual = exampleSimpleTask.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getEpicId() {
        int expected = 13;
        int actual = exampleEpic.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMeetingId() {
        int expected = 45;
        int actual = exampleMeeting.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getterSimpleTask() {
        String expected = "Купить хлеб";
        String actual = exampleSimpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getterEpic() {
        String[] expected = {"Математика", "Физика", "Химия", "Информатика", "Биология", "Астрология", "Геометрия", "Геология"};
        String[] actual = exampleEpic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getterMeetingTopic() {
        String expected = "Обсуждение задач для будущего релиза";
        String actual = exampleMeeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getterMeetingProject() {
        String expected = "Программа повышения квалификации \"Узнавайка\"";
        String actual = exampleMeeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getterMeetingStart() {
        String expected = "Понедельник 12:30";
        String actual = exampleMeeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForSimpleTaskPositive() {
        boolean expected = true;
        boolean actual = exampleSimpleTask.matches("пить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicPositive() {
        boolean expected = true;
        boolean actual = exampleEpic.matches("Гео");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingTopicPositive() {
        boolean expected = true;
        boolean actual = exampleMeeting.matches("задач");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingProjectPositive() {
        boolean expected = true;
        boolean actual = exampleMeeting.matches("Узнавайка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForSimpleTaskNegative() {
        boolean expected = false;
        boolean actual = exampleSimpleTask.matches("пять");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicNegative() {
        boolean expected = false;
        boolean actual = exampleEpic.matches("Музыка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingNegative() {
        boolean expected = false;
        boolean actual = exampleMeeting.matches("15:00");
        Assertions.assertEquals(expected, actual);
    }

}
