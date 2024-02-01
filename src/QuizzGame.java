import java.util.Scanner;

public class QuizzGame {
    private Quizz quizz = new Quizz();
    private Player[] players = new Player[2];

    private Scanner playerInput = new Scanner(System.in);

    public QuizzGame() {
        createPlayers();

        quizz.createQuizz();
        startQuizz();
        showWinner();
    }
    private void createPlayers() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter players name");
            Player player = new Player(playerInput.nextLine());
            players[i] = player;
        }
    }

    private void startQuizz() {
        System.out.println("Quizz");
        for (int questionIndex = 0; questionIndex < quizz.questions.length; questionIndex++) {

            showQuestion(questionIndex);

            recordUserAnswers(questionIndex);
        }
    }

    private void showQuestion(int questionIndex) {
        System.out.println(quizz.questions[questionIndex].text);
        for (int j = 0; j < 4; j++) {
            System.out.println(quizz.questions[questionIndex].answers[j]);
        }
    }

    private void recordUserAnswers(int questionIndex) {
        for (int j = 0; j < 2; j++) {
            System.out.println(players[j].name + ":");
            if (Integer.parseInt(playerInput.nextLine()) == quizz.questions[questionIndex].correctAnswer) {
                players[j].correctAnswersCount++;
            } else {
                players[j].incorrectAnswersCount++;
            }
        }
    }

    private void showWinner() {
        if (players[0].correctAnswersCount > players[1].correctAnswersCount) {
            System.out.println("1. " + players[0].name);
            System.out.println("Postotak točnih odgovora: " + players[0].percentage());
            System.out.println("2. " + players[1].name);
            System.out.println("Postotak točnih odgovora: " + players[1].percentage());
        } else {
            System.out.println("1. " + players[1].name);
            System.out.println("Postotak točnih odgovora: " + players[1].percentage());

            System.out.println("2. " + players[0].name);
            System.out.println("Postotak točnih odgovora: " + players[0].percentage());
        }
    }

}
