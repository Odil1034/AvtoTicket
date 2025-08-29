package uz.pdp.AvtoTicket.enums.permission;

public enum Action {

    CREATE, READ, UPDATE, DELETE, LIST,
    APPROVE, RESET_PASSWORD; // maxsus actionlar

    public boolean isCrudOrList() {
        return this == CREATE || this == READ || this == UPDATE || this == DELETE || this == LIST;
    }
}
