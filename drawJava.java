
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class drawJava extends JFrame {
   public static void main(String[] args){
       new drawJava();
   }

   public drawJava() {
       setSize(600, 600);
       setTitle("Software Development II");
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       MyJPanel panel= new MyJPanel();
       Container c = getContentPane();
       c.add(panel);
       setVisible(true);
   }

   public class MyJPanel extends JPanel implements
       ActionListener, MouseListener, MouseMotionListener {
       JSlider sliderR, sliderG, sliderB, sliderPen;
       JLabel labelR, labelG, labelB, labelPen;
       JButton button, deselectButton;
       int colorR, colorG, colorB;
       int rad, x = -100, y = -100;
       boolean isButtonClicked = false;

       /* 演習問題6-2 追加のラジオボタン */
       JRadioButton radioButtonR, radioButtonY, radioButtonB;
       ButtonGroup group;



       public MyJPanel() {
           setLayout(null);

           addMouseListener(this);
           addMouseMotionListener(this);

           /* 演習問題6-2 追加のラジオボタン */
           radioButtonR = new JRadioButton("ラジオボタン赤",false);
           radioButtonR.setBounds(30, 100, 130, 15);

           radioButtonY = new JRadioButton("ラジオボタン黄",false);
           radioButtonY.setBounds(30, 130, 130, 15);

           radioButtonB = new JRadioButton("ラジオボタン水",false);
           radioButtonB.setBounds(30, 160, 130, 15);


           labelR = new JLabel("赤");
           labelR.setBounds(40, 10, 20, 25);
           sliderR = new JSlider(0, 255, 0);
           sliderR.setBounds(60, 10, 200, 25);
           /* 演習問題6-2 追加 スライダーに目盛り */
           sliderR.setMajorTickSpacing(10);
           //sliderR.setMinorTickSpacing(2);
           sliderR.setPaintTicks(true);

           labelG = new JLabel("緑");
           labelG.setBounds(40, 35, 20, 25);
           sliderG = new JSlider(0, 255, 0);
           sliderG.setBounds(60, 35, 200, 25);
           sliderG.setMajorTickSpacing(10);
           sliderG.setPaintTicks(true);

           labelB = new JLabel("青");
           labelB.setBounds(40, 60, 20, 25);
           sliderB = new JSlider(0, 255, 0);
           sliderB.setBounds(60, 60, 200, 25);
           sliderB.setMajorTickSpacing(10);
           sliderB.setPaintTicks(true);


           labelPen = new JLabel("ペンの大きさ");
           labelPen.setBounds(280, 10, 100, 25);
           sliderPen = new JSlider(2, 50, 25);
           sliderPen.setBounds(360, 10, 200, 25);

           button = new JButton("消去");
           button.setBounds(410, 45, 100, 30);
           button.addActionListener(this);

           /* 演習問題6-2 ラジオボタン解除 */
           deselectButton = new JButton("ラジオボタン解除");
           deselectButton.setBounds(30, 185, 150, 30);
           deselectButton.addActionListener(this);


           add(labelR);
           add(sliderR);
           add(labelG);
           add(sliderG);
           add(labelB);
           add(sliderB);
           add(labelPen);
           add(sliderPen);
           add(button);

           /* 演習問題6-2 追加のラジオボタン */
            group = new ButtonGroup();
            group.add(radioButtonR);
            group.add(radioButtonY);
            group.add(radioButtonB);

           add(radioButtonR);
           add(radioButtonY);
           add(radioButtonB);

           add(deselectButton);
       }

       public void paintComponent(Graphics g) {

           if (isButtonClicked) {
               super.paintComponent(g);
               isButtonClicked = false;
           }

           /* 演習問題6-2 追加のラジオボタン */
           if (radioButtonR.isSelected()) {
               g.setColor(new Color(colorR = 255, colorG = 0, colorB = 0));
               g.drawString("赤が選択されています", 170, 113);
           }
           if (radioButtonY.isSelected()) {
                g.setColor(new Color(colorR = 255, colorG = 255, colorB = 0));
                g.drawString("黄色が選択されています", 170, 143);

            }
            if (radioButtonB.isSelected()) {
                g.setColor(new Color(colorR=0, colorG=255, colorB=255));
                g.drawString("水色が選択されています", 170, 173);

            }


           g.setColor(new Color(colorR, colorG, colorB));
           g.fillOval(x-rad/2, y-rad/2, rad, rad);
           repaint();
       }

       public void actionPerformed(ActionEvent e) {
          isButtonClicked = true;

          /* 演習問題6-2 ラジオボタン解除 */
          if (e.getSource() == deselectButton) {
            group.clearSelection();
          }
          group.clearSelection();
          repaint();

       }

       public void mouseClicked(MouseEvent e) {

       }

       public void mousePressed(MouseEvent e) {
       }

       public void mouseReleased(MouseEvent e) {
           x = -100;
           y = -100;
           repaint();
       }

       public void mouseExited(MouseEvent e) {
       }

       public void mouseEntered(MouseEvent e) {
       }

       public void mouseMoved(MouseEvent e) {
       }

       public void mouseDragged(MouseEvent e) {
           colorR = sliderR.getValue();

           colorG = sliderG.getValue();
           colorB = sliderB.getValue();
           rad = sliderPen.getValue();
            x = e.getX();
            y = e.getY();


          repaint();
       }
   }
}
