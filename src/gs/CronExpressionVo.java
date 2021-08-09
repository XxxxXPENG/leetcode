package gs;


import java.util.Date;
import java.util.List;

public class CronExpressionVo {
    private String level;
    private Date date;
    private List<String> monthList;
    private List<String> dayList;
    private List<String> timeList;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<String> timeList) {
        this.timeList = timeList;
    }


    public static void main(String[] args) {
        String cronExpression = "0 0 12 * * ?";

    }
}
