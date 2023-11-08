package com.losnazar.university.strategy;

import com.losnazar.university.model.CommandPattern;

public interface CommandHandler {
    void handleCommand(String input);

    CommandPattern getPattern();
}
