package Game15So_v2;


import Game15So_v2.State;

public class Operator {
	// 0: Up
	// 1: Down
	// 2: Left 
	// 3: Right 
	int i = 0;
	
	public Operator(int i) {
		this.i = i;
	}
	
	// Ham di chuyen trang thai trong Operator
	State Move(State s) {
		switch(i) {
			case 0:
				return Up(s);
			case 1:
				return Down(s);
			case 2:
				return Left(s);
			case 3:
				return Right(s);
		}
		return null;
		
	}

	private State Right(State s) {
		// TODO Auto-generated method stub
		MyPoint pzero = GetZero(s);
		if (pzero.j > 0) {
			// Thay the trang thai 
			State ns = s.Clone();
			ns.d[pzero.i][pzero.j] = ns.d[pzero.i][pzero.j - 1];
			ns.d[pzero.i][pzero.j - 1] = 0;
			return ns;
		}
		return null;
	}

	private State Left(State s) {
		// TODO Auto-generated method stub
		MyPoint pzero = GetZero(s);
		if (pzero.j < 3) {
			// Thay the trang thai 
			State ns = s.Clone();
			ns.d[pzero.i][pzero.j] = ns.d[pzero.i][pzero.j + 1];
			ns.d[pzero.i][pzero.j + 1] = 0;
			return ns;
		}
		return null;
	}

	private State Down(State s) {
		// TODO Auto-generated method stub
		MyPoint pzero = GetZero(s);
		if (pzero.i > 0) {
			// Thay the trang thai 
			State ns = s.Clone();
			ns.d[pzero.i][pzero.j] = ns.d[pzero.i - 1][pzero.j];
			ns.d[pzero.i - 1][pzero.j] = 0;
			return ns;
		}
		return null;
	}

	private State Up(State s) {
		// TODO Auto-generated method stub
		MyPoint pzero = GetZero(s);
		if (pzero.i < 3) {
			// Thay the trang thai 
			State ns = s.Clone();
			ns.d[pzero.i][pzero.j] = ns.d[pzero.i + 1][pzero.j];
			ns.d[pzero.i + 1][pzero.j] = 0;
			return ns;
		}
		return null;
	}

	private MyPoint GetZero(State s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4 ; i++) {
			for (int j = 0 ; j < 4; j++) {
				if (s.d[i][j] == 0) {
					return new MyPoint(i, j);
				}
			}
		}
		return null;
	}
	
}

class MyPoint{
	int i, j;
	public MyPoint(int x, int y) {
		this.i = x;
		this.j = y;
	}
}


