package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class Fenetre extends JFrame implements ActionListener{
    private ContenuFenetre monContenu ;
    private final Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem open = new JMenuItem("Ouvrir");
    JMenuItem save = new JMenuItem("Sauvegarder");
    JMenuItem create = new JMenuItem("Créer");
    JMenuItem afficher = new JMenuItem("Afficher");
    JMenuItem close = new JMenuItem("Quitter");
    JMenu menuFormation = new JMenu("Formation");
    JMenuItem openFormation = new JMenuItem("Modifier");
    JMenuItem createFormation = new JMenuItem("Creer");
    
    public Fenetre() {
        monContenu = new ContenuFenetre();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Ajout du titre à la fenetre */
        this.setTitle("Mon Calendrier");
        
        /*définition de la taille à la fenêtre*/
        this.setSize((int) tailleEcran.getWidth(), (int)tailleEcran.getHeight());
        this.setLocationRelativeTo(null);
        
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(monContenu);
        this.setVisible(true);
        
        open.addActionListener(this);
        save.addActionListener(this);
        create.addActionListener(this);
        close.addActionListener(this);
        openFormation.addActionListener(this);
        createFormation.addActionListener(this);
        afficher.addActionListener(this);
        
        /* Affectation de raccourcis aux composants de la fenêtre*/
        menu.setMnemonic(KeyEvent.VK_M);
        open.setMnemonic(KeyEvent.VK_O);
        afficher.setMnemonic(KeyEvent.VK_A);
        close.setMnemonic(KeyEvent.VK_Q);
        save.setMnemonic(KeyEvent.VK_S);
        create.setMnemonic(KeyEvent.VK_N);
        menuFormation.setMnemonic(KeyEvent.VK_F);
        
        /*Ajout du Menu dans la MenuBar*/
        mb.add(menu);
        mb.add(menuFormation);
        
        /*Ajout des différents Items au Menu */
        menu.add(afficher);
        menu.add(create);
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(close);
        menuFormation.add(createFormation);
        menuFormation.add(openFormation);
        
        setJMenuBar(mb);
        /*Au démarrage la sauvegarde n'est pas visible*/
        save.setEnabled(false);
        afficher.setEnabled(false);
        openFormation.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
                
        if (ae.getSource() == createFormation) {
            PanelFormation panel = new PanelFormation();
            monContenu.getPanelHaut().setVisible(false);
            monContenu.getPanelCalendrier().removeAll();
           // monContenu.getPanelCalendrier().add(panel);
            monContenu.revalidate();
            monContenu.repaint();
           
            setContentPane(panel);
            validate();
            repaint();
            save.setEnabled(true);
            afficher.setEnabled(true);
            openFormation.setEnabled(true);            
        }

        if (ae.getSource() == openFormation) {
            PanelModule panel = new PanelModule();
            monContenu.getPanelHaut().setVisible(false);
            monContenu.getPanelCalendrier().removeAll();
            //monContenu.getPanelCalendrier().add(panel);
            
            setContentPane(panel);
            validate();
            repaint();
            monContenu.revalidate();
            monContenu.repaint();
        }
        
        if (ae.getSource() == afficher) {
            setContentPane(monContenu);
            monContenu.getPanelCalendrier().removeAll();
            monContenu.getPanelHaut().setVisible(true);
            monContenu.Affiche("");
            validate();
            repaint();
        }
        
        if (ae.getSource() == open) {
            
            setContentPane(monContenu);
            validate();
            repaint();
            monContenu.getPanelHaut().setVisible(true);
            monContenu.getPanelCalendrier().removeAll();
            File file = new File("Sauvegarde/sauvegarde.bin");
            Global.planning = (Planning)MethodesPourFichier.lecture(file);
            System.out.println(Global.planning);//monContenu.setPlanning(Global.planning);
            
            monContenu.Affiche("");
            afficher.setEnabled(true);
            save.setEnabled(true);
            openFormation.setEnabled(true);
        }
        
        if (ae.getSource() == save) {
            MethodesPourFichier.ecriture(Global.planning);
            System.out.println(Global.planning);
        }

        if (ae.getSource() == create) {
            Global.planning.clear();
            monContenu.Affiche("new");
            afficher.setEnabled(false);
            save.setEnabled(false);
        }
        
        if (ae.getSource() == close) {
            /*Ouverture d'une fenetre de dialog pour quitter*/
            int reponse = JOptionPane.showConfirmDialog(this, "Quitter sans enregistrer?", "Quitter", WIDTH, JOptionPane.ERROR_MESSAGE);
            if (reponse == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
