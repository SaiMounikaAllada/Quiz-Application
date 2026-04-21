package quiz;

public class QuizApplication {
    public static void main(String args[])
    {
    	 QuestionService q=new QuestionService();
    	 q.playQuiz();
    	 q.showScore();
    }
    
    
}
