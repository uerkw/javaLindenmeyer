package com.kuerkwitz.Lsystem.UI;

/**
 * @author Kyle Uerkwitz
 * Takes the position values and angle of a point to keep track of a vector
 * in 2D Space
 */
class LineVector {

    private final double posX;

    private final double posY;

    private final double angle;

    LineVector(double x, double y, double ang){
        this.posX = x;
        this.posY = y;
        this.angle = ang;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getAngle() {
        return angle;
    }
}
