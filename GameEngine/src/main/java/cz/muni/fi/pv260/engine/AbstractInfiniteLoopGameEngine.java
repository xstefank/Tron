package cz.muni.fi.pv260.engine;

public abstract class AbstractInfiniteLoopGameEngine implements GameEngine {

    private static final int DEFAULT_FRAME_RATE = 50;

    private FrameTimer frameTimer;

    public AbstractInfiniteLoopGameEngine() {
        frameTimer = new InfiniteLoopFrameTimer(DEFAULT_FRAME_RATE);
    }

    public AbstractInfiniteLoopGameEngine(int frameRate) {
        this.frameTimer = new InfiniteLoopFrameTimer(frameRate);
    }

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
        if (isRunning()) {
            frameTimer.stopTimer();
        }
    }

    private void startGame() {
        if (!isRunning()) {
            frameTimer.startTimer();
        }
    }

    private class InfiniteLoopFrameTimer extends FrameTimerImpl {

        public InfiniteLoopFrameTimer(int frameRate) {
            super(1000 / frameRate);
        }

        @Override
        public void renderFrame() {
            update();
            redrawWindow();
        }
    }

}
