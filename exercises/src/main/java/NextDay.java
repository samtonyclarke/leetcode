public class NextDay {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String args[]) {
        NextDay nextDay = new NextDay();
        nextDay.addDays("2099-12-31", 50000);
    }
    
    public String addDays(String date, int n) {
        // Split date into year, month, and day
        String[] timeParts = date.split("-");
        int year = Integer.parseInt(timeParts[0]);
        int month = Integer.parseInt(timeParts[1]);
        int day = Integer.parseInt(timeParts[2]);

        // Add 'n' days
        while (n > 0) {
            int daysInCurrentMonth = getDaysInMonth(year, month);

            // Calculate remaining days in the current month
            int remainingDaysInMonth = daysInCurrentMonth - day + 1;

            if (n >= remainingDaysInMonth) {
                // Move to the next month
                n -= remainingDaysInMonth;
                day = 1;
                month++;

                if (month > 12) {
                    // If month exceeds December, move to next year
                    month = 1;
                    year++;
                }
            } else {
                // If remaining days fit in the current month
                day += n;
                n = 0;
            }
        }

        // Return the result in YYYY-MM-DD format
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    // Helper function to get the number of days in a given month and year
    private int getDaysInMonth(int year, int month) {
        if (month == 2 && isLeapYear(year)) {
            return 29; // February in a leap year
        }
        return DAYS_IN_MONTH[month - 1];
    }

    // Helper function to determine if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
