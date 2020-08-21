package com.project.GatingModule.enums;

public enum ElementType {
    STRING_CONSTANT {
        public String toString() {
            return "STRING_CONSTANT";
        }
    },
    DOUBLE_CONSTANT {
        public String toString() {
            return "DOUBLE_CONSTANT";
        }
    },
    INTEGER_CONSTANT {
        public String toString() {
            return "INTEGER_CONSTANT";
        }
    },
    USER_LOOKUP {
        public String toString() {
            return "USER_LOOKUP";
        }
    },
    OPERATOR {
        public String toString() {
            return "OPERATOR";
        }
    },
    SEPARATOR {
        public String toString() {
            return "SEPARATOR";
        }
    },
    BOOLEAN_CONSTANT {
        public String toString() { return "BOOLEAN_CONSTANT";}
    },
    UNKNOWN {
        public String toString() { return "UNKNOWN"; }
    };
}
