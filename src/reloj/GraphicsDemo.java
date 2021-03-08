package reloj;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsDemo extends Frame {
    char[][] arr;
    char c;
    Color rosa1 = new Color(206,188,245);
    Color rosa2 = new Color(162,160,222);
    Color rosa3 = new Color(180,196,250);

    public GraphicsDemo(char[][] arr) {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        this.arr = arr;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                c = arr[i][j];
                if (c == '0') {
                    switch (j) {
                        case 0:
                        case 1:
                            g.setColor(rosa1);
                            break;
                        case 2:
                        case 3:
                            g.setColor(rosa2);
                            break;
                        case 4:
                        case 5:
                            g.setColor(rosa3);
                            break;
                    }
                    g.fillRect(j * 40 + 40, i * 40 + 40, 40, 40);
                } else {
                    g.setColor(Color.black);
                    g.fillRect(j * 40 + 40, i * 40 + 40, 40, 40);
                }
            }
        }
    }
}
