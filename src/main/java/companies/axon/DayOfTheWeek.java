package companies.axon;

public class DayOfTheWeek {


    public String dayOfTheWeek(int day,int month, int year) {

        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int num = 5;
        for(int i = 1971; i < year; i++){
            if(isLeapYear(i)) num += 366;
            else num += 365;
        }
        if(isLeapYear(year)) daysOfMonth[1]++;
        for(int i = 0; i < month-1; i++){
            num += daysOfMonth[i];
        }
        num += day-1; //To explain -1, we start from Jan 1 1971,
        // so we need to minus the first day. e.g: Jan 2 1971 is one day after Jan 1 1971 but not 2
        num %= 7;
        return days[num];
    }

    public boolean isLeapYear(int year ) {
        if( year % 4 == 0 ){
            if(year % 100 == 0 ) {

                if(year % 400 == 0 ) {
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
