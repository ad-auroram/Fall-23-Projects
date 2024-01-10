public abstract class Date {
    public int year;
    public int month;
    public int day;

    public Date(){
        this.year = 1;
        this.month = 1;
        this.day = 1;
    }


    abstract boolean isLeapYear(int year);

    abstract boolean isLeapYear();

    public void addDays(int days){
        for (int i=0; i<days; i++) {
            day += 1;
            if (day > getNumberOfDaysInMonth(year, month)) {
                day = 1;
                month += 1;
            }
            if (month > 12) {
                month = 1;
                year += 1;
                day = 1;
            }
        }
    }

    public void subtractDays(int days){
        for (int i=0; i<days; i++) {
            day -= 1;
            if (day < 1) {
                month -= 1;
                day = getNumberOfDaysInMonth(year, month);
            }
            if (month < 1) {
                month = 12;
                year -= 1;
                day = getNumberOfDaysInMonth(year, month);
            }
        }
    }
    public void printShortDate(){
        System.out.printf("%d/%d/%d", month, day, year);
    }

    public void printLongDate(){
        System.out.printf("%s %d, %d", getMonthName(), day, year);
    }

    public String getMonthName() {
        switch (month) {
            case 1 -> {
                return "January";
            }
            case 2 -> {
                return "February";
            }
            case 3 -> {
                return "March";
            }
            case 4 -> {
                return "April";
            }
            case 5 -> {
                return "May";
            }
            case 6 -> {
                return "June";
            }
            case 7 -> {
                return "July";
            }
            case 8 -> {
                return "August";
            }
            case 9 -> {
                return "September";
            }
            case 10 -> {
                return "October";
            }
            case 11 -> {
                return "November";
            }
            case 12 -> {
                return "December";
            }
            default -> {
                return "Not a month";
            }
        }
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getDayOfMonth(){
        return day;
    }

    private int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }else{
            return 0;
        }
    }
}
