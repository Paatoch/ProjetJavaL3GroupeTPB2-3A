package projetjavaptb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import javax.swing.border.TitledBorder;
import projetjavaptb.ModeleTableCalendrierJour.MonCellRenderer;

/**
 *
 * @author patrickcabral
 * @author BLONBOUT
 * @author BenjaminTabet
 */
public class Fenetre extends JFrame implements ActionListener {
    Planning planning;
    int tempMouse = 0;
    public final ArrayList<Cours_Reservation> lesCours = new ArrayList<Cours_Reservation>();
    public JComboBox comboAnnees = new JComboBox();
    public JLabel lblMois = new JLabel();
    public final Formation formation = new Formation();

    ImageIcon iconPrev = new ImageIcon("Images/prev.png");
    ImageIcon iconNext = new ImageIcon("Images/next.png");
    public ArrayList<String> listeMois;
    public JLabel lblNextMonth = new JLabel();
    public JLabel lblPrevMonth = new JLabel();
    int anneeCourante = 0;
    int moisCourant = 0;
    private JPanel panelSource = new JPanel(new BorderLayout());
    private JPanel panelHaut = new JPanel(new GridBagLayout());
    private JPanel panelBas = new JPanel();
    private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int hauteur = (int) tailleEcran.getHeight();
    private int largeur = (int) tailleEcran.getWidth();
    private final JPanel contentPanel = new JPanel(new GridBagLayout());

    /*Création de chaine pour les noms utilisés dans la fenetre */
    public String sMenu = "Menu";
    public String sOpen = "Ouvrir";
    public String sSave = "Sauver";
    public String sCreate = "Créer";
    public String sClose = "Quitter";

    public String sMenuFormation = "Formation";
    public String sCreateFormation = "Ajouter";
    public String sOpenFormation = "Modifier";

    /*Création des composants de la fenêtre*/
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu(sMenu);
    JMenuItem open = new JMenuItem(sOpen);
    JMenuItem save = new JMenuItem(sSave);
    JMenuItem create = new JMenuItem(sCreate);
    JMenuItem close = new JMenuItem(sClose);
    JMenu menuFormation = new JMenu(sMenuFormation);
    JMenuItem openFormation = new JMenuItem(sOpenFormation);
    JMenuItem createFormation = new JMenuItem(sCreateFormation);

    // declaration JTABLE
    JTable contentTemp = new JTable();

    JLabel labelTeddy = new JLabel(" Teddy Blonbou  -   ");
    JLabel labelPatrick = new JLabel("Patrick Cabral  -   ");
    JLabel labelBenjamin = new JLabel("Benjamin Tabet    ");

