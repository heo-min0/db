package dto;

// Data Transfer Object
public class accountDto {
	private String dateTime;	// 날짜	-> Calendar
	private String use;			// 용도
	private String classify;	// 수입/지출
	private int money;			// 금액
	private String memo;		// 내용
	
	public accountDto() {
	}

	public accountDto(String dateTime, String use, String classify, int money, String memo) {
		this.dateTime = dateTime;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "accountDto [dateTime=" + dateTime + ", use=" + use + ", classify=" + classify + ", money=" + money
				+ ", memo=" + memo + "]";
	}
	
}
