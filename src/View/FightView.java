package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import Controller.UserControl;
import Model.FightModel;

@SuppressWarnings("serial")
public class FightView extends JPanel implements ActionListener, KeyListener {
	
	
	
	Timer tm = new Timer(5, this);
	
	public FightView(){
		
			tm.start();
			addKeyListener(this);
			//enable key listener
			setFocusable(true);
			//not using shift or tab etc
			setFocusTraversalKeysEnabled(false);
		}

	public void Pause(int x){
		
		repaint();
		try {
			TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 100 * FightModel.getInstance().getL(), 100 * FightModel.getInstance().getL() + 100);
			//get percentages
			playerHpPercent();
			enemyHpPercent();
			expPercentage();

			if(FightModel.getInstance().getChange() == false)
			{
				g.setColor(Color.BLACK);
				g.fillRect(0,  ((100 * FightModel.getInstance().getL()/10) * 7),  100 * FightModel.getInstance().getL(),  ((100 * FightModel.getInstance().getL() / 10) * 3));
				//*** TOP HALF ***
				//hp top
				g.fillRect(10 * FightModel.getInstance().getL(), 12 * FightModel.getInstance().getL(), 5 * FightModel.getInstance().getL(), 4 * FightModel.getInstance().getL());
				//sidebar top
				g.fillRect(6 * FightModel.getInstance().getL() ,12 * FightModel.getInstance().getL(), (int)(1.5 * FightModel.getInstance().getL()), (int)(8.5 * FightModel.getInstance().getL()));
				//basebar top
				g.fillRect(6 * FightModel.getInstance().getL(), 20 * FightModel.getInstance().getL(), 33 * FightModel.getInstance().getL(), (int)(0.5 * FightModel.getInstance().getL()));
				//under HP top
				g.fillRect(15 * FightModel.getInstance().getL(), (int)(15.5 * FightModel.getInstance().getL()), 21 * FightModel.getInstance().getL(), (int)(0.5 * FightModel.getInstance().getL()));
				//right hand bar top
				g.fillRect(35* FightModel.getInstance().getL(), 12 * FightModel.getInstance().getL(), 2 * FightModel.getInstance().getL(), 4 * FightModel.getInstance().getL());
				//end triangle top
				g.fillRect(35 * FightModel.getInstance().getL(), (int)(18.5 * FightModel.getInstance().getL()), 1 * FightModel.getInstance().getL(), 2 * FightModel.getInstance().getL());
				g.fillRect(36 * FightModel.getInstance().getL(), 19 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL());
				g.fillRect(37 * FightModel.getInstance().getL(), (int)(19.5 * FightModel.getInstance().getL()), 1 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL());
				//*** BOTTOM HALF ***
				//hp bottom
				g.fillRect(65  * FightModel.getInstance().getL(), 52 * FightModel.getInstance().getL(), 5 * FightModel.getInstance().getL(), 4 * FightModel.getInstance().getL());
				//sidebar bot
				g.fillRect(94 * FightModel.getInstance().getL(), 52 * FightModel.getInstance().getL(), (int)(1.5 * FightModel.getInstance().getL()), (int)(13.5 * FightModel.getInstance().getL()));
				//basebar bot
				g.fillRect(61 * FightModel.getInstance().getL(), 65 * FightModel.getInstance().getL(), 33 * FightModel.getInstance().getL(), (int)(0.5 * FightModel.getInstance().getL()));
				//under HP bot
				g.fillRect(70 * FightModel.getInstance().getL(), (int)(55.5 * FightModel.getInstance().getL()), 21 * FightModel.getInstance().getL(), (int)(0.5 * FightModel.getInstance().getL()));
				//right hand bar bot
				g.fillRect(90 * FightModel.getInstance().getL(), 52 * FightModel.getInstance().getL(), 2 * FightModel.getInstance().getL(), 4 * FightModel.getInstance().getL());
				//end triangle bot
				g.fillRect(64 * FightModel.getInstance().getL(), (int)(63.5 * FightModel.getInstance().getL()), 1 * FightModel.getInstance().getL(), 2 * FightModel.getInstance().getL());
				g.fillRect(63 * FightModel.getInstance().getL(), 64 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL());
				g.fillRect(62 * FightModel.getInstance().getL(), (int)(64.5 * FightModel.getInstance().getL()), 1 * FightModel.getInstance().getL(), 1 * FightModel.getInstance().getL());
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(3 * FightModel.getInstance().getL(), 73 * FightModel.getInstance().getL(), 94 * FightModel.getInstance().getL(), 20 * FightModel.getInstance().getL());

				Image opponentImage = new ImageIcon(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getFrontPic()).getImage();
				g.drawImage(opponentImage, 95 * FightModel.getInstance().getL() - 300, 0, this);
				Image playerpic = new ImageIcon(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getBackPic()).getImage();
				g.drawImage(playerpic, 5 * FightModel.getInstance().getL(), 70 * FightModel.getInstance().getL() - 300, this);
				g.setColor(Color.black);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 4 * FightModel.getInstance().getL()));
				g.drawString(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getPokemon(), 6 * FightModel.getInstance().getL(), 5 * FightModel.getInstance().getL());
				g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getPokemon(), 65 * FightModel.getInstance().getL(), 45 * FightModel.getInstance().getL());
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 3 * FightModel.getInstance().getL()));
				
				g.setColor(Color.black);
				if(FightModel.getInstance().getMainScreen() == true)
				{
					g.fillOval(FightModel.getInstance().getxPos() * FightModel.getInstance().getL(), FightModel.getInstance().getyPos() * FightModel.getInstance().getL(), (int)(1.5 * FightModel.getInstance().getL()), (int)(1.5 * FightModel.getInstance().getL()));
					g.drawString("FIGHT", FightModel.getInstance().getWritingLeft(), FightModel.getInstance().getUpperWriting());
					g.drawString("POKEMON", FightModel.getInstance().getWritingRight(), FightModel.getInstance().getUpperWriting());
					g.drawString("PACK", FightModel.getInstance().getWritingLeft(), FightModel.getInstance().getLowerWriting());
					g.drawString("RUN", FightModel.getInstance().getWritingRight(), FightModel.getInstance().getLowerWriting());
				}
				else if(FightModel.getInstance().getMoves() == true)
				{
					g.fillOval(FightModel.getInstance().getxPos() * FightModel.getInstance().getL(), FightModel.getInstance().getyPos() * FightModel.getInstance().getL(), (int)(1.5 * FightModel.getInstance().getL()), (int)(1.5 * FightModel.getInstance().getL()));
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMove(0), FightModel.getInstance().getWritingLeft(), FightModel.getInstance().getUpperWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMove(1), FightModel.getInstance().getWritingRight(), FightModel.getInstance().getUpperWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMove(2), FightModel.getInstance().getWritingLeft(), FightModel.getInstance().getLowerWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMove(3), FightModel.getInstance().getWritingRight(), FightModel.getInstance().getLowerWriting());
					g.setFont(new Font("Comic Sans MS", Font.BOLD, 2 * FightModel.getInstance().getL()));

					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePP(0) + " / " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePPMax(0), FightModel.getInstance().getWritingLeft() + FightModel.getInstance().getPpWidth(), FightModel.getInstance().getUpperWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePP(1) + " / " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePPMax(1), FightModel.getInstance().getWritingRight() + FightModel.getInstance().getPpWidth(), FightModel.getInstance().getUpperWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePP(2) + " / " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePPMax(2), FightModel.getInstance().getWritingLeft() + FightModel.getInstance().getPpWidth(), FightModel.getInstance().getLowerWriting());
					g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePP(3) + " / " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getMovePPMax(3), FightModel.getInstance().getWritingRight() + FightModel.getInstance().getPpWidth(), FightModel.getInstance().getLowerWriting());

				}
				else //if(FightController.speech == true)
				{
					g.drawString(FightModel.getInstance().getSpoken(), FightModel.getInstance().getWritingLeft(), FightModel.getInstance().getUpperWriting());
				}
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 3 * FightModel.getInstance().getL()));

				g.drawString("L "+ FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getLevel(), 20 * FightModel.getInstance().getL(), 10 * FightModel.getInstance().getL());

				g.setColor(Color.blue);
				g.fillRect(65 * FightModel.getInstance().getL(), (int)(63.5 * FightModel.getInstance().getL()), (int)(FightModel.getInstance().getExpPercent() * (29 / 10)), (int)(1.5 * FightModel.getInstance().getL()));

				if(FightModel.getInstance().getEnemyHPPercent() > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(15 * FightModel.getInstance().getL(), (int)(12.5 * FightModel.getInstance().getL()), (int)(FightModel.getInstance().getEnemyHPPercent() * (0.2 * FightModel.getInstance().getL())), 2 * FightModel.getInstance().getL());

				g.setColor(Color.BLACK);
				g.drawString("L " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getLevel(), (int)(77.5 * FightModel.getInstance().getL()), 50 * FightModel.getInstance().getL());
				g.drawString(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHP() + "  /  " + FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHPTotal(), 73 * FightModel.getInstance().getL(), 60 * FightModel.getInstance().getL());
				g.setColor(Color.yellow);
				g.drawString("HP:", 10 * FightModel.getInstance().getL(), 15 * FightModel.getInstance().getL());
				g.drawString("HP:", 65 * FightModel.getInstance().getL(), 55 * FightModel.getInstance().getL());
				if(FightModel.getInstance().getPlayerHPPercent() > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(70 * FightModel.getInstance().getL(), 53 * FightModel.getInstance().getL(), (int)(FightModel.getInstance().getPlayerHPPercent() * (0.2 * FightModel.getInstance().getL())) , 2 * FightModel.getInstance().getL());
			}else{
				
				
			//CHANGE POKEMON
			g.setColor(Color.BLACK);
			g.fillOval(3 * FightModel.getInstance().getL(), FightModel.getInstance().getyPos() * FightModel.getInstance().getL(), (int)(1.5 * FightModel.getInstance().getL()), (int)(1.5 * FightModel.getInstance().getL()));
			int y = 18 * FightModel.getInstance().getL();
			for(int x = 0; x < FightModel.getInstance().getPlayerParty().size(); x++)
			{
				g.setColor(Color.BLACK);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 4 * FightModel.getInstance().getL()));
				g.drawString("CLOSE", 10 * FightModel.getInstance().getL(), 78 * FightModel.getInstance().getL());
				g.drawString(FightModel.getInstance().getPlayerParty().get(x).getName(), 10 * FightModel.getInstance().getL(), y);
				g.fillRect(65 * FightModel.getInstance().getL(), y - 3 * FightModel.getInstance().getL(), 5 * FightModel.getInstance().getL(), 3 * FightModel.getInstance().getL());
				g.fillRect(90 * FightModel.getInstance().getL(), y - 3 * FightModel.getInstance().getL(), 2 * FightModel.getInstance().getL(), 3 * FightModel.getInstance().getL());
				g.fillRect(65 * FightModel.getInstance().getL(), y , 27 * FightModel.getInstance().getL(), (int)(0.5 * FightModel.getInstance().getL()));
				g.drawString("L " + FightModel.getInstance().getPlayerParty().get(x).getLevel(), 47 * FightModel.getInstance().getL(),y);
				g.drawString(FightModel.getInstance().getPlayerParty().get(x).getHP() + " / " + FightModel.getInstance().getPlayerParty().get(x).getHPTotal(),  75 * FightModel.getInstance().getL(), y - 4 * FightModel.getInstance().getL());
				g.setFont(new Font("Comic Sans MS", Font.PLAIN, 2 * FightModel.getInstance().getL()));
				g.setColor(Color.YELLOW);
				g.drawString("HP:", 66 * FightModel.getInstance().getL(), y - (int)(0.5 * FightModel.getInstance().getL()));
				if(FightModel.getInstance().getPlayerParty().get(x).getHP() > 40)
				{
					g.setColor(Color.GREEN);
				}
				else
				{
					g.setColor(Color.red);
				}
				g.fillRect(70 * FightModel.getInstance().getL(), y - 2 * FightModel.getInstance().getL(), (int)(HpPercent(x) * 0.2 * FightModel.getInstance().getL()), 2 * FightModel.getInstance().getL());
				y = y + 10 * FightModel.getInstance().getL();

			}
			
			}
			

		}
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}

		public void keyPressed(KeyEvent e)
		{
			int c = e.getKeyCode();
			System.out.println("KEYEVENT");
			UserControl.keyPress(c);
		}

		public void keyTyped(KeyEvent e)
		{

		}
		public void keyReleased(KeyEvent e)
		{

		}
		public void playerHpPercent()
		{
			double x = ((double)FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHP() / (double)FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getHPTotal()) * 100;

			FightModel.getInstance().setPlayerHPPercent((int)x); 
		}

		public int HpPercent(int z)
		{
			double x = ((double)FightModel.getInstance().getPlayerParty().get(z).getHP() / (double)FightModel.getInstance().getPlayerParty().get(z).getHPTotal()) * 100;

			int temppercent = (int)x;
			return temppercent; 
		}

		public void enemyHpPercent()
		{
			double x = ((double)FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getHP() / (double)FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getHPTotal()) * 100;
			FightModel.getInstance().setEnemyHPPercent( (int)x);
		}

		public void expPercentage()
		{
			double x = ((double)FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getXP() / (double)FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getXPTotal()) * 100;
			FightModel.getInstance().setExpPercent((int)x);
		}

}
