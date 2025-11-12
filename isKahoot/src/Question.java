import java.util.List;

public class Question {
    private String question;
    private int correct;
    private int points;
    private List<String> options;

    public String getQuestion() {
        return question;
    }

    public int getCorrect() {
        return correct;
    }

    public int getPoints() {
        return points;
    }

    public List<String> getOptions() {
        return options;
    }

}
