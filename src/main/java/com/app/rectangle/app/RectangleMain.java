package com.app.rectangle.app;


import com.app.rectangle.model.Rectangle;
import com.app.rectangle.service.RectangleService;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Scanner;

public class RectangleMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        RectangleService rectangleService = new RectangleService();
        int option;
        while (true) {
            System.lineSeparator();
            System.lineSeparator();
            System.out.println("Rectangle Menu Choose one of the option\n");
            System.out.println("************************");
            System.out.println("1.) Two Rectangle Intersection Exists and Intersection Points\n");
            System.out.println("2.) Check Rectangle is contained in other Rectangle\n");
            System.out.println("3.) Check Rectangles are Adjacent\n");
            System.out.println("4.) Exit\n");
            System.out.println("************************");

            option = input.nextInt();

            switch (option) {
                case 1 -> {
                    ImmutablePair<Rectangle, Rectangle> inputFromUser = getInputFromUser(input);
                    if (inputFromUser.getLeft() == null || inputFromUser.getRight() == null) {
                        System.out.println("Please try again");
                        System.lineSeparator();
                    } else {
                        Rectangle r = rectangleService.checkAndGetIntersectionPoints(inputFromUser.getLeft(), inputFromUser.getRight());
                        if (r == null) {
                            System.out.println("Rectangles don't have intersection points");
                            System.lineSeparator();
                        } else {
                            System.out.println("Rectangle Intersection Points -" + " " + r.toString());
                            System.lineSeparator();
                        }
                    }
                }
                case 2 -> {
                    ImmutablePair<Rectangle, Rectangle> inputCoordinates = getInputFromUser(input);
                    if (inputCoordinates.getLeft() == null || inputCoordinates.getRight() == null) {
                        System.out.println("Please try again");
                        System.lineSeparator();
                    } else {
                        boolean ifRectangleContainmentExist = rectangleService.checkAndGetRectangleContainment(inputCoordinates.getLeft(), inputCoordinates.getRight());
                        if (!ifRectangleContainmentExist) {
                            System.out.println("One of the Rectangle is not fully Contained in other rectangle ");
                            System.lineSeparator();
                        }
                    }
                }
                case 3 -> {
                    ImmutablePair<Rectangle, Rectangle> inputCoordinatesPair = getInputFromUser(input);
                    if (inputCoordinatesPair.getLeft() == null || inputCoordinatesPair.getRight() == null) {
                        System.out.println("Please try again");
                        System.lineSeparator();
                    } else {
                        boolean AreRectangleIsAdjacent = rectangleService.isRectangleAdjacent(inputCoordinatesPair.getLeft(), inputCoordinatesPair.getRight());
                        if (AreRectangleIsAdjacent) {
                            System.out.println("Rectangles are adjacent");
                            System.lineSeparator();
                        } else {
                            System.out.println("Rectangles are not adjacent");
                            System.lineSeparator();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Exiting Menu ......");
                    System.exit(0);
                }
                default -> System.out.println("Not Valid option.. Please enter valid option");
            }
        }
    }


    public static Rectangle getRectanglePoints(String rectPoints) {
        String[] points = rectPoints.split(",");
        if (points.length != 4) {
            System.out.println("Number of arguments is more that 4, Please enter correct input(x,y,w,h) ");
            return null;
        }
        float x = convetToFloat(points[0]);
        if (Float.compare(x, 99999F) == 0) {
            return null;
        }
        float y = convetToFloat(points[1]);
        if (Float.compare(y, 99999F) == 0) {
            return null;
        }
        float width = convetToFloat(points[2]);
        if (Float.compare(width, 99999F) == 0) {
            return null;
        }
        float height = convetToFloat(points[3]);
        if (Float.compare(height, 99999F) == 0) {
            return null;
        }
        return new Rectangle(x, y, height, width);
    }

    public static float convetToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid point passed");
            return 99999F;
        }
    }

    public static ImmutablePair<Rectangle, Rectangle> getInputFromUser(Scanner input) {
        System.out.println("Please Enter the Rectangle 1 Point(x,y,w,h) separated by comma like(2.0,3.1,4.0,5)  : ");
        String rect1Points = input.next();
        System.out.println("Please Enter the Rectangle 2 Point(x,y,w,h) separated by comma like(2.0,3.1,4.0,5)  : ");
        String rect2Points = input.next();
        Rectangle r1 = getRectanglePoints(rect1Points);
        Rectangle r2 = getRectanglePoints(rect2Points);
        if (r1 == null || r2 == null) {
            System.out.println("Please try with valid cor-ordinates");
        }
        return ImmutablePair.of(r1, r2);
    }
}
