package com.doctorhere.base.appointment.enums;

public enum EnumAppointmentType {
    VIDEO("Video Görüşmesi"),
    VOICE("Sesli Görüşme"),
    CHAT("Yazışarak Görüşme");

    private final String label;

    EnumAppointmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return name();
    }
}
