import javax.swing.*;
import java.awt.*;
import java.applet.*;
public class countdownMainFile {
    JFrame frame= new JFrame("Count-Down");
    JLabel label= new JLabel("10");
    AudioClip[] clips = new AudioClip[10];
    public countdownMainFile(){
        frame.setSize(400,450);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,160));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(label);
        label.setFont(new Font("arial",Font.PLAIN,30));
        label.setForeground(Color.BLUE);
        frame.setBackground(Color.BLACK);
        loadClip();
        AudioClip clip=Applet.newAudioClip(getClass().getResource("sounds/intro.mid"));
        clip.loop();
        new NumberThread().start();
        frame.setVisible(true);
    }
    private void loadClip(){
        for(int i=0;i<10;i++){
            clips[i]=Applet.newAudioClip(getClass().getResource("sounds/"+(i+1)+".wav"));
        }
    }
    class NumberThread extends Thread{
        public void run(){
            for(int i=10;i>=1;i--){
                clips[i-1].play();
                label.setText(String.valueOf(i));
                try{
                    Thread.sleep(1000);
                }catch (Exception ex){}
            }
            AudioClip cl =Applet.newAudioClip(getClass().getResource("sounds/11.wav"));
            cl.play();
            label.setText("Let's play!!");
            try {
                Thread.sleep(2000);
            }catch(Exception ex) {}
        }
    }
    public static void main(String[] args) {
        new countdownMainFile();
    }
}
