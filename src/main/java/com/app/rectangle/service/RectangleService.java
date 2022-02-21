package com.app.rectangle.service;

import com.app.rectangle.model.Rectangle;

public class RectangleService {
    public Rectangle checkAndGetIntersectionPoints(Rectangle rect1, Rectangle rect2) {
        float x1 = rect1.getxCoordinates();
        float y1 = rect1.getyCooridnates();
        float width1 = rect1.getWidth();
        float height1 = rect1.getHeight();
        float x3 = rect2.getxCoordinates();
        float y3 = rect2.getyCooridnates();
        float width2 = rect2.getWidth();
        float height2 = rect2.getHeight();
        float x2 = x1 + width1;
        float y2 = y1 - height1;
        float x4 = x3 + width2;
        float y4 = y3 - height2;
        float minWidth = Math.min(x2, x4);
        float maxXCord = Math.max(x1, x3);
        if (Float.compare(minWidth, maxXCord) < 0) {
            return null;
        }
        float maxYCordinate = Math.max(y2, y4);
        float minY = Math.min(y1, y3);
        if (Float.compare(minY, maxYCordinate) < 0) {
            return null;
        }
        return new Rectangle(maxXCord, minY, minWidth - maxXCord, minY - maxYCordinate);
    }

    public boolean checkAndGetRectangleContainment(Rectangle r1, Rectangle r2) {
        float x1 = r1.getxCoordinates();
        float y1 = r1.getyCooridnates();
        float width1 = r1.getWidth();
        float x3 = r2.getxCoordinates();
        float y3 = r2.getyCooridnates();
        float width2 = r2.getWidth();
        float x2 = x1 + width1;
        float x4 = x3 + width2;
        float maxXCoridnate = Math.max(x1, x3);
        float minXCorordinate = Math.min(x2, x4);
        if (Float.compare(maxXCoridnate, x1) == 0 && Float.compare(minXCorordinate, x2) == 0 && Float.compare(y1, y3) < 0) {
            System.out.println("Rectangle 1 is fully contained inside Rectangle 2");
            return true;
        } else if (Float.compare(maxXCoridnate, x3) == 0 && Float.compare(minXCorordinate, x4) == 0 && Float.compare(y3, y1) < 0) {
            System.out.println("Rectangle 2 is fully contained inside Rectangle 1");
            return true;
        } else {
            return false;
        }
    }

    public boolean isRectangleAdjacent(Rectangle r1, Rectangle r2) {
        if (leftAndRightSideAdjacent(r1, r2)) {
            return true;
        } else if (checkifDownAdjacency(r1, r2)) {
            return true;
        } else return checkifTopAdjacency(r1, r2);
    }

    public boolean leftAndRightSideAdjacent(Rectangle r1, Rectangle r2) {
        float x1 = r1.getxCoordinates();
        float x2 = x1 + r1.getWidth();
        float x3 = r2.getxCoordinates();
        float x4 = x3 + r2.getWidth();
        float y1 = r1.getyCooridnates() - r1.getHeight();
        float y2 = r1.getyCooridnates();
        float y3 = r2.getyCooridnates() - r2.getHeight();
        float y4 = r2.getyCooridnates();
        //r2 on right and r1 on left side
        if (Float.compare(x2, x3) == 0 && Float.compare(y2, y3) >= 0 && Float.compare(y1, y3) <= 0) {
            return true;
        }
        //r2 on left and r1 on right side
        else return Float.compare(x4, x1) == 0 && Float.compare(y4, y1) >= 0 && Float.compare(y3, y1) <= 0;
    }

    public boolean checkifDownAdjacency(Rectangle r1, Rectangle r2) {
        float x1 = r1.getxCoordinates();
        float x2 = x1 + r1.getWidth();
        float x3 = r2.getxCoordinates();
        float x4 = x3 + r2.getWidth();
        float y1 = r1.getyCooridnates() - r1.getHeight();
        float y2 = r1.getyCooridnates();
        float y3 = r2.getyCooridnates() + r2.getHeight();
        float y4 = r2.getyCooridnates();
        float max = Math.max(x1, x3);
        float min = Math.min(x2, x4);
        float y12 = r1.getyCooridnates() + r1.getHeight();
        float y21 = r2.getyCooridnates() - r2.getHeight();
        //if r1 is on top, r2 down
        if (Float.compare(y1, y3) == 0 && Float.compare(y1, y4) > 0 && (Float.compare(x1, x3) == 0 || Float.compare(min, max) >= 0)) {
            return true;
            //if r2 on top, r1 down
        } else
            return Float.compare(y12, y21) == 0 && Float.compare(y21, y2) > 0 && (Float.compare(x1, x3) == 0 || Float.compare(min, max) >= 0);
    }

    public boolean checkifTopAdjacency(Rectangle r1, Rectangle r2) {
        float x1 = r1.getxCoordinates();
        float x2 = x1 + r1.getWidth();
        float x3 = r2.getxCoordinates();
        float x4 = x3 + r2.getWidth();
        float y1 = r1.getyCooridnates() - r1.getHeight();
        float y2 = r1.getyCooridnates();
        float y3 = r2.getyCooridnates() - r2.getHeight();
        float y4 = r2.getyCooridnates();
        float max = Math.max(x1, x3);
        float min = Math.min(x2, x4);
        //if r1 is down
        if ((Float.compare(y2, y3) == 0 && Float.compare(y4, y2) > 0) && (Float.compare(x1, x3) == 0 || Float.compare(min, max) >= 0)) {
            return true;
            //if r2 on down
        } else
            return (Float.compare(y4, y1) == 0 && Float.compare(y2, y4) > 0) && (Float.compare(x1, x3) == 0 || Float.compare(min, max) >= 0);
    }
}
