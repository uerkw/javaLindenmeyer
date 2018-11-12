package com.kuerkwitz.Lsystem.UI;

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
