package sig16_hhl36_SpaceExplorer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class setupGame {

	private JFrame frame;
	private JTextField tfshipname;
	private JTextField tfcrewname;
	private GameManager manager;
	private String btn1;
	private String btn2;
	private String btn3;
	private String btn4;
	private int index;


	/**
	 * Launch the application.
	 */
	public setupGame(GameManager incomingManager){
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	public void closeWindow() {
		frame.dispose();
	}
	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}
	public void setcrewname(String name) {
		manager.setcrewname(name);
	}
	public void setshipname(String name) {
		manager.setshipname(name);
	}
	public void setStringButton() {
		if(manager.getcrewsize() == 0) {
			btn1 = "";
			btn2 = "";
			btn3 = "";
			btn4 = "";
		} else {
			index = -1;
			for (CrewMember member: manager.crew_members) {
				index += 1;
				if(index == 0) {
					btn1 = member.viewtype();
					btn2 = "";
					btn3 = "";
					btn4 = "";		
				}
				else if (index == 1) {
					btn2 = member.viewtype();
					btn3 = "";
					btn4 = "";	
				} else if(index == 2) {
					btn3 = member.viewtype();
				} else {
					btn4 = member.viewtype();
				}
		}
		}
	}
	/**
	 * Create the application.
	 */
	public setupGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Space Explorer Setup Screen");
		frame.setBounds(100, 100, 796, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToSpace = new JLabel("Welcome to Space Explorer!");
		lblWelcomeToSpace.setBounds(30, 23, 210, 38);
		lblWelcomeToSpace.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblWelcomeToSpace);
		
		JLabel lblWhatIsThe = new JLabel("What is the crew name?");
		lblWhatIsThe.setBounds(30, 50, 172, 32);
		frame.getContentPane().add(lblWhatIsThe);
		
		JLabel lblWhatIsThe_1 = new JLabel("What is the ship name?");
		lblWhatIsThe_1.setBounds(30, 90, 140, 16);
		frame.getContentPane().add(lblWhatIsThe_1);
		
		JLabel lblHowManyDay = new JLabel("How many day do you want?");
		lblHowManyDay.setBounds(30, 130, 172, 16);
		frame.getContentPane().add(lblHowManyDay);
		
		JLabel lblHowManyCrew = new JLabel("How many crew do you want?");
		lblHowManyCrew.setBounds(30, 180, 172, 16);
		frame.getContentPane().add(lblHowManyCrew);
		
		JButton btnCrew1 = new JButton("");
		JButton btnCrew2 = new JButton("");
		JButton btnCrew3 = new JButton("");
		JButton btnCrew4 = new JButton("");
		btnCrew1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnCrew1.getText() != "") {
				manager.crew_members.remove(0);
				setStringButton();
				btnCrew1.setText(btn1);
				btnCrew2.setText(btn2);
				btnCrew3.setText(btn3);
				btnCrew4.setText(btn4);
				}
				}
			});
		btnCrew1.setBounds(12, 459, 104, 38);
		frame.getContentPane().add(btnCrew1);
		btnCrew2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnCrew2.getText() != "") {
				manager.crew_members.remove(1);
				setStringButton();
				btnCrew1.setText(btn1);
				btnCrew2.setText(btn2);
				btnCrew3.setText(btn3);
				btnCrew4.setText(btn4);
				}
				}
			});
		
		btnCrew2.setBounds(146, 459, 104, 38);
		frame.getContentPane().add(btnCrew2);
		btnCrew3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnCrew3.getText() != "") {
				manager.crew_members.remove(2);
				setStringButton();
				btnCrew1.setText(btn1);
				btnCrew2.setText(btn2);
				btnCrew3.setText(btn3);
				btnCrew4.setText(btn4);
				}
			}
			});
		
		btnCrew3.setBounds(283, 459, 104, 38);
		frame.getContentPane().add(btnCrew3);
		btnCrew4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnCrew4.getText() != "") {
				manager.crew_members.remove(3);
				setStringButton();
				btnCrew1.setText(btn1);
				btnCrew2.setText(btn2);
				btnCrew3.setText(btn3);
				btnCrew4.setText(btn4);
				}
			}
			});
		
		
		btnCrew4.setBounds(415, 459, 104, 38);
		frame.getContentPane().add(btnCrew4);
		
		JSlider slider = new JSlider();
		slider.setBounds(361, 130, 200, 50);
		slider.setPaintTicks(true);
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setPaintLabels(true);
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(3, new JLabel("3"));
		position.put(4, new JLabel("4"));
		position.put(5, new JLabel("5"));
		position.put(6, new JLabel("6"));
		position.put(7, new JLabel("7"));
		position.put(8, new JLabel("8"));
		position.put(9, new JLabel("9"));
		position.put(10, new JLabel("10"));
		slider.setLabelTable(position);
		frame.getContentPane().add(slider);
		
		JLabel lbl_crewtype = new JLabel("");
		lbl_crewtype.setBounds(609, 253, 110, 24);
		frame.getContentPane().add(lbl_crewtype);
		
		JLabel lbl_Ability = new JLabel("");
		lbl_Ability.setBounds(615, 286, 89, 16);
		
		frame.getContentPane().add(lbl_Ability);
		JSlider slider2 = new JSlider();
		slider2.setBounds(361, 180, 200, 50);
		slider2.setPaintTicks(true);
		slider2.setMinimum(2);
		slider2.setMaximum(4);
		slider2.setPaintLabels(true);
		Hashtable<Integer, JLabel> position2 = new Hashtable<Integer, JLabel>();
		position2.put(2, new JLabel("2"));
		position2.put(3, new JLabel("3"));
		position2.put(4, new JLabel("4"));
		slider2.setLabelTable(position2);
		frame.getContentPane().add(slider2);
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				manager.setCrewSize(slider2.getValue());
				while (slider2.getValue() < manager.crew_members.size()) {
					manager.crew_members.remove(manager.crew_members.size()-1);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		
		tfshipname = new JTextField();
		tfshipname.setBounds(361, 90, 200, 22);
		frame.getContentPane().add(tfshipname);
		tfshipname.setColumns(10);
		
		tfcrewname = new JTextField();
		tfcrewname.setBounds(361, 50, 200, 22);
		frame.getContentPane().add(tfcrewname);
		tfcrewname.setColumns(10);
		
		JButton btnLazySlepper = new JButton("Lazy Sleeper");
		btnLazySlepper.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember lazyslepper = new LazySleeper();
				lbl_crewtype.setText(lazyslepper.viewtype());
				lbl_Ability.setText(lazyslepper.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(lazyslepper);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnLazySlepper.setBounds(30, 239, 104, 38);
		frame.getContentPane().add(btnLazySlepper);
		
		JButton btnHungryBoy = new JButton("Hungry Boy");
		btnHungryBoy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember hungryboy = new HungryBoy();
				lbl_crewtype.setText(hungryboy.viewtype());
				lbl_Ability.setText(hungryboy.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(hungryboy);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnHungryBoy.setBounds(178, 239, 104, 38);
		frame.getContentPane().add(btnHungryBoy);
		
		JButton btnHunk = new JButton("Hunk");
		btnHunk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember hunk = new Hunk();
				lbl_crewtype.setText(hunk.viewtype());
				lbl_Ability.setText(hunk.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(hunk);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnHunk.setBounds(320, 239, 104, 38);
		frame.getContentPane().add(btnHunk);
		
		JButton btnSeeker = new JButton("Seeker");
		btnSeeker.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember seeker = new Seeker();
				lbl_crewtype.setText(seeker.viewtype());
				lbl_Ability.setText(seeker.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(seeker);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnSeeker.setBounds(30, 316, 104, 38);
		frame.getContentPane().add(btnSeeker);
		
		JButton btnSuperman = new JButton("Superman");
		btnSuperman.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember superman = new Superman();
				lbl_crewtype.setText(superman.viewtype());
				lbl_Ability.setText(superman.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(superman);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnSuperman.setBounds(178, 316, 104, 38);
		frame.getContentPane().add(btnSuperman);
		
		JButton btnTechnician = new JButton("Techician");
		btnTechnician.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CrewMember technician = new Technician();
				lbl_crewtype.setText(technician.viewtype());
				lbl_Ability.setText(technician.getAbility());
				if (manager.crew_members.size() < manager.crewsize()) {
					manager.crew_members.add(technician);
					setStringButton();
					btnCrew1.setText(btn1);
					btnCrew2.setText(btn2);
					btnCrew3.setText(btn3);
					btnCrew4.setText(btn4);
				}
			}
		});
		btnTechnician.setBounds(320, 316, 104, 38);
		frame.getContentPane().add(btnTechnician);
		
		JLabel lblSelect = new JLabel("Selected:");
		lblSelect.setBounds(30, 414, 89, 32);
		frame.getContentPane().add(lblSelect);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(615, 478, 89, 22);
		btnStart.setBackground(Color.BLUE);
		btnStart.setForeground(Color.BLACK);
		frame.getContentPane().add(btnStart);
		
		JLabel lblCrewStatus = new JLabel("Crew Status");
		lblCrewStatus.setBounds(589, 210, 89, 32);
		frame.getContentPane().add(lblCrewStatus);
		
		JLabel lblCrewType = new JLabel("Crew Type");
		lblCrewType.setBounds(519, 247, 89, 22);
		frame.getContentPane().add(lblCrewType);
		
		JLabel lblAbility = new JLabel("Ability");
		lblAbility.setBounds(519, 286, 64, 16);
		frame.getContentPane().add(lblAbility);
		
	
		

		
	}
}
