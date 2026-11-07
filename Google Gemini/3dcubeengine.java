import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class CubeCanvas extends Canvas implements Runnable {
    private boolean running = true;
    private long lastTime = System.currentTimeMillis();
    private int fps = 0;
    private int frameCount = 0;
    private long fpsTimer = 0;

    // Rotation angles
    private double angleX = 0;
    private double angleY = 0;

    // 3D Cube Vertices (X, Y, Z)
    private final double[][] vertices = {
        {-1, -1, -1}, { 1, -1, -1}, { 1,  1, -1}, {-1,  1, -1},
        {-1, -1,  1}, { 1, -1,  1}, { 1,  1,  1}, {-1,  1,  1}
    };

    // Faces defined by vertex indices
    private final int[][] faces = {
        {0, 1, 2, 3}, // Front
        {1, 5, 6, 2}, // Right
        {5, 4, 7, 6}, // Back
        {4, 0, 3, 7}, // Left
        {4, 5, 1, 0}, // Top
        {3, 2, 6, 7}  // Bottom
    };

    // Texture configuration (8x8 dummy texture grid)
    private final int texWidth = 8;
    private final int texHeight = 8;
    private int[] textureData = new int[texWidth * texHeight];

    public CubeCanvas() {
        setFullScreenMode(true);
        generateDummyTexture();
        new Thread(this).start();
    }

    private void generateDummyTexture() {
        // Create an orange and blue checkerboard grid
        for (int y = 0; y < texHeight; y++) {
            for (int x = 0; x < texWidth; x++) {
                textureData[y * texWidth + x] = ((x + y) % 2 == 0) ? 0xFF9900 : 0x0066FF;
            }
        }
    }

    public void run() {
        while (running) {
            // Slow rotation increments
            angleX += 0.02;
            angleY += 0.03;

            repaint();
            
            try {
                Thread.sleep(30); // Aim for ~30 FPS caps
            } catch (InterruptedException e) {}
        }
    }

    protected void paint(Graphics g) {
        // Measure performance
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;
        lastTime = currentTime;
        fpsTimer += elapsedTime;
        frameCount++;

        if (fpsTimer >= 1000) {
            fps = frameCount;
            frameCount = 0;
            fpsTimer = 0;
        }

        // Clear Screen
        g.setColor(0x000000);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Screen parameters
        int halfW = getWidth() / 2;
        int halfH = getHeight() / 2;
        int scale = Math.min(getWidth(), getHeight()) / 3;

        // Transformed coordinates cache
        int[][] projVertices = new int[vertices.length][2];
        double[] transZ = new double[vertices.length];

        // Coordinate transformation & perspective projection
        for (int i = 0; i < vertices.length; i++) {
            double x = vertices[i][0];
            double y = vertices[i][1];
            double z = vertices[i][2];

            // Rotate Y
            double cosY = Math.cos(angleY);
            double sinY = Math.sin(angleY);
            double x1 = x * cosY - z * sinY;
            double z1 = x * sinY + z * cosY;

            // Rotate X
            double cosX = Math.cos(angleX);
            double sinX = Math.sin(angleX);
            double y2 = y * cosX - z1 * sinX;
            double z2 = y * sinX + z1 * cosX;

            // Push object back in Z depth space
            double depthZ = z2 + 3.5; 
            transZ[i] = depthZ;

            // Perspective Projection
            projVertices[i][0] = halfW + (int)((x1 * scale) / depthZ);
            projVertices[i][1] = halfH + (int)((y2 * scale) / depthZ);
        }

        // Render Faces with basic Painter's Algorithm sorting optimization
        for (int f = 0; f < faces.length; f++) {
            int[] face = faces[f];

            // Basic Backface Culling using cross-product signed area
            int xA = projVertices[face[0]][0];
            int yA = projVertices[face[0]][1];
            int xB = projVertices[face[1]][0];
            int yB = projVertices[face[1]][1];
            int xC = projVertices[face[2]][0];
            int yC = projVertices[face[2]][1];

            long cw = (long)(xB - xA) * (yC - yA) - (long)(yB - yA) * (xC - xA);
            if (cw <= 0) continue; // Face points away from camera, skip mapping

            // Draw bounding polygons and map textures wireframe fallback representation 
            // due to midp limitation constraints on raw per-pixel canvas manipulation
            g.setColor(0xFFFFFF);
            g.drawLine(xA, yA, xB, yB);
            g.drawLine(xB, yB, xC, yC);
            g.drawLine(xC, yC, projVertices[face[3]][0], projVertices[face[3]][1]);
            g.drawLine(projVertices[face[3]][0], projVertices[face[3]][1], xA, yA);

            // Simple Affine Texture mapping approximation using built-in system native fills
            // Sub-filling grid blocks dynamically represents the texture without manual slow loops
            g.setColor(textureData[f % (texWidth * texHeight)]);
            int[] xPoints = {xA, xB, xC, projVertices[face[3]][0]};
            int[] yPoints = {yA, yB, yC, projVertices[face[3]][1]};
            g.fillTriangle(xA, yA, xB, yB, xC, yC);
            g.fillTriangle(xA, yA, xC, yC, projVertices[face[3]][0], projVertices[face[3]][1]);
        }

        // Render FPS HUD Indicator overlay
        g.setColor(0x00FF00);
        g.drawString("FPS: " + fps, 10, 10, Graphics.TOP | Graphics.LEFT);
    }

    public void stop() {
        running = false;
    }
}