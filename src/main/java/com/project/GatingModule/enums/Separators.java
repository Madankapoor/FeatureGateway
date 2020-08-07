package com.project.GatingModule.enums;


public enum Separators {
    OPEN_ANGLE_BRACKET {
        public String toString() {
            return "(";
        }
        public boolean equals(String passedValue){
            return this.toString().equals(passedValue);
        }
    },
    CLOSE_ANGLE_BRACKET {
        public String toString() {
            return ")";
        }
        public boolean equals(String passedValue){
            return this.toString().equals(passedValue);
        }
    };
}
