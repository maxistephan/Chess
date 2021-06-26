package de.hsa.maxist.chess.engine.ui.swing;

import de.hsa.maxist.chess.engine.ui.Window;

import javax.swing.*;

public class SwingWindow implements Window {

    private final JPanel panel;

    public SwingWindow(SwingUi panel) {
        this.panel = panel;
    }

    @Override
    public void show() {

    }

}
