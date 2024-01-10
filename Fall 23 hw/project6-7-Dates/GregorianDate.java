public class GregorianDate extends Date{

    public GregorianDate(){
        //set to today
        this.year += 1969;
        long milli = System.currentTimeMillis()+java.util.TimeZone.getDefault().getRawOffset();
        int today = (int) Math.floor((double) milli / 86400000);
        addDays(today);

    }
    public GregorianDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(){
        if (year % 400 == 0) {
            return true;
        }else if (year % 100 ==0){
            return false;
        } else if (year % 4 == 0) {
            return true;
        }else{
            return false;
        }
    }
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }else if (year % 100 ==0){
            return false;
        } else if (year % 4 == 0) {
            return true;
        }else{
            return false;
        }
    }

}
