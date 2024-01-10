public class JulianDate extends Date {

    public JulianDate(){

        //set to today
        long milli = System.currentTimeMillis()+java.util.TimeZone.getDefault().getRawOffset();
        int today = (int) Math.floor((double) milli / 86400000)+719164;
        addDays(today);
    }
    public JulianDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(){
        if (year % 4==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean isLeapYear(int year){
        if (year % 4==0){
            return true;
        }else{
            return false;
        }
    }




}
