// 4.1 9.7（账户类Account）

import java.util.Date;

public class p1AccountClass {
    // 创建一个Account类
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    p1AccountClass() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    /**
     * 创建默认账户类型
     * 
     * @param uniqueId     特定用户id
     * @param startBalance 初始余额
     */
    p1AccountClass(int uniqueId, double startBalance) {
        id = uniqueId;
        balance = startBalance;
        dateCreated = new Date();
    }

    /** id访问器 */
    public int getId() {
        return id;
    }

    /** id修改器 */
    public void setId(int newId) {
        id = newId;
    }

    /** balance访问器 */
    public double getBalance() {
        return balance;
    }

    /** balance修改器 */
    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    /** annualInterestRate访问器 */
    public double getInterestAnnualRate() {
        return annualInterestRate;
    }

    /** annualInterestRate修改器 */
    public void setInterestAnnualRate(double newAnnualRate) {
        annualInterestRate = newAnnualRate;
    }

    /** dateCreate访问器 */
    public Date getDateCreated() {
        return dateCreated;
    }

    /** 返回月利率 */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 100 / 12;
    }

    /** 返回月利息 */
    public double getMonthlyInterest() {
        return balance * annualInterestRate / 100 / 12;
    }

    /** 从账户提取特定数额 */
    public void withDraw(double withDrawBalance) {
        balance -= withDrawBalance;
    }

    /** 向账户存储特定数额 */
    public void deposit(double depositBalance) {
        balance += depositBalance;
    }

    // 测试Account类
    public static void main(String[] args) {
        p1AccountClass account1 = new p1AccountClass(1122, 20000); // 创建一个账户ID为1122，余额为20000美元
        account1.setInterestAnnualRate(4.5); // 年利率为4.5%
        account1.withDraw(2500); // 取出2500美元
        account1.deposit(3000); // 存3000美元
        // 打印余额、月利息以及这个账户的开户日期
        System.out.println("Balance = " + account1.getBalance() + "\n" + "Monthly Interest Rate = "
                + account1.getMonthlyInterestRate() + "\n" + "Date Created = " + account1.getDateCreated().toString());
    }
}