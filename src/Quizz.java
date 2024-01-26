import java.util.Scanner;

public class Quizz {

    Scanner playerInput = new Scanner(System.in);
    Question[] questions = new Question[5];


    public void createQuizz(){
        for (int i = 0; i<5; i++){
            Question question = new Question();

            System.out.println("Enter your question");
            question.text = playerInput.nextLine();

            createAnswers(question);

            System.out.println("Enter your correct answer number");
            question.correctAnswer = Integer.parseInt(playerInput.nextLine());
            questions[i] = question;
        }
    }

    private void createAnswers(Question question){
        System.out.println("Enter four answers");
        for(int j = 0; j<4; j++){
            System.out.println("Enter your " + Integer.toString(j+1) + ". answer");
            question.answers[j] = playerInput.nextLine();
        }
    }
}
