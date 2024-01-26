public class Player {
    String name;
    int correctAnswersCount =  0;
    int incorrectAnswersCount = 0;

    float percentage(){
        return ((float) correctAnswersCount /(correctAnswersCount+incorrectAnswersCount)) * 100;
    }

    public Player(String name){
        this.name = name;
    }


}
