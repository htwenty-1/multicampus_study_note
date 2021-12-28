package dto;

import java.time.LocalDateTime;

public class AccountDto {

    // 기본 멤버 변수
    private LocalDateTime dateTime;        // yyyy년 mm월 dd일
    private String use;             // 지출 카테고리(예: 극장구경, 단어수준)
    private String classify;        // 수입 or 지출
    private int money;              // 금액
    private String memo;            // 메모(내용)

    public AccountDto(String classify) {
        this.classify = classify;
    }

    public AccountDto(LocalDateTime dateTime, String classify, String use, int money, String memo) {
        this.dateTime = dateTime;
        this.classify = classify;
        this.use = use;
        this.money = money;
        this.memo = memo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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
        return dateTime + " 작성 " + classify + " " + use + " " + money + " " + memo;
    }
}
