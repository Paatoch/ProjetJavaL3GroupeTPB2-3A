package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class Fenetre extends JFrame implements ActionListener {

    public JComboBox lesAnnees = new JComboBox();
    public JLabel lesMois = new JLabel();
    ImageIcon iconPrev = new ImageIcon("Images/prev.png");
    ImageIcon iconNext = new ImageIcon("Images/next.png");
    public ArrayList<String> listeMois;
    public JLabel nextMonth = new JLabel();
    public JLabel prevMonth = new JLabel();
    int monAnnee = 0;
    int monMois = 0;
    private JPanel pan = new JPanel(new BorderLayout());
    private JPanel haut = new JPanel(new FlowLayout());
    private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hauteur = (int) tailleEcran.getHeight();
    private int largeur = (int) tailleEcran.getWidth();
    private JPanel contentPanel = new JPanel(new GridBagLayout());

    public Fenetre() {
        monAnnee = Calendar.getInstance().get(Calendar.YEAR);
        monMois = Calendar.getInstance().get(Calendar.MONTH);
        listeMois = new ArrayList<>();
        listeMois.add("Janvier");
        listeMois.add("Fevrier");
        listeMois.add("Mars");
        listeMois.add("Avril");
        listeMois.add("Mai");
        listeMois.add("Juin");
        listeMois.add("Juillet");
        listeMois.add("Aout");
        listeMois.add("Septembre");
        listeMois.add("Octobre");
        listeMois.add("Novembre");
        listeMois.add("Decembre");
        lesMois.setText(listeMois.get(monMois));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Mon Calendrier");

        this.setSize(largeur, hauteur);
        this.setLocationRelativeTo(null);
        //GridBagLayout content = new GridBagLayout();

        //On prévient notre JFrame que notre JPanel sera son content pane
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

        prevMonth.setIcon(iconPrev);
        nextMonth.setIcon(iconNext);
        prevMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(monMois>0)
                {
                    monMois-=1;
                    lesMois.setText(listeMois.get(monMois));
                    createCalendar(monAnnee, monMois);
                }
                else
                {
                    if(monAnnee > Calendar.getInstance().get(Calendar.YEAR))   {
                        monMois = 11;
                        monAnnee -= 1;
                        lesAnnees.setSelectedItem(monAnnee);
                        lesMois.setText(listeMois.get(monMois));
                        createCalendar(monAnnee, monMois);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        nextMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(monMois<11)
                {
                    monMois+=1;
                    lesMois.setText(listeMois.get(monMois));
                    lesMois.setVisible(true);
                    createCalendar(monAnnee, monMois);
                }
                else
                {
                    if(monAnnee < Calendar.getInstance().get(Calendar.YEAR) + 2)   {
                        monMois = 0;
                        monAnnee += 1;
                        lesAnnees.setSelectedItem(monAnnee);
                        lesMois.setText(listeMois.get(monMois));
                        createCalendar(monAnnee, monMois);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        
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
            pan.add(haut, BorderLayout.NORTH);
            haut.add(lesAnnees);
            haut.add(prevMonth);
            //lesMois.setPreferredSize(new Dimension(50,50));
            System.out.println(lesMois.toString());
            haut.add(lesMois);
            haut.add(nextMonth);
            validate();
        }
    }

    private class ItemLesAnnees implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ie.SELECTED) {
                /*monAnnee = (int) ie.getItem();
                if (monAnnee == Calendar.getInstance().get(Calendar.YEAR)) {
                    monMois = Calendar.getInstance().get(Calendar.MONTH);
                }
                else
                {
                    monMois = 0;
                }*/
                createCalendar(monAnnee, monMois);
            }
        }
    }

    private void createCalendar(int uneAnnee, int unMois) {
        contentPanel.removeAll();
        GregorianCalendar startDate = new GregorianCalendar(uneAnnee, unMois, 1);
        startDate.setMinimalDaysInFirstWeek(1);
        int nbSemaine = startDate.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        int nbJour = startDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int premierJour = startDate.get(GregorianCalendar.DAY_OF_WEEK);
        ArrayList<JPanel> content = new ArrayList<JPanel>();

        JTable contentTemp = new JTable(new ModeleTableCalendrierJour(premierJour, nbJour, nbSemaine));
        JTable leftContent = new JTable(new ModeleTableCalendrierPeriode(nbSemaine));
        JScrollPane Jpane = new JScrollPane(contentTemp);
        JScrollPane JpaneLeft = new JScrollPane(leftContent);
        JPanel temp = new JPanel(new BorderLayout());
        temp.add(Jpane, BorderLayout.CENTER);
        temp.add(JpaneLeft, BorderLayout.WEST);
        content.add(temp);

        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.insets = new Insets(4, 0, 10, 0);
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.weightx = 0.3;
        contraintes.weighty = 1;

        for (int i = 0; i < content.size(); i++) {
            contraintes.gridy = i + 1;
            contentPanel.add(content.get(i), contraintes);
        }
        content.clear();
        pan.add(contentPanel, BorderLayout.CENTER);
        validate();
    }
}
