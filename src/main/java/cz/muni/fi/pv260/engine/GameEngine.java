package cz.muni.fi.pv260.engine;

public interface GameEngine {

    /**
     * Runs the game implementing the {@link GameEngine}.Should not
     * influence the executions when {@link GameEngine#isRunning()}
     * returns {@code true}.
     */
    void run();

    /**
     * Stops the game. Should not influence the executions when
     * {@link GameEngine#isRunning()} returns {@code false}
     */
    void stop();

    /**
     * Initial setup of the {@link GameEngine}.
     */
    void init();

    /**
     * Represents changes on the each frame update. Should be
     * called only when the {@link GameEngine#isRunning()} returns
     * {@code true}, otherwise the behaviour of this method is undefined.
     */
    void update();

    /**
     * Returns whether the game is running
     * @return {@code true} if the game is running, {@code false} otherwise
     */
    boolean isRunning();
}
