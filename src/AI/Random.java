package AI;

public class Random {

	Controller.RandomGen RM = new Controller.RandomGen();
	int choice;
	public int generateRandomChoice(boolean struggle, boolean changeable)
	{
		
		/*
		 * Creates a random choice for the move or change
		 * This is the RANDOM part of the AI
		 */
		if(struggle == false && changeable == true)
		{
			choice = RM.GenerateNumber(100);
			if(choice < 20)
			{
				choice = 1;
			}
			else if(choice >= 20 && choice < 40)
			{
				choice = 2;

			}
			else if(choice >= 40 && choice < 60)
			{
				choice = 3;
			}
			else if(choice >= 60 && choice < 80)
			{
				choice = 4;
			}
			else if(choice >=80)
			{
				choice = 6;
			}
		}
		else if(struggle == false && changeable == false)
		{
			choice = RM.GenerateNumber(80);
			if(choice < 20)
			{
				choice = 1;
			}
			else if(choice >= 20 && choice < 40)
			{
				choice = 2;
			}
			else if(choice >= 40 && choice < 60)
			{
				choice = 3;
			}
			else if(choice >= 80)
			{
				choice = 4;
			}
		}
		else if(struggle == true && changeable == true)
		{
			choice = RM.GenerateNumber(100);
			if(choice < 80)
			{
				choice = 5;
			}
			else if(choice >= 80)
			{
				choice = 6;
			}
		}
		else if(struggle == true && changeable == false)
		{
			choice = 6;
		}
		System.out.println(choice);
		return choice;


	}
}
