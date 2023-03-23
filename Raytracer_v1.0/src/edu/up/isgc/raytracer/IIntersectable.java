/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer;

/**
 * @author Jafet Rodríguez
 * @author Damián López
 */
public interface IIntersectable {
    public abstract Intersection getIntersection(Ray ray);
}
