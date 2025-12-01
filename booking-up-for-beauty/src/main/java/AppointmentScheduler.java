import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {

    private static final DateTimeFormatter DESCRIPTION_FORMAT = 
                DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a");

    public LocalDateTime schedule(String appointmentDateDescription) {
        String[] dateAndTime = appointmentDateDescription.split(" ");
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateAndTime[0], parser);
        return LocalDateTime.parse(date.toString()+"T"+dateAndTime[1]);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return 12 <= appointmentDate.getHour() && appointmentDate.getHour() <=17;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on "
            + appointmentDate.format(DESCRIPTION_FORMAT)
            + ".";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
