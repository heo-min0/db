package dto;

public class AccountDto {

	private String date;
	private String use;
	private String classify;
	private int money;
	private String memo;
	
	public AccountDto() {
	}

	public AccountDto(String date, String use, String classify, int money, String memo) {
		this.date = date;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "[날짜=" + date + ", 사용처=" + use + ", 수입/지출=" + classify + ", 금액=" + String.format("%,d", money) + ", memo="
				+ memo + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
