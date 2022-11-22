import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener, Serializable {
    public Drawing draw;
    public Window(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contentPanel = this.getContentPane();

        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        JMenuItem nw = new JMenuItem("New");
        nw.addActionListener(this);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit");
        menu1.add(open);
        menu1.add(nw);
        menu1.add(save);
        menu1.add(exit);

        JMenu menu2 = new JMenu("Infos");
        JMenuItem author = new JMenuItem("Author");
        author.addActionListener(this);
        menu2.add(author);


        m.add(menu1);
        m.add(menu2);
        this.setJMenuBar(m);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton black = new JButton("Black");
        black.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 0;
        black.setBackground(Color.BLACK);
        black.setForeground(Color.WHITE);
        southPanel.add(black, c);

        JButton red = new JButton("Red");
        red.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 0;
        red.setBackground(Color.RED);
        southPanel.add(red, c);

        JButton green = new JButton("Green");
        green.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 2;
        c.gridy = 0;
        green.setBackground(Color.GREEN);
        southPanel.add(green, c);

        JButton blue = new JButton("Blue");
        blue.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 3;
        c.gridy = 0;
        blue.setBackground(Color.BLUE);
        blue.setForeground(Color.WHITE);
        southPanel.add(blue, c);

        JButton yellow = new JButton("Yellow");
        yellow.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 1;
        yellow.setBackground(Color.YELLOW);
        southPanel.add(yellow, c);

        JButton pink = new JButton("Pink");
        pink.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 1;
        pink.setBackground(Color.PINK);
        southPanel.add(pink, c);

        JButton magenta = new JButton("Magenta");
        magenta.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 2;
        c.gridy = 1;
        magenta.setBackground(Color.MAGENTA);
        southPanel.add(magenta, c);

        JButton orange = new JButton("Orange");
        orange.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 3;
        c.gridy = 1;
        orange.setBackground(Color.ORANGE);
        southPanel.add(orange, c);

        JButton ell = new JButton("Ellipse");
        ell.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.8;
        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 2;
        southPanel.add(ell, c);

        JButton cir = new JButton("Circle");
        cir.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.gridx = 6;
        c.gridy = 0;
        southPanel.add(cir, c);

        JButton rec = new JButton("Rectangle");
        rec.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.8;
        c.gridx = 4;
        c.gridy = 1;
        southPanel.add(rec, c);

        JButton sqr = new JButton("Square");
        sqr.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.gridx = 6;
        c.gridy = 1;
        southPanel.add(sqr, c);

        contentPanel.add(southPanel, "South");

        this.draw = new Drawing();
        contentPanel.add(this.draw);

        this.setVisible(true);
    }


    public static void main(String args[]) {
        Window win = new Window("Paint", 800, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Black":
                this.draw.setColor(Color.BLACK);
                break;
            case "Pink":
                this.draw.setColor(Color.PINK);
                break;
            case "Orange":
                this.draw.setColor(Color.ORANGE);
                break;
            case "Green":
                this.draw.setColor(Color.GREEN);
                break;
            case "Red":
                this.draw.setColor(Color.RED);
                break;
            case "Magenta":
                this.draw.setColor(Color.MAGENTA);
                break;
            case "Blue":
                this.draw.setColor(Color.BLUE);
                break;
            case "Yellow":
                this.draw.setColor(Color.YELLOW);
                break;


            case "Rectangle":
                this.draw.setShape("Rectangle");
                break;
            case "Ellipse":
                this.draw.setShape("Ellipse");
                break;
            case "Square":
                this.draw.setShape("Square");
                break;
            case "Circle":
                this.draw.setShape("Circle");
                break;

            case "New":
                this.draw.List = new ArrayList<Figure>();
                repaint();
                break;
            case "Open":
                JFrame fileopen = new JFrame();
                String MessageOpen = JOptionPane.showInputDialog(fileopen, "Name of the file :");
                this.draw.List = new ArrayList<Figure>();
                this.open(MessageOpen);
                repaint();
            case "Save":
                JFrame filesave = new JFrame();
                String MessageSave = JOptionPane.showInputDialog(filesave, "Save as :");
                this.save(MessageSave);
                break;

            case "Quit":
                this.dispose();
                break;
            case "Author":
                JOptionPane info = new JOptionPane("Info");
                info.showInternalMessageDialog(info, "Author: TRAN Jeremy", "inforamtaion", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }

    public void save(String Message) {
        try {
            FileOutputStream fos = new FileOutputStream(Message);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(this.draw.List.size());
            for (Figure f : this.draw.List) {
                oos.writeObject(f);
            }
            oos.close();
            System.out.println("File saved as : " + Message );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void open(String Message) {
        try {
            FileInputStream fis = new FileInputStream(Message);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int total = ois.readInt();
            for (int i = 0; i < total; i++) {
                this.draw.List.add((Figure) ois.readObject());
            }
            ois.close();
            System.out.println("File opened : " + Message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}