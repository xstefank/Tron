package cz.muni.fi.pv260.control.controller.keyboard.controller;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class DirectionKeySet {

    private int upKeyCode;
    private int downKeyCode;
    private int leftKeyCode;
    private int rightKeyCode;

    public DirectionKeySet(int upKeyCode, int downKeyCode, int leftKeyCode, int rightKeyCode) {
        this.upKeyCode = upKeyCode;
        this.downKeyCode = downKeyCode;
        this.leftKeyCode = leftKeyCode;
        this.rightKeyCode = rightKeyCode;
    }


    public int getUpKeyCode() {
        return upKeyCode;
    }

    public void setUpKeyCode(int upKeyCode) {
        this.upKeyCode = upKeyCode;
    }

    public int getDownKeyCode() {
        return downKeyCode;
    }

    public void setDownKeyCode(int downKeyCode) {
        this.downKeyCode = downKeyCode;
    }

    public int getLeftKeyCode() {
        return leftKeyCode;
    }

    public void setLeftKeyCode(int leftKeyCode) {
        this.leftKeyCode = leftKeyCode;
    }

    public int getRightKeyCode() {
        return rightKeyCode;
    }

    public void setRightKeyCode(int rightKeyCode) {
        this.rightKeyCode = rightKeyCode;
    }
}
