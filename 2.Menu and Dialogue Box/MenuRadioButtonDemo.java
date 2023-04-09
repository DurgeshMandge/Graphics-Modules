import javax.swing.*;
import java.awt.event.*;

class MenuRadioButtonDemo extends JFrame implements ItemListener {

    static JLabel l;
    static JRadioButtonMenuItem readItem;
    static JRadioButtonMenuItem writeItem;
    static JRadioButtonMenuItem readWriteItem;

    // Constructor
    public MenuRadioButtonDemo () {
        setTitle("Menu Demo");
        setSize(400,400);
    }

    public static void main(String[] args) {

        MenuRadioButtonDemo frame = new MenuRadioButtonDemo();

        l = new JLabel("No task");

        JMenuBar b = new JMenuBar();

        frame.setJMenuBar(b);

        JMenu optionMenu = new JMenu("Option");

        readItem = new JRadioButtonMenuItem("Read");
        writeItem = new JRadioButtonMenuItem("Write");
        readWriteItem = new JRadioButtonMenuItem("ReadWrite");

        ButtonGroup group = new ButtonGroup();
        group.add(readItem);
        group.add(writeItem);
        group.add(readWriteItem);

        optionMenu.add(readItem);
        optionMenu.add(writeItem);
        optionMenu.add(readWriteItem);

        readItem.addItemListener(frame);
        writeItem.addItemListener(frame);
        readWriteItem.addItemListener(frame);

        b.add(optionMenu);

        frame.add(l);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override

    public void itemStateChanged(ItemEvent e){

        JMenuItem item = (JMenuItem)e.getSource();

        String str = item.getText();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            str += " is Selected";
        } else {
            str += " is Diselected";
        } 

        l.setText(str);

    }
}