
import java.io.Serializable;
import java.lang.Object;

import java.awt.Point;

public class Point1  {
	
	private int x;
	private int y;
	private String letter;
	
	Point1(String letter,int x, int y){
		this.letter=letter;
		this.x=x;
		this.y=y;
		
		
	}
	
	Point1(){
		
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
	
	
	double calculateDistance(Point1 p1, Point1 p2) {
		
		double Dx = Math.abs(p1.getX()-p2.getX());
		double Dy = Math.abs(p1.getY()-p2.getY());
		
		double dist = Math.sqrt(Dx*Dx+ Dy*Dy);
		
		return dist;
		
	}
	
	String getLetter() {
		return this.letter;
	}
}
