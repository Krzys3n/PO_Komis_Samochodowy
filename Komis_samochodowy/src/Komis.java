import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Samochod;
import Model.Zakup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Komis extends JFrame {
    private JPanel panel1;
    private JLabel tytul;
    private JTable table1;
    private JLabel granice1;
    private JTextField imie_klienta_input;
    private JLabel imie_klienta_label;
    private JTextField nazwisko_input;
    private JLabel nazwisko_label;
    private JLabel data_zakupu_label;
    private JFormattedTextField data_input;
    private JButton Zapisz;
    private JTable table2;
    private JComboBox samochod_input;
    private JLabel samochod_input_label;
    private List<Samochod> samochody;
    private List<Zakup> zakupy;

    public Komis(String tytul) {
        super(tytul);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        samochody = new ArrayList<Samochod>();
        zakupy = new ArrayList<Zakup>();
        samochody.add(new Samochod(1, "Skoda", 1500.00, 2012));
        samochody.add(new Samochod(2, "Audi", 2100.99, 2020));
        samochody.add(new Samochod(3, "BMW", 999.99, 20016));
        samochody.add(new Samochod(4, "Citroen", 9599.99, 2021));
        samochody.add(new Samochod(5, "Dacia", 210.37, 1999));
        samochody.add(new Samochod(6, "Fiat", 320.00, 2015));
        samochody.add(new Samochod(7, "Ford", 99999.99, 2014));
        samochody.add(new Samochod(8, "Hyundai", 1333.99, 2013));
        samochody.add(new Samochod(9, "Kia", 1543.50, 2002));
        String[] columnNames = {"id", "Model", "Cena", "Rocznik"};
        Object[][] data =
                {

                };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        table1.setModel(tableModel);


        Samochod najtanszy = samochody.get(0);
        Samochod najdrozszy = samochody.get(0);
        for (Samochod samochod : samochody) {
            DodajSamochod(tableModel, samochod);
            samochod_input.addItem(samochod);
            if (samochod.cena() < najtanszy.cena()) {
                najtanszy = samochod;
            }

            if (samochod.cena() > najdrozszy.cena()) {
                najdrozszy = samochod;
            }
        }

        granice1.setText("Najdroszy samochod: " + najdrozszy.model_samochodu() + " (" + najdrozszy.cena() + "). Najtanszy: " + najtanszy.model_samochodu() + " (" + najtanszy.cena() + ").");
        table1.setEnabled(false);

        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int noweId;
                if(zakupy.isEmpty())
                {
                    noweId = 1;
                }
                else
                {
                    noweId = zakupy.get(zakupy.size() - 1).id() + 1;
                }
                Samochod wybranySamochod = (Samochod)samochod_input.getSelectedItem();
                if(wybranySamochod == null)
                {
                    return;
                }
                String imieKlient = imie_klienta_input.getText();
                if(imieKlient == null || imieKlient.isEmpty())
                {
                    return;
                }
                String nazwiskoKlient = nazwisko_input.getText();
                if(nazwiskoKlient ==  null || nazwiskoKlient.isEmpty())
                {
                    return;
                }
                String data = data_input.getText();
                if(data == null || data.isEmpty())
                {
                    return;
                }
                Zakup zakup = new Zakup(noweId, imieKlient, nazwiskoKlient, data, wybranySamochod.id(), wybranySamochod.model_samochodu());
                zakupy.add(zakup);
                UstawZakupy();
                imie_klienta_input.setText("");
                nazwisko_input.setText("");
                data_input.setText("");
            }
        });

        this.pack();
    }

    public static void main(String[] args)
    {
        JFrame frame = new Komis("Komis");
        frame.setVisible(true);
    }

    public void DodajSamochod(DefaultTableModel model, Samochod samochod)
    {
        model.addRow(new Object[]{samochod.id().toString(), samochod.model_samochodu(), samochod.cena().toString(), samochod.rocznik()});
    }

    public void UstawZakupy()
    {
        String[] columnNames = {"id", "Imie", "Nazwisko", "Data", "Samochod"};
        Object[][] data = zakupy.stream().map(zakup -> new Object[]{zakup.id(), zakup.imie(), zakup.nazwisko(), zakup.dataZakupu(), zakup.nazwaSamochodu()}).toArray(Object[][]::new);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        table2.setModel(tableModel);
    }
}