    public Fenetre() {
        lblMois.setFont(new Font("Arial", Font.BOLD, 16));
        /* récupération de l'année courante */
        anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
        /* récupération du moins courant */
        moisCourant = Calendar.getInstance().get(Calendar.MONTH);
        /*Liste contenant tout les mois de l'année*/
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
        lblMois.setText(listeMois.get(moisCourant));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Ajout du titre à la fenetre */
        this.setTitle("Mon Calendrier");
        /*définition de la taille à la fenêtre*/
        this.setSize(largeur, hauteur);
        this.setLocationRelativeTo(null);
        //GridBagLayout content = new GridBagLayout();

        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(panelSource);
        /*Fenêtre rendu visible*/
        this.setVisible(true);
        /*Définition de la couleur de fond de la fenêtre*/
        panelSource.setBackground(Color.GRAY);
        panelHaut.setBackground(Color.GRAY);

        // createFormation.addActionListener( new ListenerPanel1());

        /* Affectation de raccourcis aux composants de la fenêtre*/
        menu.setMnemonic(KeyEvent.VK_M);
        open.setMnemonic(KeyEvent.VK_O);
        close.setMnemonic(KeyEvent.VK_Q);
        save.setMnemonic(KeyEvent.VK_S);
        create.setMnemonic(KeyEvent.VK_N);

        menuFormation.setMnemonic(KeyEvent.VK_F);

        /*Ajout du Menu dans la MenuBar*/
        mb.add(menu);
        mb.add(menuFormation);
        /*Ajout des différents Item au Menu */
        menu.add(create);
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(close);

        menuFormation.add(openFormation);
        menuFormation.add(createFormation);
        /*Au démarrage la sauvegarde n'est pas visible*/
        save.setEnabled(false);

        /*Ajout du menuBar au Jpannel */
        this.setJMenuBar(mb);

        /*Ajout des Ècouteurs*/
        open.addActionListener(this);
        save.addActionListener(this);
        create.addActionListener(this);
        close.addActionListener(this);
        openFormation.addActionListener(this);
        createFormation.addActionListener(this);
        comboAnnees.addItemListener(new ItemLesAnnees());
        validate();

        /*Ajout des images uax labels */
        lblPrevMonth.setIcon(iconPrev);
        lblNextMonth.setIcon(iconNext);
        /*Définition de l'action sur l'écouteur de l'image (précédant)*/
        lblPrevMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (moisCourant > 0) {
                    moisCourant -= 1;
                    /*Récupération du nom du mois */
                    lblMois.setText(listeMois.get(moisCourant));
                    createCalendar(anneeCourante, moisCourant);
                } else {
                    /*Condition dans le cas ou l'on passe à l'année précédante*/
                    if (anneeCourante > Calendar.getInstance().get(Calendar.YEAR)) {
                        moisCourant = 11;
                        anneeCourante -= 1;
                        comboAnnees.setSelectedItem(anneeCourante);
                        lblMois.setText(listeMois.get(moisCourant));
                        createCalendar(anneeCourante, moisCourant);
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
        /*Définition de l'action sur l'écouteur de l'image (suivant)*/
        lblNextMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                /*Si le mois courant est strictement inferieur a decembre alors on incremente de 1 le mois*/
                if (moisCourant < 11) {
                    moisCourant += 1;
                    lblMois.setText(listeMois.get(moisCourant));
                    lblMois.setVisible(true);
                    createCalendar(anneeCourante, moisCourant);
                } else {
                    if (anneeCourante < Calendar.getInstance().get(Calendar.YEAR) + 2) {
                        moisCourant = 0;
                        /*Ajout d'une année dans le cas ou le mois est celui suivant Décembre*/
                        anneeCourante += 1;
                        comboAnnees.setSelectedItem(anneeCourante);
                        lblMois.setText(listeMois.get(moisCourant));
                        createCalendar(anneeCourante, moisCourant);
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

        panelBas.add(labelTeddy);
        panelBas.add(labelPatrick);
        panelBas.add(labelBenjamin);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // System.out.println(e.getSource());
       // System.out.println(close);
        if (e.getSource() == close) {
            /*Ouverture d'une fenetre de dialog pour quitter*/
            int reponse = JOptionPane.showConfirmDialog(this, "Quitter sans enregistrer?", "Quitter", WIDTH, JOptionPane.ERROR_MESSAGE);
            if (reponse == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        if (e.getSource() == createFormation) {
            PanelFormation panel = new PanelFormation(formation);
            contentPanel.removeAll();
            setContentPane(panel);
            revalidate();
            repaint();
            save.setEnabled(true);
        }

        if (e.getSource() == open) {
            File file = new File("Sauvegarde/sauvegarde.bin");
             planning = (Planning)MethodesPourFichier.lecture(file);
            lesCours.clear();
            lesCours.addAll(planning.getListePlanningC());
            formation.clear();
            formation.addAll(planning.getListePlanningF());
            save.setEnabled(true);
            addPanel();
        }
        
        if (e.getSource() == save) {
            Planning planning = new Planning( lesCours, formation);
            MethodesPourFichier.ecriture(planning);
            System.out.println(planning);
        }

        if (e.getSource() == openFormation) {
            PanelModule panel = new PanelModule(formation);
            contentPanel.removeAll();
            setContentPane(panel);
            revalidate();
            repaint();
            
            save.setEnabled(true);
        }

        if (e.getSource() == create) {
            addPanel();
            }
    }
public void addPanel (){
    comboAnnees.removeAllItems();
            for (int i = 0; i <= 2; i++) {
                comboAnnees.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
            }
            setContentPane(panelSource);

            panelSource.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBorder(BorderFactory.createTitledBorder(null, "Choix Année et Mois", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));

            //Affichage des boutons ameliorer
            //La combobox des annees est placee en haut et les labels des mois et les boutons en bas
            GridBagConstraints contraintes = new GridBagConstraints();
            contraintes.insets = new Insets(2, 0, 4, 0);
            contraintes.fill = GridBagConstraints.LINE_START;
            contraintes.gridx = 2;
            contraintes.gridy = 0;
            contraintes.weightx = 0.3;
            contraintes.weighty = 1;
            panelHaut.add(comboAnnees, contraintes);
            contraintes.insets = new Insets(2, 0, 4, 0);
            contraintes.gridx = 1;
            contraintes.gridy = 1;
            contraintes.weightx = 0.3;
            contraintes.weighty = 1;
            panelHaut.add(lblPrevMonth, contraintes);
            //lesMois.setPreferredSize(new Dimension(50,50));
            contraintes.insets = new Insets(2, 0, 4, 0);
            contraintes.gridx = 2;
            contraintes.gridy = 1;
            contraintes.weightx = 0.3;
            contraintes.weighty = 1;
            panelHaut.add(lblMois, contraintes);
            contraintes.insets = new Insets(2, 0, 4, 0);
            contraintes.gridx = 3;
            contraintes.gridy = 1;
            contraintes.weightx = 0.3;
            contraintes.weighty = 1;
            panelHaut.add(lblNextMonth, contraintes);
            createCalendar(anneeCourante, moisCourant);
            validate();
            repaint();
            save.setEnabled(true);
        
}
    private class ItemLesAnnees implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ie.SELECTED) {
                anneeCourante = (int) ie.getItem();
                createCalendar(anneeCourante, moisCourant);
            }
        }
    }

    /*Class permettant la création du calendrier*/
    private void createCalendar(int uneAnnee, int unMois) {
        
        /*Suppression du contenu du panel*/
        contentPanel.removeAll();

        contentPanel.setBorder(BorderFactory.createTitledBorder(null, "Planning", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));
        /*Création du calendrier grégorien*/
        GregorianCalendar startDate = new GregorianCalendar(uneAnnee, unMois, 1);
        startDate.setMinimalDaysInFirstWeek(1);
        /*Variable contenant le nombre de semaine présent dans le mois*/
        int nbSemaine = startDate.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        /*Variable contenant le nombre de jours présent dans le mois*/
        int nbJour = startDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        /*Variable contenant le premier jour du mois*/
        int premierJour = startDate.get(GregorianCalendar.DAY_OF_WEEK);

        ArrayList<JPanel> content = new ArrayList<>();
        contentTemp.setDefaultRenderer(Object.class, new MonCellRenderer());

        contentTemp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (e.getClickCount() == 2) {
                    //System.out.println(e.getID());
                    if(tempMouse != e.getID())
                    {
                        Point p = e.getPoint(); //recup la position de la souris 
                        int row = contentTemp.rowAtPoint(p); //indice de la ligne a cette position
                        int col = contentTemp.columnAtPoint(p); //indice colonne 
                        //JOptionPane.showMessageDialog(contentPanel, contentTemp.getValueAt(row, col)); //element a ligne row et colonne col 
                        tempMouse = e.getID();
                        int maValeur;
                        try{
                            maValeur = (int)contentTemp.getValueAt(row-2, col);
                            Formulaire_Cours formulaire =  new Formulaire_Cours (maValeur, anneeCourante,    listeMois.get(moisCourant),  formation, lesCours, "midi", contentPanel);
                            validate();
                        }
                        catch(NullPointerException e1){
                            try{
                                maValeur = (int)contentTemp.getValueAt(row-1, col);
                                Formulaire_Cours formulaire =  new Formulaire_Cours (maValeur, anneeCourante,    listeMois.get(moisCourant),  formation, lesCours, "matin", contentPanel);
                                validate();
                                }
                        catch(NullPointerException e2){
                            }
                        }
                    }
                    else tempMouse = 0;
                }

            }

        });
        
        contentTemp.setModel(new ModeleTableCalendrierJour(premierJour, nbJour, nbSemaine, lesCours, listeMois.get(unMois), uneAnnee));
        JTable leftContent = new JTable(new ModeleTableCalendrierPeriode(nbSemaine));
        JScrollPane Jpane = new JScrollPane(contentTemp);
        //Jpane.setSize(new Dimension(400,500));
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
        contentPanel.getPreferredSize();
        panelSource.add(contentPanel, BorderLayout.CENTER);
        panelSource.add(panelBas, BorderLayout.SOUTH);

        labelBenjamin.setFont(new Font("Arial", Font.BOLD, 14));
        labelTeddy.setFont(new Font("Arial", Font.BOLD, 14));
        labelPatrick.setFont(new Font("Arial", Font.BOLD, 14));
        validate();
    }
    
    @Override 
public void repaint() 
{ 
//	repaint le component courant 
super.repaint(); 
//	repaint tous les components qu'il possède 
for(int i = 0; i < this.countComponents(); i++) 
this.getComponent(i).repaint(); 
} 
}
