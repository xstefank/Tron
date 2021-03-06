package cz.muni.fi.pv260.presentation.awt;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferStrategy;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class AWTGraphicsProvider {

    private Window window;

    public AWTGraphicsProvider(Window window) {
        this.window = window;
    }

    public Graphics getGraphics() {
        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();
            while (bufferStrategy == null) {
                bufferStrategy = window.getBufferStrategy();
            }
            return bufferStrategy.getDrawGraphics();
        }
        return null;
    }
}
