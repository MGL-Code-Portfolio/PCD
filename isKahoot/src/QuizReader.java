import com.google.gson.Gson;
import java.io.*;

public class QuizReader {
    public static Quiz loadFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Quiz.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Quiz quiz = loadFromFile("quizzes/quiz_exemplo.json");
        if (quiz != null) {
            System.out.println("Quiz: " + quiz.getName());
            System.out.println("Perguntas: " + quiz.getQuestions().size());
        }
    }
}
