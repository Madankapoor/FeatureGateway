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
    OPERAND {
        public String toString() {
            return "OPERAND";
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
    UNKNOWN {
        public String toString() {
            return "UNKNOWN";
        }
    };
}
