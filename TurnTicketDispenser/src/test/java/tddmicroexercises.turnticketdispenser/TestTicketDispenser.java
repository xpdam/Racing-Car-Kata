package tddmicroexercises.turnticketdispenser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicketDispenser {
    @Test
    public void firstTicketShouldBeZero() {
        TicketDispenser ticketDispenser = new TicketDispenser();
        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(0, turnTicket.getTurnNumber());
    }
}
