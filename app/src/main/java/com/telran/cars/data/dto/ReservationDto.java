package com.telran.cars.data.dto;

public class ReservationDto {
    private String end_date_time;
    private PersonWhoBookedDto person_who_booked;
    private String start_date_time;

    public ReservationDto(String end_date_time, PersonWhoBookedDto person_who_booked, String start_date_time) {
        this.end_date_time = end_date_time;
        this.person_who_booked = person_who_booked;
        this.start_date_time = start_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }

    public PersonWhoBookedDto getPerson_who_booked() {
        return person_who_booked;
    }

    public void setPerson_who_booked(PersonWhoBookedDto person_who_booked) {
        this.person_who_booked = person_who_booked;
    }

    public String getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(String start_date_time) {
        this.start_date_time = start_date_time;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "end_date_time='" + end_date_time + '\'' +
                ", person_who_booked=" + person_who_booked +
                ", start_date_time='" + start_date_time + '\'' +
                '}';
    }
}
