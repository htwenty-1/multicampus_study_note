package dto;

public class AccountDto {

    // 기본 멤버 변수
    private String dateTime;        // yyyy년 mm월 dd일
    private String use;             // 지출 카테고리(예: 극장구경, 데이트처럼 단어수준)
    private String classify;        // 수입 or 지출
    private int money;              // 금액
    private String memo;            // 메모(내용)

    public AccountDto(String classify) {
        this.classify = classify;
    }

    public AccountDto(String dateTime, String use, int money, String memo) {
        this.dateTime = dateTime;
        this.use = use;
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
        return dateTime + "작성내역 " + classify + " " + use + " " + money + " " + memo;
    }
}
