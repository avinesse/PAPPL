/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pappl;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import java.util.ArrayList;
import junit.framework.TestCase;
import java.lang.Math.*;

/**
 *
 * @author Anouk
 */
public class ShadowTest extends TestCase {
    
    public ShadowTest(String testName) {
        super(testName);
    }

    /**
     * Test of calculateDirection method, of class Shadow.
     * Problèmes d'arrondis
     */
    public void testCalculateDirection() {
        System.out.println("calculateDirection");
        Shadow instance = new Shadow(0,0);
        Coordinate direction1 = new Coordinate(0,1);
        Coordinate direction2 = new Coordinate(Math.cos(Math.PI/4),Math.cos(Math.PI/4));
        assertEquals(direction1.x, instance.calculateDirection((Math.PI)/4,(Math.PI)/2).x,0.000001);
        assertEquals(direction1.y, instance.calculateDirection((Math.PI)/4,(Math.PI)/2).y,0.000001);
        assertEquals(direction2.x, instance.calculateDirection((Math.PI)/4,(Math.PI)/4).x,0.000001);
        assertEquals(direction2.y, instance.calculateDirection((Math.PI)/4,(Math.PI)/4).y,0.000001);

    }

    /**
     * Test of projection method, of class Shadow.
     */
    public void testProjection() {
        System.out.println("projection");
        Coordinate c =new Coordinate(0,0);
        double h =1;
        Coordinate direction = new Coordinate(1,1);
        Shadow instance = null;
        Coordinate expResult = new Coordinate(1,1);
        Coordinate result = instance.projection(c, h, direction);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createShadow method, of class Shadow.
     */
    public void testCreateShadow() {
        System.out.println("createShadow");
        Cube cube=new Cube();
        Shadow shadow = new Shadow(0.0738274274,0.84002696898487);
        Polygon base;
        Coordinate origine = new Coordinate (0,0);
        base = cube.construireBase(origine,1);
        double height = 1;
        Coordinate direction = new Coordinate(0.5,0);
        Polygon result;
        Coordinate origineExpResult= new Coordinate(-1,0);
        result = shadow.createShadow(base, height, direction); //pb à résoudre dans la création des coordonnées de createShadow
        Polygon expResult;
        expResult = cube.construireBase(origineExpResult,1);
        assertEquals(expResult,result);
    }
    
}
