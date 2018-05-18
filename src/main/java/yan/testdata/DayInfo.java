package yan.testdata;

public class DayInfo {
    public String nameDay;
    public String temperature;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayInfo dayInfo = (DayInfo) o;

        if (nameDay != null ? !nameDay.equals(dayInfo.nameDay) : dayInfo.nameDay != null) return false;
        return temperature != null ? temperature.equals(dayInfo.temperature) : dayInfo.temperature == null;
    }

//    @Override
//    public int hashCode() {
//        int result = nameDay != null ? nameDay.hashCode() : 0;
//        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
//        return result;
//    }
}
