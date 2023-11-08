package com.losnazar.university.model;

import lombok.Getter;

@Getter
public enum CommandPattern {
        EMPLOYEE_COUNT("Show count of employee for \\w+"),
        GLOBAL_SEARCH("Global search by \\w+"),
        DEPARTMENT_HEAD("Who is head of department \\w+"),
        SALARY("Show the average salary for the department \\w+"),
        STATISTIC("Show \\w+ statistic");

        private final String value;

        CommandPattern(String value) {
            this.value = value;
        }
}