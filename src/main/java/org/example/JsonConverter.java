package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonConverter {

    public static String toJson(Guest guest, Reservation reservation) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new CombinedGuestReservation(guest, reservation));
    }

    private static class CombinedGuestReservation {
        private Guest guest;
        private Reservation reservation;

        public CombinedGuestReservation(Guest guest, Reservation reservation) {
            this.guest = guest;
            this.reservation = reservation;
        }

        public Guest getGuest() {
            return guest;
        }

        public void setGuest(Guest guest) {
            this.guest = guest;
        }

        public Reservation getReservation() {
            return reservation;
        }

        public void setReservation(Reservation reservation) {
            this.reservation = reservation;
        }
    }
}


