package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author BLONBOUT
 */
public class Fenetre extends JFrame implements ActionListener {
    
    public JComboBox lesAnnees = new JComboBox();
    public Fenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Mon Calendrier");
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);
        this.setVisible(true);
        //Définition de sa couleur de fond
        pan.setBackground(Color.GRAY);
        
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem open = new JMenuItem("Ouvrir");
        JMenuItem save = new JMenuItem("Sauver");
        JMenuItem create = new JMenuItem("Créer");
        JMenuItem close = new JMenuItem("Quitter");
        
        
        // affecter le raccourci
        menu.setMnemonic(KeyEvent.VK_M);
        open.setMnemonic(KeyEvent.VK_O);
        close.setMnemonic(KeyEvent.VK_Q);
        save.setMnemonic(KeyEvent.VK_S);
        create.setMnemonic(KeyEvent.VK_N);

        // ajouter le menu dans la barre de menu
        mb.add(menu);

        // ajouter les items dans le menu
        menu.add(create);
        menu.add(open);
        menu.add(save);
        menu.add(close);

        //On grise le save au début
        save.setVisible(false);

        //ajout du menuBar au Jpannel        
        this.setJMenuBar(mb);

        //ajout des écouteurs
        open.addActionListener(this);
        save.addActionListener(this);
        create.addActionListener(this);
        close.addActionListener(this);
        lesAnnees.addItemListener( new ItemLesAnnees());
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Quitter".equals(e.getActionCommand())) {
            int reponse = JOptionPane.showConfirmDialog(this, "Quitter sans enregistrer?", "Quitter", WIDTH, JOptionPane.ERROR_MESSAGE);
            if (reponse == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        
        if ("Créer".equals(e.getActionCommand())) {
            
            for(int i = 0; i<=2; i++)
            {
                lesAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR)+i);
            }
            lesAnnees.setSelectedItem(null);
            this.add(lesAnnees);
            validate();
        }
        /* if(e.getSource() == close)
         if(e.getSource() == close)
         if(e.getSource() == close)*/
    }

    private static class ItemLesAnnees implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ie.SELECTED)
            {
                int monAnnee = (int)ie.getItem();
                                
            }
        }
    }

}
