package assignments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;

public class Bowler{
	String name;
	int num_of_games;
	int avg_score;
	int last_score;
	String last_date;
	static ArrayList <Bowler> al = new ArrayList <Bowler>();
	
	public Bowler(String name, int num_of_games, int avg_score, int last_score, String last_date) {
		this.name = name;
		this.num_of_games = num_of_games;
		this.avg_score = avg_score;
		this.last_score = last_score;
		this.last_date = last_date;
	}
	
	public static void main(String args[]) throws ParseException{
		Scanner player = new Scanner(System.in);
		// I decide to let users enter 5 bowler info
		for(int i=0; i < 5; i++) { 
			System.out.println("Please enter player information:");
			System.out.println("Name\nNum of games\nAverage score\nLast score\nLast date(ex:2022/1/1)");
			String name = player.next();
			int game_num = player.nextInt();
			int avg_score = player.nextInt();
			int last_score = player.nextInt();
			String last_date = player.next();
			Bowler bowler = new Bowler(name, game_num, avg_score, last_score, last_date);
			al.add(bowler);
		}
		
		Iterator iter = al.iterator();
		while(iter.hasNext()) {
			Bowler bow = (Bowler)iter.next();
			System.out.println("Name: " + bow.name + ", Num of games: " + bow.num_of_games);
			System.out.println("Average score: " + bow.avg_score + ", Last score: " + bow.last_score + ", Last date: " + bow.last_date);
			System.out.println("-------------------------------");
		}
	}
	
}







