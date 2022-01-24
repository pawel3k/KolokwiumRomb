import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ramka extends JFrame implements ActionListener{
	
	public JPanel gornyPanel = new JPanel();
	
	public JTextField przekatna = new JTextField();
	public JLabel przekatna_podpis = new JLabel("D³u¿sza przek¹tna");
	
	public JTextField bok = new JTextField();
	public JLabel bok_podpis = new JLabel("Bok");
	
	public JTextField wysokosc = new JTextField();
	public JLabel wysokosc_podpis = new JLabel("Wysokoœæ");
	
	public JTextField promien = new JTextField();
	public JLabel promien_podpis = new JLabel("Promieñ okrêgu wpisanego w romb");
	
	public JTextField obwod = new JTextField();
	public JLabel obwod_podpis = new JLabel("Obwód");
	
	public JButton dane = new JButton("Podaj dane!");
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(dane.equals(e.getSource())) {
			podajDane();
		}
		
	}

	private void podajDane() {
		try {
		String krotszaPrzekatna = JOptionPane.showInputDialog(null, "Podaj krótsz¹ przekatn¹!", "Krótsza przek¹tna", JOptionPane.INFORMATION_MESSAGE);
		String poleRombu = JOptionPane.showInputDialog(null, "Podaj pole rombu!", "Pole rombu", JOptionPane.INFORMATION_MESSAGE);
		
		double podanaKrotsza = Double.parseDouble(krotszaPrzekatna);
		double podanePole = Double.parseDouble(poleRombu);
		
		double dluzszaPrzekatna = Math.sqrt(2*podanePole/podanaKrotsza);
		przekatna.setText(String.valueOf(dluzszaPrzekatna));
		
		double bokA = Math.sqrt((Math.pow(podanaKrotsza/2,2))+(Math.pow(dluzszaPrzekatna/2, 2)));
		bok.setText(String.valueOf(bokA));
		
		double wysokoscRombu = podanePole/bokA;
		wysokosc.setText(String.valueOf(wysokoscRombu));
		
		double promienOkregu = podanePole/2*bokA;
		promien.setText(String.valueOf(promienOkregu));
		
		double obwodRombu = 4*bokA;
		obwod.setText(String.valueOf(obwodRombu));
		} catch (Exception e1) {
			JOptionPane.showConfirmDialog(null, "Wprowadz poprawn¹ wartoœæ!", "ALERT", JOptionPane.CANCEL_OPTION);
			
		}
	}

	public void initUI() {
		this.setLayout(new BorderLayout());
		
		gornyPanel.add(przekatna_podpis);
		gornyPanel.add(przekatna);
		przekatna.setColumns(20);
		
		gornyPanel.add(bok_podpis);
		gornyPanel.add(bok);
		bok.setColumns(20);
		
		gornyPanel.add(wysokosc_podpis);
		gornyPanel.add(wysokosc);
		przekatna.setColumns(20);
		
		gornyPanel.add(promien_podpis);
		gornyPanel.add(promien);
		przekatna.setColumns(20);
		
		gornyPanel.add(obwod_podpis);
		gornyPanel.add(obwod);
		przekatna.setColumns(20);
		
		this.add(dane);
		dane.addActionListener(this);
		
		this.add(gornyPanel, BorderLayout.NORTH);
		
		this.setTitle("Kalkulator wymiarów rombu");
		gornyPanel.setLayout(new GridLayout(5, 1));
		this.setSize(440, 210);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		przekatna.setEditable(false);
		bok.setEditable(false);
		wysokosc.setEditable(false);
		promien.setEditable(false);
		obwod.setEditable(false);
		
	}
}
