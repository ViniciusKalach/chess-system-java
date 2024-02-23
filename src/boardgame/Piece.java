package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	// Método que retorna movimentos posssiveis representados por uma matriz bidimensional de booleanos.
	// A implementação específica deve ser fornecida por classes que herdam esta classe abstrata.
	public abstract boolean[][] possibleMoves();
	
	// Método concreto que utiliza o método abstrato (Hook methods)
	// Esse método valida se há algum movimento possivel em tal posição
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	// '' (Hook methods)
	// Esse método retorna true ou false conforme a possibilidade de movimento
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i < mat.length; i++) {
			for (int j=0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
