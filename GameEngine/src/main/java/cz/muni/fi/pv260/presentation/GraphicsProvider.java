package cz.muni.fi.pv260.presentation;

import java.awt.Graphics;

/**
 * Provider for the {@link java.awt.Graphics} objects
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface GraphicsProvider {

    /**
     * Returns the {@link Graphics} object
     * for the associated system
     * @return the {@link Graphics} for this system
     */
    Graphics getGraphics();
}
