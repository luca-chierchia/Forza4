package java_project;

import java.util.Scanner;

public class Forza4 {
	private char[][] f4 = new char[6][7];
	private int moves = 0;						// conto le mosse effettuate
	private boolean gameIsEnd = false; 			// utilizzo un booleano per controllare se posso posizionare la pedina nella posizione desiderata
	
	Forza4() {
		System.out.println("Hai iniziato una partita a Forza 4!\n");
		for(int i = 0; i < 6;i++) {
			for(int j = 0; j < 7; j++) {
				this.f4[i][j] = '0';
			}
		}
	}
	
	public void setGameState() {
		this.gameIsEnd = true;
	}
	

	
	public void stampaF4() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print("\t" + this.f4[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	public boolean fly(int row, int col) {
		if(row == 5)
			return false;
		if(this.f4[row+1][col] == '0')
			return true;
		else
			return false;
	}
	
	public boolean isEmpty(int row, int col) {
		if(this.f4[row][col] == '0')
			return true;
		else return false;
	}
	
	public boolean isOutOfRange(int row, int col) {
		if((row <0 && row >5) || (col<0 && col >6))
			return true;
		else return false;
	}
	
	public boolean movePlayer(int row, int col, char pedina) {
		if(this.fly(row, col) || this.isOutOfRange(row, col)) {
			System.out.println("Non puoi mettere una pedina in questa posizione");
			return false;
		}
		else if(this.isEmpty(row,col)) {
			this.f4[row][col] = pedina;
			moves++;
			return true;
		}
		else {
			System.out.println("Mossa non compiuta");
			return false;
		}
		
	}
	
	 public boolean checkIfWin(char pedina) {
		 if(this.checkRow(pedina) || this.checkCol(pedina))
			 return true;
		 else return false;
	
	}
	 
	 public boolean checkRow(char pedina) {
		    int count = 0;
		    for (int i = 0; i < 6; i++) {
		        for (int j = 0; j < 7; j++) {
		            if (this.f4[i][j] == pedina) {
		                count++;
		                if (count == 4) {
		                    return true;
		                }
		            } else {
		                count = 0;  // Resetta il contatore se trovi una pedina diversa
		            }
		        }
		        count = 0;  // Resetta il contatore all'inizio di ogni riga
		    }
		    return false;
		}
	 
	 public boolean checkCol(char pedina) {
		 int count = 0;
		 for(int i = 0; i < 7 ;i++ ) {
			 for(int j = 0; j < 6; j++) {
				 if(this.f4[j][i] == pedina) {
					 count++;
					 if(count == 4)
						 return true;
					 
				 }
				 else {
					 count = 0;
				 }
			 }
			 count = 0;
		 }
		 return false;
	 }

	
	public static void main(String[] args) {
		Forza4 g1 = new Forza4();
		g1.stampaF4();
		char pedina = ' ';
		boolean turn = true;
		int x,y = 0;
		Scanner sc = new Scanner(System.in);
		
		while(!g1.gameIsEnd) {
			
			 if (turn) {
		            System.out.println("Turno del giocatore 1 (X)");
		            pedina = 'X';		            	
		        } else {
		            System.out.println("Turno del giocatore 2 (O)");
		            pedina = 'O';		   
		        }
			 System.out.print("Inserisci la riga (da 1 a 6) e la colonna (da 1 a 7): ");
			 	x = sc.nextInt()  -1; 
		        y = sc.nextInt() - 1; // Sottrai 1 per adattarti all'indice dell'array

		        if (g1.movePlayer(x, y, pedina)) {
		            g1.stampaF4();
		            if(g1.checkIfWin(pedina)) {
		            	System.out.println("Giocatore("+ pedina +") HA VINTO!!");
		            	break;
		            }
		            turn = !turn; // Cambia il turno solo se il movimento è valido
		        }
		        
		    }
		    sc.close();
		}
}
		
		
