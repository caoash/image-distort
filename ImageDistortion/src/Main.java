/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Caoas
 */
public class Main extends javax.swing.JFrame {
    static ArrayList<Point> vertices, vertices2, grid; static boolean dragPoint, addMode, drawHull, deleteMode, showHeat, precomped, polygonSwitch, drawTwo, drawGrid; static Point touch; static BufferedImage buf; static Heatmap h; static int ind;
    static int xDem, yDem; static Point q;

    /**
     * Creates new form MainFrame
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {     public void paint(Graphics g)     {         super.paint(g);         ourCustomPaintingMethod(g);     } };
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Add Vertices");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Move Vertices");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete Vertices");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Show Heatmap");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Precompute");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Create Grid");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Search for Image");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       addMode = true;
       repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addMode = false;
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteMode = !deleteMode;
        repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showHeat = !showHeat;
        repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          h = new Heatmap(vertices, xDem, yDem);
          h.init();
          for(int i = 0; i < xDem; i+=20){
            for(int j = 0; j < yDem; j+=20){
                grid.add(new Point(i,j));
            }
        }
         if(!precomped) {
          precomped = true;
        }
       repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        drawGrid = !drawGrid;
        repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        if(addMode) {
                            if (drawTwo) {
                                vertices2.add(evt.getPoint());
                            } else {
                                vertices.add(evt.getPoint());
                            }
                        }
                        else{
                            touch = touchingPoint(evt.getPoint());
                            if(touch == null){
                                touch = touchingPoint2(evt.getPoint());
                                System.out.println("Please select a valid point.");
                            }
                            else {
                                dragPoint = true;
                                if(deleteMode){
                                    for(int i = 0; i < vertices.size(); i++){
                                        Point p = vertices.get(i);
                                        if(p.x == touch.x && p.y == touch.y){
                                            vertices.remove(i);
                                            break;
                                        }
                                    }
                                    repaint();
                                }
                            }
                        }
        repaint();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
                 if(dragPoint){
                            Point mouse = evt.getPoint();
                            for(int i = 0; i < vertices.size(); i++){
                                Point p = vertices.get(i);
                                if(p.x == touch.x && p.y == touch.y){
                                    vertices.remove(i); vertices.add(i, mouse);
                                    touch = mouse;
                                }
                            }
                            repaint();
                        }
        repaint();
    }//GEN-LAST:event_jPanel1MouseDragged
 public static ImageIcon ResizeImage(String ImagePath, JLabel label)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       JFileChooser file = new JFileChooser();
                                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                                file.addChoosableFileFilter(filter);
                                int result = file.showSaveDialog(null);
                                if(result == JFileChooser.APPROVE_OPTION) {
                                    File selectedFile = file.getSelectedFile();
                                    String path = selectedFile.getAbsolutePath();
                                    jLabel1.setIcon(ResizeImage(path, jLabel1));
                                }
                                else if(result == JFileChooser.CANCEL_OPTION){
                                    System.out.println("No File Selected");
                                }
                          repaint();
    }//GEN-LAST:event_jButton7ActionPerformed
    public void ourCustomPaintingMethod(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));   

        if(showHeat){
            double[][] w = h.getWeight(ind);
            for(int i = 0; i < xDem; i++){
                for(int j = 0; j < yDem; j++){
                    ArrayList<Double> c = getValues(w[i][j]);
//                    System.out.println(c.get(0) + " " + c.get(1) + " " + c.get(2));
                    int red = (int)Math.ceil(c.get(0)); int green = (int)Math.ceil(c.get(1)); int blue = (int)Math.ceil(c.get(2));
//                    red = Math.min(red, 255); green = Math.min(green, 255); blue = Math.min(blue, 255);
                    g2.setColor(new Color(red, green, blue));
                    g2.drawOval(i,j,1,1);
                }
            }
        }
        if(!vertices.isEmpty()) {
            Point prev = null;
            int numTraversed = 0;
            Point first = vertices.get(0);
            for (Point p : vertices) {
                g2.setColor(Color.BLACK);
//                    System.out.println("P: " + p.x + " " + p.y + " first: " + first.x + " " + first.y);
                if (numTraversed == vertices.size() - 1) { //if last point
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(p.x, p.y, first.x, first.y);
                }
                if (prev != null) {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(prev.x, prev.y, p.x, p.y);
                    prev = p;
                } else {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    prev = p;
                }
                numTraversed++;
            }
        }
        if(!vertices2.isEmpty()) {
            Point prev = null; int numTraversed = 0;
            Point first = vertices2.get(0);
            for (Point p : vertices2) {
                g2.setColor(Color.gray);
//                    System.out.println("P: " + p.x + " " + p.y + " first: " + first.x + " " + first.y);
                if (numTraversed == vertices2.size() - 1) { //if last point
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(p.x, p.y, first.x, first.y);
                }
                if (prev != null) {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(prev.x, prev.y, p.x, p.y);
                    prev = p;
                } else {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    prev = p;
                }
                numTraversed++;
            }
        }
        if(polygonSwitch) {
            Point prev = null;
            int numTraversed = 0; Point first = null;
           try {
               first = h.computeDeform(vertices2.get(0), vertices);
           }
           catch(NullPointerException e){
               System.out.println("You didn't precompute yet! Press R to precompute.");
           }
            for (Point p2 : vertices2) {
                Point p = null;
                try {
                     p = h.computeDeform(p2, vertices);
                }
                catch(NullPointerException e){
                    System.out.println("You didn't precompute yet! Press R to precompute.");
                    break;
                }
                g2.setColor(Color.GREEN);
//                    System.out.println("P: " + p.x + " " + p.y + " first: " + first.x + " " + first.y);
                if (numTraversed == vertices2.size() - 1) { //if last point
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(p.x, p.y, first.x, first.y);
                }
                if (prev != null) {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    g2.drawLine(prev.x, prev.y, p.x, p.y);
                    prev = p;
                } else {
                    g2.drawOval(p.x, p.y, 3, 3);
                    g2.fillOval(p.x, p.y, 3, 3);
                    prev = p;
                }
                numTraversed++;
            }
        }
        if(drawHull){
            ArrayList<Point> hulls = convexHull(vertices, vertices.size());
//                    for(int i = 0; i < hulls.size(); i++){
//                        System.out.println(hulls.get(i).x + " " + hulls.get(i).y + " " + vertices.get(i) + "  " + vertices.get(i).y);
//                    }
            int numTraversed = 0;
            Point first = hulls.get(0);
            Point prev = null;
            for(Point p : hulls){
                g2.setColor(Color.RED);
//                System.out.println("P: " + p.x + " " + p.y + " first: " + first.x + " " + first.y);
                if(numTraversed == hulls.size()-1){ //if last point
                    g2.drawOval(p.x, p.y, 1, 1);
                    g2.fillOval(p.x, p.y, 1, 1);
                    g2.drawLine(p.x, p.y, first.x, first.y);
                }
                if (prev != null) {
                    g2.drawOval(p.x, p.y, 1, 1);
                    g2.fillOval(p.x, p.y, 1, 1);
                    g2.drawLine(prev.x, prev.y, p.x, p.y);
                    prev = p;
                } else {
                    g2.drawOval(p.x, p.y, 1, 1);
                    g2.fillOval(p.x, p.y, 1, 1);
                    prev = p;
                }
                numTraversed++;
            }
        }
        if(precomped) {
            g2.setColor(Color.RED);
            if(drawGrid){
                for(int i = 0; i < grid.size(); i++){
                    Point p = grid.get(i);
                    System.out.println(p.x + " " + p.y + " " + i);
                    Point def = h.computeDeform(p, vertices);
                    g2.setStroke(new BasicStroke(2));
                    g2.drawOval(def.x, def.y, 2, 2);
                    g2.fillOval(def.x, def.y, 2, 2);
                    g2.setStroke(new BasicStroke(1));
                    if(def.x <= -1 && def.y <= -1){
                        continue;
                    }
                    if((i+1) < grid.size() && (!(i % 25 == 24))){
                        Point leftAdj = h.computeDeform(grid.get(i+1), vertices);
                        if(leftAdj.x <= -1 && leftAdj.y <= -1){
                            continue;
                        }
                        g2.drawLine(def.x, def.y, leftAdj.x, leftAdj.y);
                      
                    }
//                    if((i + 25) < grid.size()){
//                        Point rightAdj = h.computeDeform(grid.get(i+25), vertices);
//                          if(rightAdj.x <= -1 && rightAdj.y <= -1){
//                            continue;
//                        }
//                        g2.drawLine(def.x, def.y, rightAdj.x, rightAdj.y);
//                        
//                    }
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        addMode = true; dragPoint = false; touch = null; vertices = new ArrayList<>(); drawHull = false; deleteMode = false; precomped = false; polygonSwitch = false;
        JFrame f = new JFrame("Draw a Polygon");
        f.requestFocus(); f.requestFocusInWindow();
        grid = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Dimensions?");
        xDem = sc.nextInt(); yDem = sc.nextInt();
        System.out.println("What Index?");
        ind = sc.nextInt();
        ind--;
        vertices2 = new ArrayList<>();
        q = new Point(200,200);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }  
    public static ArrayList<Double> getValues(double value){
        int NUM_COLORS = 4;
        int[][] color = { {0,0,1}, {0,1,0}, {1,1,0}, {1,0,0} };
        ArrayList<Double> ret = new ArrayList<>(); 
        int idx1; int idx2; double fractBetween = 0;
        if(value <= 0){
            idx1 = idx2 = 0;
        }
        else if(value >= 1)  {  idx1 = idx2 = NUM_COLORS-1; }
        else
        {
            value = value * (NUM_COLORS-1);
            idx1  = (int)Math.floor(value);
            idx2  = idx1+1;
            fractBetween = value - (double)idx1;
        }
        double red = (color[idx2][0] - color[idx1][0])*fractBetween + color[idx1][0];
        double green = (color[idx2][1] - color[idx1][1])*fractBetween + color[idx1][1];
        double blue  = (color[idx2][2] - color[idx1][2])*fractBetween + color[idx1][2];

        red *= 255; green *= 255; blue *= 255;
//        System.out.println(red + " " + green + " " + blue);
        ret.add(red); ret.add(green); ret.add(blue);
        return ret;
    }
    public static Point touchingPoint(Point p){
        for(Point x : vertices){
            if(Math.abs(x.x - p.x) <= 3 && Math.abs(x.x - p.x) <= 3){
                return new Point(x.x, x.y);
            }
        }

        return null;
    }
    public static Point touchingPoint2(Point p){
        for(Point x : vertices2){
            if(Math.abs(x.x - p.x) <= 3 && Math.abs(x.x - p.x) <= 3){
                return new Point(x.x, x.y);
            }
        }
        return null;
    }
    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // colinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }
    public static ArrayList<Point> convexHull(ArrayList<Point> points, int n)
    {
        if (n < 3) return points;

        ArrayList<Point> hull = new ArrayList<Point>();

        int l = 0;
        for (int i = 1; i < n; i++)
            if (points.get(i).x < points.get(l).x)
                l = i;
        int p = l, q;
        do
        {
            hull.add(points.get(p));

            q = (p + 1) % n;

            for (int i = 0; i < n; i++)
            {
                if (orientation(points.get(p), points.get(i), points.get(q)) == 2)
                    q = i;
            }
            p = q;

        } while (p != l);
        return hull;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}