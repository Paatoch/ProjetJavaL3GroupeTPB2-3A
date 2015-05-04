package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author BLONBOUT
 */
public class Fenetre extends JFrame implements ActionListener {

    public JComboBox lesAnnees = new JComboBox();
    int monAnnee = 0;
    int monMois = 0;
    private JPanel pan = new JPanel(new BorderLayout());
    private JPanel haut = new JPanel(new GridBagLayout());
    private JPanel bas = new JPanel(new GridBagLayout());
    private JPanel milieu = new JPanel(new GridBagLayout());
    private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hauteur = (int) tailleEcran.getHeight();
    private int largeur = (int) tailleEcran.getWidth();
    private JPanel contentPanel = new JPanel(new BorderLayout());

    public Fenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Mon Calendrier");

        this.setSize(largeur, hauteur);
        this.setLocationRelativeTo(null);
        //GridBagLayout content = new GridBagLayout();

        //On prÈvient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);
        this.setVisible(true);
        //DÈfinition de sa couleur de fond
        pan.setBackground(Color.GRAY);
        haut.setBackground(Color.GRAY);

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

        //On grise le save au dÈbut
        save.setVisible(false);

        //ajout du menuBar au Jpannel        
        this.setJMenuBar(mb);

        //ajout des Ècouteurs
        open.addActionListener(this);
        save.addActionListener(this);
        create.addActionListener(this);
        close.addActionListener(this);
        lesAnnees.addItemListener(new ItemLesAnnees());
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

            for (int i = 0; i <= 2; i++) {
                lesAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
            }
            lesAnnees.setSelectedItem(null);
            pan.add(haut, BorderLayout.NORTH);
            haut.add(lesAnnees);
            validate();
        }
    }

    private class ItemLesAnnees implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ie.SELECTED) {
                monAnnee = (int) ie.getItem();
                if (monAnnee == Calendar.getInstance().get(Calendar.YEAR)) {
                    monMois = Calendar.getInstance().get(Calendar.MONTH);
                }
                createCalendar(monAnnee, monMois);
            }
        }
    }

    private void createCalendar(int uneAnnee, int unMois) {
        int nbSemaine = 0;
        Calendar startDate = Calendar.getInstance();
        //startDate.setFirstDayOfWeek(Calendar.MONDAY);
        startDate.set(Calendar.MONTH, unMois);
        startDate.set(Calendar.YEAR, uneAnnee);
        startDate.setMinimalDaysInFirstWeek(1);
        System.out.println(startDate.getActualMaximum(Calendar.WEEK_OF_MONTH));
        nbSemaine = startDate.getActualMaximum(Calendar.WEEK_OF_MONTH);
        
        
        for (int i = 0; i < nbSemaine; i++) {
            JTable content = new JTable(new ModeleTableCalendrierJour());
            JTable leftContent = new JTable(new ModeleTableCalendrierPeriode());
            JScrollPane Jpane = new JScrollPane(content);
            JScrollPane JpaneLeft = new JScrollPane(leftContent);
            contentPanel.add(Jpane, BorderLayout.CENTER);
            contentPanel.add(JpaneLeft, BorderLayout.WEST);
            pan.add(contentPanel, BorderLayout.CENTER);
            validate();
        }
        }
    }
