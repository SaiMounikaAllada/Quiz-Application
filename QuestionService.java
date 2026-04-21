package quiz;

import java.util.Scanner;

public class QuestionService {

	Question[] ques=new Question[5]; //stores 5 question objects.
	String[] select=new String[5];
	
    public QuestionService() 
    {
    	ques[0]=new Question(1,"What is pi value","3.14","1.32","1.43","3.41","3.14");
    	ques[1]=new Question(2,"In which year java is invented ?","1991","1997","1678","2003","1991");
    	ques[2]=new Question(3, "What is Java?","Language", "OS", "Browser", "DB","Language");
    	ques[3]=new Question(4,"Which keyword creates object?","class","new","this","static","new");
    	ques[4]=new Question(5, "OOP stands for?", "Object Oriented Programming", "Open OS", "Order Ops", "None", "Object Oriented Programming");
    }
//	public void displayQuestions()
//	{
//		for(Question q:ques)
//		{
//			System.out.println(q);
//		}
//	}
	
	public void playQuiz()
	{
		Scanner sc=new Scanner(System.in);
		int i=0;
		for(Question q:ques)
		{
			System.out.println("Question No " + q.getId());
			System.out.println(q.getQuestion());
			System.out.println("1: " + q.getOption1());
			System.out.println("2: " +q.getOption2());
			System.out.println("3: " +q.getOption3());
			System.out.println("4: " +q.getOption4());
			
			//Normalize user input early, compare later.
			System.out.print("Enter option number (1-4) OR answer text: ");
		    String input=sc.nextLine().trim();
			if(input.matches("\\d+"))
			{
				int option=Integer.parseInt(input);
				if(option>=1 && option<=4)
				{
					select[i]=q.getAnswerByNumber(option);
				}
				
				else
				{
			        select[i]=input; // numeric but treated as text (e.g. 1991)
				}
		    }
		   else
		   {
			   select[i]=input;
		   }
		
			i++;
		}
//		for(String s:select)
//		{
//			System.out.println(s);
//		}
	}
	
	
	public void showScore()
	{
		int score =0;
		for(int i=0;i<ques.length;i++)
		{
	    
		String actualAnswer=ques[i].getAnswer();
		String userAnswer=select[i];
		if(actualAnswer.equalsIgnoreCase(userAnswer))
		{
			score++;
		}
		}
		System.out.println("Your score : " +score);
	}
	
	
}




//questionService() constructor runs automatically when this object is created.
//Question q1=new Question(1,"What is pi value","3.14","1.32","1.43","3.41","3.14"); and then ques[0]=q1;
//Arrays in Java do not store objects,Arrays store references to objects,The object lives separately in memory.
//can save answer values with correct option ...to enter the answer through options.
//Because return immediately stops the method, else if is not required here.
//We write printing and user interaction code in QuestionService because it manages quiz flow, 
//but we write logic like getAnswerByNumber() in Question because it depends on question data, which the Question class owns.

//ques[i].getAnswerByNumber(optionSelect[i]);  ---- Take the i th Question object , Call its method getAnswerByNumber ,Pass the user’s selected option number as argument