package cz.muni.fi.pv260.engine;

/**
 * Interface representing the implementation of the
 * {@link GameEngine} backed by the infinite loop.
 */
public interface InfiniteLoopGameEngine extends GameEngine {

    /**
     * This method is called as the first thing after
     * entering the loop.
     */
    void onLoopStart();

    /**
     * This method is called as the last thing after
     * when exiting the loop.
     */
    void onLoopEnd();
}
