package com.project.GatingModule.enums;


public enum Separators {
    OPEN_ANGLE_BRACKET {
        public String toString() {
            return "(";
        }
    },
    CLOSE_ANGLE_BRACKET {
        public String toString() {
            return ")";
        }
    };
}
