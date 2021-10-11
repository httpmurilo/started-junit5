import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import patientintake.ClinicCalendar;
import patientintake.Doctor;
import patientintake.PatientAppointment;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicaCalendarShould {

    private ClinicCalendar calendar;
    @BeforeEach
    void init() {
         calendar = new ClinicCalendar(LocalDate.of(2018,8,26));
    }
    @Test
    public void allowEntryOfAppointment() {
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
        List<PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        PatientAppointment enteredAppt = appointmentList.get(0);
        assertEquals("Jim", enteredAppt.getPatientFirstName());
        assertEquals("Weaver", enteredAppt.getPatientLastName());
        assertSame(Doctor.avery, enteredAppt.getDoctor());

    }

    @Test
    public void returnTrueForHasAppointmentsIfThereAreAppointments() {
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
        assertTrue(calendar.hasAppointment(LocalDate.of(2018,9,1)));
    }

    @Test
    public void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
        assertFalse(calendar.hasAppointment(LocalDate.of(2017,9,1)));
    }

    @Test
    public void returnCurrentDaysAppointments() {
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 3:00 pm");
        calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
        assertEquals(3, calendar.getAppointments().size());
    }

}
