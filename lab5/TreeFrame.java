import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

//visar ett träd med bara en enda nod, roten.

class TreeFrame extends JFrame implements ActionListener {
    JCheckBox box;
    JTree tree;
    MyNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    TreeFrame() {
    	Container c = getContentPane();

    	// initTree() should create root, treeModel and tree.
    	initTree();

    	tree.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    		    if (box.isSelected())
          //System.out.println(e.getSource() instanceof File);
    			showDetails(tree.getPathForLocation(e.getX(), e.getY()));
    		}
    	    });

    	controls = new JPanel();
    	box = new JCheckBox(showString);
    	initGUI();
    	c.add(controls, BorderLayout.NORTH);
    	c.add(tree, BorderLayout.CENTER);
    	setVisible(true);
        }

    public void actionPerformed(ActionEvent e) {
    	String cmd = e.getActionCommand();
    	if (cmd.equals(closeString))
    	    dispose();
    }

    void initGUI() {
    	tree.setFont(new Font("Dialog", Font.BOLD, 12));
    	controls.add(box);
    	addButton(closeString);
    	controls.setBackground(Color.lightGray);
    	controls.setLayout(new FlowLayout());
    	setSize(400, 400);
    }

    void addButton(String n) {
    	JButton b = new JButton(n);
    	b.setFont(new Font("Dialog", Font.BOLD, 12));
    	b.addActionListener(this);
    	controls.add(b);
    }

    // ***** Override initTree in subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(){
    //	root = new MyNode("TestString");
//    	treeModel = new DefaultTreeModel(root);
//    	tree = new JTree(treeModel);
    }

    // ***** showDetails can also be overridden in a subclass *****
    void showDetails(TreePath path){
    	if (path == null)
    	    return;
    	String info = path.getLastPathComponent().toString();
    	JOptionPane.showMessageDialog(this, info);
        }

    public static void main(String[] u) {
	     new TreeFrame();
    }
}
