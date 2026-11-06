package ex02;

public class HLedgerDTO {
	// 필드
		// 입력	날짜 (20261106) 입금 출금 내역
		private String date;
		private int inpay;
		private int outpay;
		private String memo;
		
		
		public HLedgerDTO(String date, int inpay, int outpay, String memo) {
			this.date = date;
			this.inpay = inpay;
			this.outpay = outpay;
			this.memo = memo;
		}
		public String getDate() {
			return date;
		}
		public int getInpay() {
			return inpay;
		}
		public int getOutpay() {
			return outpay;
		}
		public String getMemo() {
			return memo;
		}
		@Override
		public String toString() {
			return String.format("[%s] 내역: %s 입금: %d 원 출금: %d 원",date,memo,inpay,outpay);
					}
		public String toFileString () {
			 return date + "," + inpay + "," + outpay + "," + memo;
		}
}
