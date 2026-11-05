package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface Ipo {
	void input()throws IOException ;
	void process();
	void output() ;
}

class DictionaryDto {
	// 입력
	private String quiz;
	// 출력
	private String answer;
	public DictionaryDto() {
	}
	public DictionaryDto(String quiz, String answer) {
		this.quiz = quiz;
		this.answer = answer;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "DictionaryDto [quiz=" + quiz + ", answer=" + answer + "]";
	}
	
}

class Dictionary implements Ipo {
	ArrayList<DictionaryDto> dl =new ArrayList<DictionaryDto>();
	private DictionaryDto d;
	@Override
	public void input() throws IOException {
		String	 path 	= "D:\\hein\\java\\TestPrj\\src\\ex01\\";
		String 	 infile = "data.txt";
		FileReader		fr		=	new FileReader (path + infile);
		BufferedReader  br		=	new BufferedReader(fr);
		
		
		String line = "";
		
		while ((line=br.readLine())!= null) {
			String [] li = line.trim().split(",");
			String quiz = li[0].trim();
			String answer = li[1].trim();
			DictionaryDto dto = new DictionaryDto(quiz, answer);
			dl.add(dto);
		}
	br.close();
	fr.close();
		
	}

	@Override
	public void process() {
	Scanner in = new Scanner(System.in);   
		System.out.println("단어 맞추기 게임");
		System.out.println("영어를 한글로 맞춰보세요");
		
		for (int i = 0; i < dl.size(); i++) {
			DictionaryDto temp = dl.get(i);
			System.out.println("문제 :" + temp.getQuiz());
			String useranswer = in.nextLine().trim();
			if (useranswer.equals(temp.getAnswer())) {
				System.out.println("정답입니다!");
			}else {
				System.out.println("땡 정답은 " + temp.getAnswer() + " 입니다.");
			}
					
		}
		in.close();
	}

	@Override
	public void output()  {
		System.out.println("문제를 모두 푸셨습니다. 감사합니다.");
	}
	
}
public class DictionaryTest {

	public static void main(String[] args) throws IOException {
		
		Dictionary d1 = new Dictionary();
		
		d1.input();
		d1.process();
		d1.output();
	}

}
