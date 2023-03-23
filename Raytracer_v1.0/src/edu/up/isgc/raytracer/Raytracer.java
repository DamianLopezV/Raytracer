/**
 * [1968] - [2021] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package edu.up.isgc.raytracer;

import edu.up.isgc.raytracer.lights.DirectionalLight;
import edu.up.isgc.raytracer.lights.Light;
import edu.up.isgc.raytracer.lights.PointLight;
import edu.up.isgc.raytracer.objects.*;
import edu.up.isgc.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jafet Rodríguez
 * @author Damián López
 *
 *
 */
public class Raytracer {
    /**
     * Is used to build the scenes and run all the ray tracer
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Date());
        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 1200, 1200, 5f, 200f, null));

        //Lights
//        scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(0.0, 0.0, 1.0), Color.WHITE, 0.8, null));
//        scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(0.0, -0.1, 0.1), Color.WHITE, 0.2));
//        scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(-0.2, -0.1, 0.0), Color.WHITE, 0.2));
//        scene01.addLight(new PointLight(new Vector3D(-0.0,0.0,5.0),Color.white,8f, null));
//        scene01.addLight(new PointLight(new Vector3D(1.0,1.0,0.0),Color.white,5f, null));
        scene01.addLight(new PointLight(new Vector3D(2.0,1.0,0.0),Color.white,4f, null));
        scene01.addLight(new PointLight(new Vector3D(-2.0,1.0,0.0),Color.white,4f, null));

        //Materials
        Material metal = new Material(50, 0.05, 0, 1);
        Material polishedMetal = new Material(50, 0.05, 0.2, 1);
        Material mirror = new Material(50, 0.05, 1, 1);
        Material crystal = new Material(50, 0.05, 0, 1.5);
        Material water = new Material(20, 0.05, 0, 1.1);

        //Platform
        scene01.addObject(new Polygon(new Vector3D(0f, -2f, 50f), new Triangle[]{new Triangle(new Vector3D(60f,0f,60f), new Vector3D(-60f,0f,60f), new Vector3D(-60f,0f,-60f)),
                new Triangle(new Vector3D(-60f,0f,-60f), new Vector3D(60f,0f,-60f), new Vector3D(60f,0f,60f))}, Color.lightGray, mirror));
        scene01.addObject(new Polygon(new Vector3D(0f, -0f, 10f), new Triangle[]{new Triangle(new Vector3D(60f,60f,0f), new Vector3D(-60f,60f,0f), new Vector3D(-60f,-60f,0f)),
                new Triangle(new Vector3D(-60f,-60f,0f), new Vector3D(60f,-60f,0f), new Vector3D(60f,60f,0f))}, new Color(135,206,235), metal));

        //Scene01
        scene01.addObject(new Sphere(new Vector3D(-1.5f, -1f, -1f), 0.5f, Color.RED, crystal));
        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(1.5f, -1.5f, -2f), Color.WHITE, crystal));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-2f, -2.0f, 3f), Color.RED, metal));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(2f, -2.0f, 3f), Color.BLUE, metal));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(0f, -2.0f, 5f), Color.green, mirror));

        //Scene02
//        scene01.addObject(new Sphere(new Vector3D(0f, 1f, 7f), 2f, Color.RED,mirror));
//        scene01.addObject(new Sphere(new Vector3D(0.5f, 1f, 4.5f), 0.2f, Color.WHITE,metal));
//        scene01.addObject(new Sphere(new Vector3D(-0.5f, 1f, 4.5f), 0.2f, Color.white,metal));
//        scene01.addObject(new Sphere(new Vector3D(0f, 0.5f, 4.5f), 0.2f, Color.BLUE,metal));
//        scene01.addObject(new Sphere(new Vector3D(-2.6f, 1f, 4.5f), 0.3f, Color.PINK,metal));
//        scene01.addObject(new Sphere(new Vector3D(2.6f, 1f, 4.5f), 0.3f, Color.PINK,metal));
//        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(-1f, -2.5f, 1f), Color.GREEN,metal));
//        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(0f, -2.5f, 1f), Color.WHITE,metal));
//        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(1f, -2.5f, 1f), Color.RED,metal));
//        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(2f, -1.0f, 1.5f), Color.BLUE,metal));
//        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-2f, -1.0f, 1.5f), Color.GREEN,metal));
//        scene01.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(2f, -1.0f, 1.5f), Color.YELLOW,crystal));
//        scene01.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(-2f, -1.0f, 1.5f), Color.ORANGE,crystal));
//        scene01.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(-0.5f, 2.0f, 1.5f), Color.RED,metal));
//        scene01.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(0.5f, 2.0f, 1.5f), Color.GREEN,metal));

        //Scene03
//        scene01.addObject(OBJReader.GetPolygon("2B.obj", new Vector3D(0f, -8.0f, 20f), Color.white,metal));

        //Scene04
//        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-2f, -2.0f, 3f), Color.RED, metal));
//        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(0f, -2.0f, 5f), Color.GREEN, metal));
//        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(2f, -2.0f, 3f), Color.BLUE, metal));
//        scene01.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(0.0f, -2f, -2f), Color.BLUE, crystal));
//        scene01.addObject(new Sphere(new Vector3D(-1f, 0.0f, -1f), 0.5f, Color.RED, crystal));
//        scene01.addObject(new Sphere(new Vector3D(0.5f, 0.5f, 0f), 0.5f, Color.RED, crystal));
//        scene01.addObject(new Sphere(new Vector3D(-1.5f, -1f, -2f), 0.5f, Color.RED, crystal));
//        scene01.addObject(new Sphere(new Vector3D(1.5f, -0.5f, 1f), 0.5f, Color.RED, crystal));
//        scene01.addObject(new Sphere(new Vector3D(0.5f, -1.5f, 2f), 0.5f, Color.RED, crystal));


        //Scene05
//        scene01.addLight(new PointLight(new Vector3D(-2.0,1.0,0.6),Color.white,1f, null));
//        scene01.addLight(new PointLight(new Vector3D(2.0,1.0,0.6),Color.white,1f, null));
//        scene01.addLight(new PointLight(new Vector3D(0.0,-0.0,0.6),Color.white,1f, null));
//        scene01.addObject(OBJReader.GetPolygon("FishTank.obj", new Vector3D(0f, 0.0f, 2f), Color.cyan,water));
//        scene01.addObject(OBJReader.GetPolygon("Submarine.obj", new Vector3D(-0.0f, -0.7f, 7f), Color.yellow,metal));

        BufferedImage image = raytrace(scene01);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ioe) {
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    /**
     * Generates the image of the ray traces calculating all the pixels
     * @param scene
     * @return
     */
    public static BufferedImage raytrace(Scene scene) {
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = raycast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    pixelColor = Color.BLACK;
                    for (Light light : lights) {
                        pixelColor = addColor(pixelColor, Ambient(closestIntersection.getObject().getColor(), closestIntersection.getObject().getMaterial().getAmbientLight()));
                        pixelColor = addColor(pixelColor, Diffuse(light, closestIntersection, objects));
                    }
                    if (closestIntersection.getObject().getMaterial().getReflect() > 0){
                        pixelColor = Reflection(scene,2,closestIntersection,pixelColor,ray);
                    } else if (closestIntersection.getObject().getMaterial().getRefract() != 1){
                        pixelColor = Refraction(scene,2,closestIntersection,pixelColor,ray);
                    }
                    for (Light light : lights) {
                        if (closestIntersection.getObject().getMaterial().getShininess() > 0) {
                            pixelColor = addColor(pixelColor, Specular(light, closestIntersection, mainCamera, closestIntersection.getObject().getMaterial().getShininess()));
                        }
                    }
                }
                image.setRGB(i, j, pixelColor.getRGB());
            }
        }

        return image;
    }

    /**
     * Transforms a value if it's exceeding a minimum or a maximum
     * @param value
     * @param min The minimum value of your variable.
     * @param max The maximum value of your variable.
     * @return
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    /**
     * Adds each RGB value of two colors and returns the new color
     * @param original
     * @param otherColor
     * @return
     */
    public static Color addColor(Color original, Color otherColor){
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    /**
     * Evaluates a ray with each triangle or sphere that is in the arraylist of objects and is between the clipping planes
     * @param ray The ray that you are detecting collisions
     * @param objects List of objects to evaluate
     * @param caster The object where the ray is casted
     * @param clippingPlanes Planes where the objects will be rendered
     * @return
     */
    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }

    /**
     * Multiplies the ambient light with the color of the light and returns the color
     * @param objColor
     * @param ambientLight
     * @return
     */
    public static Color Ambient(Color objColor, double ambientLight){
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] *= ambientLight;
        }
        Color ambient = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
        return ambient;
    }

    /**
     * Calculates if the light is being obstructed and if not it multiplies the intensity and the color of the light with the color of the object
     * divided by the distance between the light and the intersection.
     * @param light
     * @param closestIntersection
     * @param objects
     * @return
     */
    public static Color Diffuse(Light light, Intersection closestIntersection, ArrayList<Object3D> objects){
        float nDotL = light.getNDotL(closestIntersection);
        float intensity = (float) light.getIntensity() * nDotL;
        double lightIntensity;
        if (light instanceof DirectionalLight){
            lightIntensity = intensity / (float) Math.pow(Vector3D.magnitude(((DirectionalLight) light).getDirection()), 2);
        } else {
            lightIntensity = intensity / (float) Math.pow(Vector3D.magnitude(Vector3D.substract(closestIntersection.getPosition(),light.getPosition())), 2);
        }
        Intersection lightIntersection = raycast(new Ray(closestIntersection.getPosition(),Vector3D.substract(light.getPosition(), closestIntersection.getPosition())), objects, closestIntersection.getObject(), null);
        if (lightIntersection != null) {
            if (lightIntersection.getObject() != closestIntersection.getObject() && lightIntersection.getDistance() < Vector3D.magnitude(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()))) {
                lightIntensity = 0;
            }
        }
            Color lightColor = light.getColor();
            Color objColor = closestIntersection.getObject().getColor();
            float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
            float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
            for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                objColors[colorIndex] *= lightIntensity * lightColors[colorIndex];
            }
        Color diffuse = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
        return diffuse;
    }

    /**
     * Calculates the color of the specular light with the Blinn-Phong reflection equations
     * @param light
     * @param closestIntersection
     * @param camera
     * @param shininess
     * @return
     */
    public static Color Specular(Light light, Intersection closestIntersection, Camera camera, double shininess){
        Vector3D V = Vector3D.normalize(Vector3D.substract(camera.getPosition(), closestIntersection.getPosition()));
        Vector3D L;
        if (light instanceof DirectionalLight){
            L = Vector3D.normalize(((DirectionalLight) light).getDirection());
        } else {
            L = Vector3D.normalize(Vector3D.substract(light.getPosition(), closestIntersection.getPosition()));
        }
        Vector3D N = Vector3D.normalize(closestIntersection.getNormal());
        Vector3D H = Vector3D.normalize(Vector3D.add(L, V));
        if (Vector3D.dotProduct(N,H) <= 0) {
            return Color.black;
        }
        double R = Math.pow(Vector3D.dotProduct(N,H), shininess) / (float) Math.pow(Vector3D.magnitude(Vector3D.substract(closestIntersection.getPosition(),light.getPosition())), 1);

        Color lightColor = light.getColor();
        Color objColor = Color.black;
        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
        float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] += R * lightColors[colorIndex];
        }
        Color specular = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
        return specular;
    }

    /**
     * Calculates the new direction of the ray and calculates everything again but with a new ray passing all the colors of the new intersection
     * @param scene
     * @param bounces How many times the ray can bounce between object before stopping
     * @param intersection Where the ray collided
     * @param color The current color that is generating
     * @param ray The previous ray
     * @return
     */
    public static Color Reflection(Scene scene, int bounces, Intersection intersection, Color color, Ray ray){
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        ArrayList<Object3D> objects = scene.getObjects();
        float cameraZ = (float) mainCamera.getPosition().getZ();
        double reflectIndex = intersection.getObject().getMaterial().getReflect();

        Vector3D reflectionVector = Vector3D.substract(ray.getDirection(),Vector3D.scalarMultiplication(intersection.getNormal(),2*Vector3D.dotProduct(intersection.getNormal(),ray.getDirection())));
        Ray reflectionRay = new Ray(intersection.getPosition(),reflectionVector);
        Intersection closestIntersection = raycast(reflectionRay, objects, intersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        Color pixelColor = Color.BLACK;
        if (closestIntersection != null) {
            double reflectIndexClosestIntersection = closestIntersection.getObject().getMaterial().getReflect();
            pixelColor = Color.BLACK;
            Color reflection = Color.BLACK;
            for (Light light : lights) {
                pixelColor = addColor(pixelColor, Ambient(closestIntersection.getObject().getColor(), closestIntersection.getObject().getMaterial().getAmbientLight()));
                pixelColor = addColor(pixelColor, Diffuse(light, closestIntersection, objects));
            }
            Color objColor = color;
            float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
            float[] reflectColors = new float[]{pixelColor.getRed() / 255.0f, pixelColor.getGreen() / 255.0f, pixelColor.getBlue() / 255.0f};
            for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                objColors[colorIndex] = (float) (reflectIndex * reflectColors[colorIndex] * (1 - reflectIndexClosestIntersection) + (1 - reflectIndex) * objColors[colorIndex]);
            }
            reflection = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
            if (closestIntersection.getObject().getMaterial().getRefract() != 1){
                reflection = Refraction(scene,bounces,closestIntersection,pixelColor,ray);
            }
            for (Light light : lights) {
                if (closestIntersection.getObject().getMaterial().getShininess() > 0 && bounces > 1) {
                    reflection = addColor(reflection, Specular(light, closestIntersection, mainCamera, closestIntersection.getObject().getMaterial().getShininess()));
                }
            }
            if (closestIntersection.getObject().getMaterial().getReflect() > 0 && bounces > 1){
                return Reflection(scene,bounces - 1,closestIntersection,reflection,reflectionRay);
            }
            return reflection;
        }
        float[] objColors = new float[]{color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f};
        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
            objColors[colorIndex] *= (float) (1 - reflectIndex);
        }
        pixelColor = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
        return pixelColor;
    }

    /**
     * Calculates the new direction of the ray and calculates everything again but with a new ray passing all the colors of the new intersection
     * @param scene
     * @param bounces If the refracted ray intersects with a reflective object it needed how many times it will bounce
     * @param intersection
     * @param color
     * @param ray
     * @return
     */
    public static Color Refraction(Scene scene, int bounces, Intersection intersection, Color color, Ray ray){
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        ArrayList<Object3D> objects = scene.getObjects();
        float cameraZ = (float) mainCamera.getPosition().getZ();

        double refractIndex = 1 / intersection.getObject().getMaterial().getRefract();
        double c1 = Vector3D.dotProduct(intersection.getNormal(),ray.getDirection());
        double c2 = Math.sqrt(1 - Math.pow(refractIndex,2) * (1 - Math.pow(c1,2)));

        Vector3D refractionVector = Vector3D.add(Vector3D.scalarMultiplication(ray.getDirection(),refractIndex),Vector3D.scalarMultiplication(intersection.getNormal(),refractIndex*c1 - c2));
        Ray refractionRay = new Ray(intersection.getPosition(),refractionVector);
        Intersection closestIntersection = raycast(refractionRay, objects, intersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
        Color pixelColor = Color.BLACK;
        if (closestIntersection != null) {
            pixelColor = Color.BLACK;
            double refractIndexClosestIntersection = closestIntersection.getObject().getMaterial().getRefract();
            for (Light light : lights) {
                pixelColor = addColor(pixelColor, Ambient(closestIntersection.getObject().getColor(), closestIntersection.getObject().getMaterial().getAmbientLight()));
                pixelColor = addColor(pixelColor, Diffuse(light, closestIntersection, objects));
            }
            if (closestIntersection.getObject().getMaterial().getReflect() > 0 && bounces > 0){
                pixelColor = Reflection(scene,bounces,closestIntersection,pixelColor,ray);
            } else if (closestIntersection.getObject().getMaterial().getRefract() != 1){
                pixelColor = Refraction(scene,bounces,closestIntersection,pixelColor,ray);
            }
            Color objColor = color;
            float[] objColors = new float[]{objColor.getRed() / 255.0f, objColor.getGreen() / 255.0f, objColor.getBlue() / 255.0f};
            float[] refractColors = new float[]{pixelColor.getRed() / 255.0f, pixelColor.getGreen() / 255.0f, pixelColor.getBlue() / 255.0f};
            for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                objColors[colorIndex] = (float) (refractIndex * refractColors[colorIndex] * (1 - refractIndexClosestIntersection) + (1 - refractIndex) * objColors[colorIndex]);
            }
            for (Light light : lights) {
                if (closestIntersection.getObject().getMaterial().getShininess() > 0) {
                    pixelColor = addColor(pixelColor, Specular(light, closestIntersection, mainCamera, closestIntersection.getObject().getMaterial().getShininess()));
                }
            }
            return pixelColor;
        }
        return pixelColor;
    }
}
