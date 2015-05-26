import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Time {
    private int houers;
    private int minutes;
    private int seconds;
    private int date;
    private int month;
    private int year;

    public Time(){
    }

    public Time(int timeHouers, int timeMinutes){
        houers = timeHouers;
        minutes = timeMinutes;
    }

    public Time(int timeHouers, int timeMinutes, int timeSeconds){
        houers = timeHouers;
        minutes = timeMinutes;
        seconds = timeSeconds;
    }

    public Time(int timeHouers, int timeMinutes, int timeSeconds, int timeDate, int timeMonth, int timeYear){
        houers = timeHouers;
        minutes = timeMinutes;
        seconds = timeSeconds;
        date = timeDate;
        month = timeMonth;
        year = timeYear;
    }

    public int getHouers(){
        return houers;
    }

    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    public int getDate(){
        return date;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void setHouers(int houers) {
        this.houers = houers;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        String stringTime = String.valueOf(houers) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
        stringTime += " " + String.valueOf(date) + "." + String.valueOf(month) + "." + String.valueOf(year);
        return stringTime;
    }

    static public Time now(){
        Date date = new Date();
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(date);
        Time timeNow = new Time(currentCalendar.get(Calendar.HOUR_OF_DAY), currentCalendar.get(Calendar.MINUTE),
                currentCalendar.get(Calendar.SECOND), currentCalendar.get(Calendar.DAY_OF_MONTH),
                currentCalendar.get(Calendar.MONTH) + 1, currentCalendar.get(Calendar.YEAR));
        return timeNow;
    }
}
