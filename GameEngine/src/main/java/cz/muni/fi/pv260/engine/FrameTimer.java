package cz.muni.fi.pv260.engine;

/**
 * Timing for the frame rendering
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface FrameTimer {

    /**
     * Starts the timer. Should not effect already started timer.
     */
    void startTimer();


    /**
     * Stops the timer. Should not effect already stopped timer.
     */
    void stopTimer();

    /**
     * Returns whether the timer is currently running
     * @return true if timer is running, false otherwise
     */
    boolean isRunning();

    /**
     * User defined actions to be performed to render frame image.
     */
    void renderFrame();
}
