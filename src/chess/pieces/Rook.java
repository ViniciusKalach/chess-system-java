package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Verificar ** ACIMA ** 
		// A variavel Position p recebe coluna e a linha (-1) da peça
		// (-1 porque estamos analisando as posições acima da linha da peça.
		p.setValues(position.getRow() - 1, position.getColumn());
		// enquanto posição existe e não há peça lá, a peça pode (true) ser movida para lá.
		while (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() -1);
		}
		// Se a posição existe e há peça ADVERSÁRIA nela, a peça ainda pode (true) ser movida para lá.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Verificar ** ESQUERDA **
		// A variavel Position p recebe coluna(-1) e a linha da peça
		// (-1 porque estamos analisando as posições a esquerda da peça)
		p.setValues(position.getRow(), position.getColumn() -1);
		// enquanto posição existe e não há peça lá, a peça pode (true) ser movida para lá.
		while (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		// Se a posição existe e há peça ADVERSÁRIA nela, a peça ainda pode (true) ser movida para lá.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}	
		
		// Verificar ** DIREITA  **
		// A variavel Position p recebe coluna(+1) e a linha da peça
		// (+1 porque estamos analisando as posições a direita da peça)
		p.setValues(position.getRow(), position.getColumn() +1);
		// enquanto posição existe e não há peça lá, a peça pode (true) ser movida para lá.
		while (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		// Se a posição existe e há peça ADVERSÁRIA nela, a peça ainda pode (true) ser movida para lá.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		// Verificar ** ABAIXO ** 
		// A variavel Position p recebe coluna e a linha (+1) da peça
		// (+1 porque estamos analisando as posições abaixo da linha da peça.
		p.setValues(position.getRow() + 1, position.getColumn());
		// enquanto posição existe e não há peça lá, a peça pode (true) ser movida para lá.
		while (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() +1);
		}
		// Se a posição existe e há peça ADVERSÁRIA nela, a peça ainda pode (true) ser movida para lá.
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
