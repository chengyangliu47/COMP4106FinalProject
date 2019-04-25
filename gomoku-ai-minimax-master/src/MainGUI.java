import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int difficulty;
	private int computerStarts;
	
	private JPanel boardPanel;
	private final JPanel setupPanel;
	private final JPanel difficultyPanel;
	private final JPanel startingPlayerPanel;
	
	
	private final JButton buttonStart;
	private final JRadioButton rbNormal;
	private final JRadioButton rbHard;
	
	private final JRadioButton rbHuman;
	private final JRadioButton rbComputer;
	private final JRadioButton rbComputer1VsComputer2;
	private final JRadioButton rbComputer2VsComputer1;
	private final JRadioButton rbHerusticVsComputer;
	private final JRadioButton rbComputerVsHerustic;
	
	private final ButtonGroup bgDifficulty ;
	private final ButtonGroup bgStartingPlayer;
	
	private final JLabel taDifficulty;
	private final JLabel taStartingPlayer;
	
	public MainGUI(int width, int height, String title) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setupPanel = new JPanel();
		setupPanel.setLayout(new BoxLayout(setupPanel, BoxLayout.PAGE_AXIS));
		difficultyPanel = new JPanel();
		startingPlayerPanel = new JPanel();
		
		buttonStart = new JButton("Start Game");
		
		rbNormal = new JRadioButton("Normal (Faster)");
		rbHard = new JRadioButton("Hard (Slower)");
		
		rbHuman = new JRadioButton("Human");
		rbComputer = new JRadioButton("Computer AI");
		rbHerusticVsComputer = new JRadioButton("Herustic AI(Herustic vs AI)");
		rbComputerVsHerustic = new JRadioButton("Computer AI(Herustic vs AI)");
		rbComputer1VsComputer2 = new JRadioButton("Computer1 AI(AI vs AI)");
		rbComputer2VsComputer1 = new JRadioButton("Computer2 AI(AI vs AI)");
		
		bgDifficulty = new ButtonGroup();
		bgStartingPlayer = new ButtonGroup();
		
		bgDifficulty.add(rbNormal);
		bgDifficulty.add(rbHard);
		
		bgStartingPlayer.add(rbHuman);
		bgStartingPlayer.add(rbComputer);
		bgStartingPlayer.add(rbComputer1VsComputer2);
		bgStartingPlayer.add(rbComputer2VsComputer1);
		bgStartingPlayer.add(rbHerusticVsComputer);
		bgStartingPlayer.add(rbComputerVsHerustic);
		
		taDifficulty = new JLabel("Difficulty: ");
		taStartingPlayer = new JLabel("starts first.");
		
		rbNormal.setSelected(true);
		rbComputer.setSelected(true);
		
		difficultyPanel.add(taDifficulty);
		difficultyPanel.add(rbNormal);
		difficultyPanel.add(rbHard);
		
		startingPlayerPanel.add(rbComputer);
		startingPlayerPanel.add(rbHuman);
		startingPlayerPanel.add(rbComputer1VsComputer2);
		startingPlayerPanel.add(rbComputer2VsComputer1);
		startingPlayerPanel.add(rbHerusticVsComputer);
		startingPlayerPanel.add(rbComputerVsHerustic);
		startingPlayerPanel.add(taStartingPlayer);
		
		setupPanel.add(difficultyPanel);
		setupPanel.add(startingPlayerPanel);
		setupPanel.add(buttonStart);
		
		add(setupPanel);
		pack();
	}
	/*
	 * 	Reads components to fetch and return the chosen settings.
	 */
	public Object[] fetchSettings() {
		if( rbHard.isSelected() ) {
			difficulty = 4;
		} else difficulty = 3;
		
		if(rbHuman.isSelected()) {
			computerStarts = 1;
		}
		if(rbComputer.isSelected()) {
			computerStarts = 2;
		}
		if(rbHerusticVsComputer.isSelected()) {
			computerStarts = 3;
		}
		if(rbComputerVsHerustic.isSelected()) {
			computerStarts = 4;
		}
		if(rbComputerVsHerustic.isSelected()) {
			computerStarts = 5;
		}
		if(rbComputerVsHerustic.isSelected()) {
			computerStarts = 6;
		}
		Object[] x = {difficulty, computerStarts};
		return x;
	}
	public void listenGameStartButton(ActionListener listener) {
		buttonStart.addActionListener(listener);
	}
	public void attachBoard(JPanel board) {
		boardPanel = board;
	}
	public void showBoard() {
		setContentPane(boardPanel);
		invalidate();
		validate();
		pack();
	}
	
	
}
