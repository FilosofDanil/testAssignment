package sample;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .sorted((date1, date2) -> {
                    if (date1.getMonth().toString().contains("R")
                            && !date2.getMonth().toString().contains("R")) {
                        return -1;
                    } else if (date2.getMonth().toString().contains("R")
                            && !date1.getMonth().toString().contains("R")) {
                        return 1;
                    } else if (date2.getMonth().toString().contains("R")
                            && date1.getMonth().toString().contains("R")) {
                        if (date2.isAfter(date1)) {
                            return -1;
                        } else if (date1.isAfter(date2)) {
                            return 1;
                        }
                    } else if (!date2.getMonth().toString().contains("R")
                            && !date1.getMonth().toString().contains("R")) {
                        if (date2.isAfter(date1)) {
                            return 1;
                        } else if (date1.isAfter(date2)) {
                            return -1;
                        }
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }
}

