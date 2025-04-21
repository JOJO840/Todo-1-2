package org.lexicon.dao.sequencer;

public class TodoItemSequencer {
    private static int currentId = 0;

    public static int nextId(){
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemSequencer.currentId = currentId;
    }
}
