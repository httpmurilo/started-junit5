import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patientintake.DateTimeConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DateTimeConverter should")
public class DateTimeConverterShould {

    @Test
    public void convertTodayStringCorrectly() {
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 1:00 pm",
                LocalDate.of(2018,9,1));
        assertEquals(result, LocalDateTime.of(2018,9,1,13,0));

    }

    @Test
    public void convertCorrectPatternToDateTime() {
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("9/2/2018 1:00 pm",
                LocalDate.of(2018,9,1));
        assertEquals(result, LocalDateTime.of(2018,9,2,13,0));

    }
}
