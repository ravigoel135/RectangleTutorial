import com.app.rectangle.model.Rectangle;
import com.app.rectangle.service.RectangleService;
import org.junit.Assert;
import org.junit.Test;

public class RectangleServiceTest {


    private RectangleService rectangleServiceSubject = new RectangleService();

    @Test
    public void testRectanleIntersectionPointExist_Success() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(3.1F);
        r1.setHeight(4F);
        r1.setWidth(5.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(1.0F);
        r2.setyCooridnates(3.0F);
        r2.setHeight(4.1F);
        r2.setWidth(4.0F);
        Rectangle r = rectangleServiceSubject.checkAndGetIntersectionPoints(r1, r2);
        Assert.assertNotNull(r);
    }

    @Test
    public void testRectangleIntersectionPointNotExists() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(3.1F);
        r1.setHeight(4F);
        r1.setWidth(5.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(-1.0F);
        r2.setyCooridnates(9.0F);
        r2.setHeight(10.1F);
        r2.setWidth(2.0F);
        Rectangle r = rectangleServiceSubject.checkAndGetIntersectionPoints(r1, r2);
        Assert.assertNull(r);
    }

    @Test
    public void testRectangleContainmentNotExists() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(3.1F);
        r1.setHeight(4F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(3.0F);
        r2.setyCooridnates(5.0F);
        r2.setHeight(5.0F);
        r2.setWidth(4.0F);
        boolean containmentExists = rectangleServiceSubject.checkAndGetRectangleContainment(r1, r2);
        Assert.assertFalse(containmentExists);
    }

    @Test
    public void testRectangleContainmentExists() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(3.1F);
        r1.setHeight(4F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(3.0F);
        r2.setyCooridnates(2.0F);
        r2.setHeight(1.0F);
        r2.setWidth(1.0F);
        boolean containmentExists = rectangleServiceSubject.checkAndGetRectangleContainment(r1, r2);
        Assert.assertTrue(containmentExists);
    }

    @Test
    public void testRectangleAdjacentExistsOnRightR2() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(3.1F);
        r1.setHeight(4F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(5.0F);
        r2.setyCooridnates(2.0F);
        r2.setHeight(1.0F);
        r2.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentExistsOnLeftR2() {
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(2.0F);
        r2.setyCooridnates(3.1F);
        r2.setHeight(4F);
        r2.setWidth(3.0F);
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(5.0F);
        r1.setyCooridnates(2.0F);
        r1.setHeight(1.0F);
        r1.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentExistsR2Down() {
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(2.0F);
        r2.setyCooridnates(-5.0F);
        r2.setHeight(5.0F);
        r2.setWidth(3.0F);
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(5.0F);
        r1.setyCooridnates(5.0F);
        r1.setHeight(5.0F);
        r1.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentExistsR1Down() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(-5.0F);
        r1.setHeight(5.0F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(5.0F);
        r2.setyCooridnates(5.0F);
        r2.setHeight(5.0F);
        r2.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentNotExistsR2Down() {
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(2.0F);
        r2.setyCooridnates(-5.0F);
        r2.setHeight(-5.0F);
        r2.setWidth(3.0F);
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(5.0F);
        r1.setyCooridnates(5.0F);
        r1.setHeight(5.0F);
        r1.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertFalse(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentNotExistsR1Down() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(2.0F);
        r1.setyCooridnates(-5.0F);
        r1.setHeight(-5.0F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(5.0F);
        r2.setyCooridnates(10.0F);
        r2.setHeight(10.0F);
        r2.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertFalse(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentExistsR2Up() {
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(10.0F);
        r2.setyCooridnates(20.0F);
        r2.setHeight(10.0F);
        r2.setWidth(3.0F);
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(10.0F);
        r1.setyCooridnates(10.0F);
        r1.setHeight(5.0F);
        r1.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentExistsR1Up() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(10.0F);
        r1.setyCooridnates(20.0F);
        r1.setHeight(10.0F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(10.0F);
        r2.setyCooridnates(10.0F);
        r2.setHeight(5.0F);
        r2.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertTrue(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentR2UpNotExists() {
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(10.0F);
        r2.setyCooridnates(30.0F);
        r2.setHeight(10.0F);
        r2.setWidth(3.0F);
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(10.0F);
        r1.setyCooridnates(10.0F);
        r1.setHeight(5.0F);
        r1.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertFalse(AdjacentExists);
    }

    @Test
    public void testRectangleAdjacentR1UpNotExists() {
        Rectangle r1 = new Rectangle();
        r1.setxCoordinates(10.0F);
        r1.setyCooridnates(40.0F);
        r1.setHeight(10.0F);
        r1.setWidth(3.0F);
        Rectangle r2 = new Rectangle();
        r2.setxCoordinates(10.0F);
        r2.setyCooridnates(10.0F);
        r2.setHeight(5.0F);
        r2.setWidth(1.0F);
        boolean AdjacentExists = rectangleServiceSubject.isRectangleAdjacent(r1, r2);
        Assert.assertFalse(AdjacentExists);
    }
}
