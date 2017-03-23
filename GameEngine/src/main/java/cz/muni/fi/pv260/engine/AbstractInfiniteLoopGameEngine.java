package cz.muni.fi.pv260.engine;

public abstract class AbstractInfiniteLoopGameEngine implements InfiniteLoopGameEngine {

    private static final int DEFAULT_SLEEP_TIME = 20;

    private FrameTimer frameTimer = new InfiniteLoopFrameTimer(DEFAULT_SLEEP_TIME);

    @Override
    public void run() {
        init();
        startGame();
    }

    @Override
    public void init() {
    }

    @Override
    public boolean isRunning() {
        return frameTimer.isRunning();
    }

    @Override
    public void stop() {
        frameTimer.stopTimer();
    }

    @Override
    public void onLoopStart() {
    }

    @Override
    public void onLoopEnd() {
    }

    private void startGame() {
        frameTimer.startTimer();
    }

    private class InfiniteLoopFrameTimer extends FrameTimerImpl {

        public InfiniteLoopFrameTimer(int sleepTime) {
            super(sleepTime);
        }

        @Override
        public void renderFrame() {
            onLoopStart();
            update();
            onLoopEnd();
        }
    }

}
