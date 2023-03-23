package edu.up.isgc.raytracer.objects;

/**
 * @author Damián López
 */
public class Material {
    private double shininess;
    private double ambientLight;
    private double reflect;
    private double refract;

    public Material(double shininess, double ambientLight, double reflect, double refract) {
        setShininess(shininess);
        setAmbientLight(ambientLight);
        setReflect(reflect);
        setRefract(refract);
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public double getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(double ambientLight) {
        this.ambientLight = ambientLight;
    }

    public double getReflect() {
        return reflect;
    }

    public void setReflect(double reflect) {
        this.reflect = reflect;
    }

    public double getRefract() {
        return refract;
    }

    public void setRefract(double refract) {
        this.refract = refract;
    }
}
