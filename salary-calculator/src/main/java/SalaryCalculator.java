public class SalaryCalculator {

    private static final double ATTENDANCE_PENALTY = 0.15;
    private static final double NO_PENALTY_MULTIPLIER = 1.00;
    private static final int MAX_SKIPPED_DAYS = 5;
    private static final int BONUS_MULTIPLIER_PER_PRODUCT_SOLD = 10;
    private static final int PRODUCTS_SOLD = 20;
    private static final int BONUS_MULTIPLIER_OVER_TWENTY_PRODUCT_SOLD = 13;
    private static final double BASE_SALARY = 1000.00;
    private static final double MAX_SALARY = 2000.00;


    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped < MAX_SKIPPED_DAYS ? 
                NO_PENALTY_MULTIPLIER : 
                NO_PENALTY_MULTIPLIER - ATTENDANCE_PENALTY;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold < PRODUCTS_SOLD ? 
                BONUS_MULTIPLIER_PER_PRODUCT_SOLD : 
                BONUS_MULTIPLIER_OVER_TWENTY_PRODUCT_SOLD;
    }

    public double bonusForProductsSold(int productsSold) {
        return bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double calculatedSalary = (salaryMultiplier(daysSkipped) * BASE_SALARY) + bonusForProductsSold(productsSold);
        return calculatedSalary > MAX_SALARY ? MAX_SALARY : calculatedSalary;
    } 
}
