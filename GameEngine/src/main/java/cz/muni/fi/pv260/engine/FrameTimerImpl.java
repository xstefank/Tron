package cz.muni.fi.pv260.engine;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public abstract class FrameTimerImpl implements FrameTimer {

    private int sleepTime;
    private boolean running;

    public FrameTimerImpl(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void startTimer() {
        running = true;
        timeFrame();
    }

    @Override
    public void stopTimer() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    private void timeFrame() {
        while (running) {

            renderFrame();

            try {
                Thread.sleep(sleepTime);
            } catch (Exception ex) {
                throw new IllegalThreadStateException("Error timing frame " + ex.getCause());
            }
        }
    }
}
