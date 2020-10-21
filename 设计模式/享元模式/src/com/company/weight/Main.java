package com.company.weight;

public class Main {

    public static void main(String[] args) {

        Ticket ticket = TicketFactory.queryTicket("广州南", "虎门");
        ticket.showInfo("一等座");
    }
}
