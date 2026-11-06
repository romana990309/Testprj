package ex02;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HLedgerProcess {
	// 읽어온 것들 정리할 리스트
	private ArrayList<HLedgerDTO> list = new ArrayList<HLedgerDTO>();
	// 파일 읽어오기
	 private final String FILE_PATH = "D:\\hein\\java\\TestPrj\\src\\ex02\\HLedger.txt"; 
	 public void loadFromFile() {
	        File file = new File(FILE_PATH);
	        if (!file.exists()) {
	            System.out.println(" 기존 가계부 파일이 없습니다. 새로 시작합니다.");
	            return;
	        }
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] tokens = line.split(",");
	                if (tokens.length == 4) {
	                    list.add(new HLedgerDTO(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
	                }
	            }
	        } catch (FileNotFoundException e) {
	            // 자바가 걱정했던 "파일이 없을 때"에 대한 대책을 여기에 적어줍니다.
	            System.out.println("❌ 파일을 찾을 수 없습니다: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("❌ 파일을 읽는 중 오류 발생: " + e.getMessage());
	        }
	 }
	// 직접 입력 받기
	 public void addItem(HLedgerDTO item) {
	        list.add(item);
	        System.out.println("👉 내역이 추가되었습니다.");
	    }
	// 총금액 계산 (입금-출금)
	 public void totalPay() {
		 int totInpay = 0;
		 int totOutpay = 0;
		 
		 for (HLedgerDTO item : list) {
			 totInpay += item.getInpay();
			 totOutpay += item.getOutpay();
		 }
		 System.out.println("총 입금 금액은" + totInpay + "원 입니다.");
		 System.out.println("총 출금 금액은" + totOutpay + "원 입니다.");
		 System.out.println("총 잔여 금액은" + (totInpay-totOutpay) + "원 입니다.");
	 }
	// 날짜별로 입출금내역 확인하는거
	
	
	
}
