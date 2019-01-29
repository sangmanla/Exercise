package search;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/count-luck/problem
 * 
 * @author sam
 */
public class CountLuck {
    static int curRow = -1, curCol = -1, globalCount = 0, expectedCnt = 0;
    private static char startCharacter = 'M', endCharacter = '*', blockCharacter = 'X';
    private static Stack<Point> stack = new Stack<Point>();
    
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	IntStream.range(0, Integer.parseInt(scan.nextLine())).forEach(cnt -> {
	    initPoints();
	    char[][] matrix = scanMatrix(scan);
	    expectedCnt = Integer.parseInt(scan.nextLine());
	    System.out.println(compareWandTimes(matrix) ? "Impressed" : "Oops");
	});
	scan.close();
    }

    private static boolean compareWandTimes(char[][] matrix) {
	boolean result = false;
	Point curPoint = new Point(curRow, curCol, matrix);
	result = checkup(matrix, curPoint);
	return result;
    }

    private static boolean checkup(char[][] matrix, Point cur) {
	while(!cur.isEnd()){
	    if(cur.hasTurningPoint) globalCount++;
	    if(cur.up!=null) checkup(matrix, cur.up);
	    if(cur.down!=null) checkup(matrix, cur.down);
	    if(cur.left!=null) checkup(matrix, cur.left);
	    if(cur.right!=null) checkup(matrix, cur.right);
	}
	if(cur.isEnd() && globalCount == expectedCnt) {
	    return true;
	}
	return false;
    }

    private static void initPoints() {
	curRow = -1;
	curCol = -1;
	globalCount = 0;
	expectedCnt = 0;
    }

    private static char[][] scanMatrix(Scanner scan) {
	String[] pos = scan.nextLine().split(" ");

	int rowLen = Integer.parseInt(pos[0]);
	int colLen = Integer.parseInt(pos[1]);

	char[][] matrix = new char[rowLen][colLen];

	for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
	    String line = scan.nextLine();
	    setPoints(line, rowIdx);
	    matrix[rowIdx] = line.toCharArray();
	}

	return matrix;
    }

    private static void setPoints(String line, int rowIdx) {
	int colIdx = line.indexOf(startCharacter);
	if (colIdx >= 0) {
	    curRow = rowIdx;
	    curCol = colIdx;
	}
    }
}
class Point{
    public Point(int row, int col, char[][] matrix){
	this.row = row;
	this.col = col;
	this.cur = matrix[row][col];
	setNeighbors(row, col, matrix);
    }
    
    public int row, col;
    public char cur;
    public Point up, right, down, left;
    public boolean hasTurningPoint = false;
    
    public boolean isEnd(){
	return cur == '*';
    }
    
    private void setNeighbors(int row, int col, char[][] matrix) {
	int count = 0;
	if(row-1 >= 0 && matrix[row-1][col] == '.') {
	    down = new Point(row-1, col, matrix);
	    count++;
	}
	if(row+1 < matrix.length && matrix[row+1][col] == '.'){
	    up = new Point(row+1, col, matrix);
	    count++;
	}
	if(col-1 >= 0 && matrix[row][col-1] == '.'){
	    left = new Point(row, col-1, matrix);
	    count++;
	}
	if(col+1 < matrix[0].length && matrix[row][col+1] == '.'){
	    right = new Point(row, col+1, matrix);
	    count++;
	}
	
	if(count>=2) hasTurningPoint = true;
    }
}