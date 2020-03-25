package Game15So_v2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Search {
	// Global variable
	static int count = 0;
	public static void main(String[] args) {
		long timeStart, timeStop;
		
		State Start, Goal;
		Tuple O = null;
		
		PriorityQueue<Tuple> Open;
		
		
		Map<String, State> Closed = new HashMap<>();
		
		Goal = new State();
		Start = new State();
		
		Random rand = new Random();
		
		for (int i =0; i<10; i++) {
			Operator op = new Operator(rand.nextInt(4));
			State n = op.Move(Start);
			if (n != null) Start = n;
		}
		System.out.println("Trang thai bat dau: ");
		Start.Print();
		
		System.out.println("Trang thai ket thuc: ");
		Goal.Print();
		
		//System.out.println(BandB(Start));
		
		//Open = new ArrayList<State>();
		// Thay vao đó mình sử dụng hàng đợi ưu tiên để ưu tiên xử lý hướng mình cho là ra kết quả nhanh nhất
		Open = new PriorityQueue<Tuple>(new TupleComparator());
		
		
		
		// Bat dau: 
		timeStart = System.nanoTime();
		
		// Step 1:
		Open.add(new Tuple(Start, 0));
		Closed.put(Start.getKey(), Start);
		
		while (true) {
			// Step 2:
			if (Open.isEmpty()) break;
			
			// Step 3
			O = Open.poll();
			
			// Step 4
			if (Equal(O.getState(), Goal)) break;
			
			// Step 5:			
			
			for (int i = 0; i < 4; i++) {			
				Operator op = new Operator(i);
				State child = op.Move(O.getState());
				if (child == null) continue;		
				if (In(child, Closed)) continue;		
				int dis = BandB(child);
				
				child.Cha = O.getState();
				child.Me = op;
				
				Open.add(new Tuple(child, dis));
				Closed.put(child.getKey(), child);
		}
	}
		
		if (Equal(O.getState(), Goal)) {
			System.out.println("Tim kiem thanh cong");
			timeStop = System.nanoTime();
			System.out.println("So do loi giai: ");
			PrintResult(O.getState());
			System.out.println("Thoi gian giai: " + ((timeStop - timeStart) / 1000) / 1000.0 + "ms");
			System.out.println("So buoc di chuyen: " + count);
		}
		
		else {
			System.out.println("Khong tim thay ket qua nao ca");
		}
}

	private static void PrintResult(State o) {
		// TODO Auto-generated method stub
		if (o.Cha != null) {
			count += 1;
			PrintResult(o.Cha);
			switch(o.Me.i) {
			case 0: System.out.println("Up"); break;
			case 1: System.out.println("Down"); break;
			case 2: System.out.println("Left"); break;
			case 3: System.out.println("Right"); break;
			}
		}
		o.Print();
	}

	private static boolean In(State child, Map<String, State> closed) {
		// TODO Auto-generated method stub
		
		return closed.containsKey(child.getKey());
	}

	private static boolean Equal(State o, State goal) {
		// TODO Auto-generated method stub
		if (o == null || goal == null) return false;
		for (int i = 0; i< 4; i++) {
			for (int j =0; j<4; j++) {
				if (o.d[i][j] != goal.d[i][j]) return false;
			}
		}
		return true;
	}
	
	
	// Thu dung cai Branch and Bound thu
	private static int BandB(State o) {
		// Dem so o dung sai vi tri (khong ke o trong)
		int count = 0;
		for (int i = 0; i<4; i++) {
			for (int j = 0; j <4; j++) {
				if (o.d[i][j] != 0 && o.d[i][j] != (i * 4 + j + 1) % 16){
					count += 1;
				}
			}
		}
		return count;
	} 
}


class TupleComparator implements Comparator<Tuple>{
	// Sap xep theo thu tu tang dan theo chi so
	@Override
	public int compare(Tuple e1, Tuple e2) {
		if (e1.getPriority() < e2.getPriority())
			return -1;
		else if (e1.getPriority() > e2.getPriority())
			return 1;
		return 0;
	}
}


//Dinh nghia them cai class chua key, value de them vao PriorityQueue check
// Lam theo mot vi du tren Geeks
class Tuple{
	State state;
	int priority;
	
	//Getter
	int getPriority() {
		return this.priority;
	}
	
	State getState() {
		return this.state;
	}
	
	//Constructor
	public Tuple(State state, int priority) {
		this.state = state;
		this.priority = priority;
	}
}

/*Chu minh lam tiep:
 *  
 * Chuyen kieu du lieu cua Open sang kieu PriorityQUeue, uu tien giai phap co chi phi xu ly thap nhat
 * Loang theo huong do va xem ket qua thuc hien duoc no nhu the nao.
 * 
 * */

