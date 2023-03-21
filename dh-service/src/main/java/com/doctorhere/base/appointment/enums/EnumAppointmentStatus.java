package com.doctorhere.base.appointment.enums;

public enum EnumAppointmentStatus {
    WAITING_APPROVED("Onay Bekliyor"),
    APPROVED("Onaylandı"),
    CANCELED("İptal Edildi");

    private final String label;

    EnumAppointmentStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return name();
    }
}
