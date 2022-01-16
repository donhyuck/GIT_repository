package board.dao;

abstract public class Dao {
	// 상속관계에서는 가져다 쓸 수 있음
	protected int lastId;

	Dao() {
		lastId = 0;
	}

	public int getLastId() {
		return lastId;
	}

	public int getNewId() {
		return lastId + 1;
	}
}
