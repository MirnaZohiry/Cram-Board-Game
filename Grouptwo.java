package algorithms;
import org.gamelink.game.Cram;
import org.gamelink.game.Algo;
import javax.swing.*;

	public class Grouptwo extends Algo{ 
    	private static String teamName = "Grouptwo"; 


	public static int[] indexIDs ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
	public static int dimension = 5;
	public static int currentPosition = 0;
	public static int[][] gameBoard ;

	public static boolean checkCell(int x , int y)
	{
		if(x == -1 || y == -1 ) return false;
		if (x >= dimension || y >= dimension) return false;

		if(gameBoard[y][x] == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public static int getYFromIndex(int indexID)
	{
		return ((indexID / dimension));
	}

	public static int getXFromIndex (int indexID)
	{
		return ((indexID % dimension));
	}

	public static int getNorthY (int y)
	{ return y;}
	public static int getNorthX (int x)
	{ return x-1;}

	public static int getSouthY (int y)
	{ return y;}
	public static int getSouthX (int x)
	{ return x+1;}

	public static int getEastY (int y)
	{ return y+1;}
	public static int getEastX (int x)
	{ return x;}

	public static int getWestY (int y)
	{ return y-1;}
	public static int getWestX (int x)
	{ return x;}


	public static String getTeamName()
	{
        return teamName;
	}

	public static void main(String[] args)
	{
        Cram game = new Cram(true);
        game.startGame(Grouptwo.class); 
	}

	public static String algorithm(Cram game){

 		gameBoard = game.getBoard();
  		boolean secondRun = false;
		String result = "";
		//JOptionPane.showMessageDialog(null, "I am starting the loop..");

		while((!secondRun ) || (currentPosition < 25)){
			
			int x = getXFromIndex(indexIDs[currentPosition]);
			int y = getYFromIndex(indexIDs[currentPosition]);
			//JOptionPane.showMessageDialog(null,"Starting ID: " + currentPosition+" with x = "+ x+ " and y = "+ y);
			if(checkCell(x,y)){
				if(checkCell(getNorthX(x),getNorthY(y))){
					currentPosition++;
					result =  ""+ y +""+x + ""+getNorthY(y) + ""+getNorthX(x);
					//JOptionPane.showMessageDialog(null,result);
					return result;
				}
				if(checkCell(getSouthX(x),getSouthY(y))){
					currentPosition++;
					result = ""+ y +""+x + ""+getSouthY(y) +""+ getSouthX(x);
					//JOptionPane.showMessageDialog(null,result);
					return result;
				}

				if(checkCell(getWestX(x),getWestY(y))){
					currentPosition++;
					result = ""+ y + ""+x +""+ getWestY(y) + ""+getWestX(x);
					//JOptionPane.showMessageDialog(null,result);
					return result;
				}
				if(checkCell(getEastX(x),getEastY(y))){
					currentPosition++;
					result = ""+ y +""+ x +""+ getEastY(y) +""+ getEastX(x);
					//JOptionPane.showMessageDialog(null,result);
					return result;
				}

			}

			//JOptionPane.showMessageDialog(null,"No Empty Cell Found for ID: " + currentPosition);
			if(currentPosition >= 25){ 
				currentPosition = 0;
				secondRun = true;
			}else{
				currentPosition++;
			}

		}
return "";
    	}
}


