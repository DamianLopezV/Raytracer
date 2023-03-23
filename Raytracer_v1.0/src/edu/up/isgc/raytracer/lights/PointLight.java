package edu.up.isgc.raytracer.lights;

import edu.up.isgc.raytracer.Intersection;
import edu.up.isgc.raytracer.Vector3D;
import edu.up.isgc.raytracer.objects.Material;

import java.awt.*;

/**
 * @author Jafet Rodríguez
 * @author Damián López
 */
public class PointLight extends Light{
    public PointLight(Vector3D position, Color color, double intensity, Material material){
        super(position, color, intensity, material);
    }

    @Override
    public float getNDotL(Intersection intersection) {
        Vector3D direction = Vector3D.substract(intersection.getPosition(), this.getPosition());
        return (float)Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.normalize(Vector3D.scalarMultiplication(direction, -1.0))), 0.0);
    }
}
