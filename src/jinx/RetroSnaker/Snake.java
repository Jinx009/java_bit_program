package jinx.RetroSnaker;

import java.util.LinkedList;

/**
 * 
 * ���ֻࣺ������ͷ����β������¼�任�������ʷ
 * 
 * reset��change�Ǽ����¼� <br>
 * key��move���߳��¼�<br>
 * ע������֮��Ĺ�ϵ����
 * 
 * �����洢ʹ�ö��У�ÿ����Ϸ���ڶ���ֻ�洢���һ�ΰ���
 * 
 * @author Chain
 *
 */
public class Snake {

	// �ߵ��˶�����
	public static final int TURN_LEFT = 3;
	public static final int TURN_RIGHT = 1;
	public static final int TURN_UP = 0;
	public static final int TURN_DOWN = 2;

	// �������
	private State[][] sat;
	private int rows;
	private int columns;

	// ƻ��
	private Apple apple;
	// ��
	private static Snake snake;

	// ��ͷ��λ��
	private int headx;
	private int heady;
	// ��ͷ���ƶ����� 0up 1right 2down 3left
	// ��ʼΪ��
	private int dirhead = 1;

	// ��β��λ��
	private int tailx;
	private int taily;
	// ��β���ƶ����� 0up 1right 2down 3left
	// ��ʼΪ��
	private int dirtail = 1;

	// ���У����ڼ�����ʷ�任�ķ���ʱ������
	private LinkedList<int[]> lst = new LinkedList<>();

	// ���ڴ��������������Ƶ����Զ������Ϸ�ٶ�ʱ�����ݺ���ʾ�����ϵ�����
	private boolean flag;
	// ÿ����Ϸʱ������ֻ��¼���һ�ΰ���
	private boolean pkey;

	// �½�һ���߲��ֶ���
	private Snake(State[][] s) {
		if (sat == null) {
			sat = s;
			rows = sat[0].length;
			columns = sat.length;
		}
		if (apple == null)
			apple = Apple.getApple(s);
	}

	// ����ߣ��������ģʽ
	public static Snake getSnake(State[][] s) {
		if (snake == null)
			snake = new Snake(s);
		snake.init();
		return snake;
	}

	// �Ƿ�����������
	public void key(boolean f) {
		this.flag = f;
		if (!flag)
			pkey = false;
	}

	// ��ʼ���ߣ���ʼ����Ϊ3������Ϊ1
	private void init() {
		headx = 2;
		heady = 0;
		dirhead = 1;
		tailx = 0;
		taily = 0;
		dirtail = 1;

		flag = false;
		pkey = false;

		lst.clear();

		for (int i = 0; i < sat.length; i++)
			for (int j = 0; j < sat[i].length; j++)
				if (sat[i][j] == State.SNAKE)
					sat[i][j] = State.BLANK;

		sat[0][0] = State.SNAKE;
		sat[0][1] = State.SNAKE;
		sat[0][2] = State.SNAKE;

	}

	// �ı����˶��ķ���
	public void change(int turn) {
		if (!flag)
			return;

		int lastdir = dirhead;
		switch (turn) {
		case TURN_UP:
			switch (dirhead) {
			case 3:
			case 1:
				dirhead = 0;
			}
			break;
		case TURN_DOWN:
			switch (dirhead) {
			case 1:
			case 3:
				dirhead = 2;
			}
			break;
		case TURN_LEFT:
			switch (dirhead) {
			case 0:
			case 2:
				dirhead = 3;
			}
			break;
		case TURN_RIGHT:
			switch (dirhead) {
			case 0:
			case 2:
				dirhead = 1;
			}
			break;
		}
		// ��¼�任�������ʷ
		if (lastdir != dirhead)
			if (!pkey) {
				lst.addFirst(new int[] { headx, heady, dirhead });
				pkey = true;
			} else
				lst.set(0, new int[] { headx, heady, dirhead });
	}

	// �ƶ���(������ͷ�������жϣ������жϽ�������Ƿ���Ҫɾ��β��)
	public int move() {
		// �ƶ�ͷ��
		switch (dirhead) {
		case 0:
			heady--;
			break;
		case 1:
			headx++;
			break;
		case 2:
			heady++;
			break;
		case 3:
			headx--;
			break;
		}
		// �ж��Ƿ�ײ��ǽ
		if (headx < 0 || heady < 0 || headx > columns - 1 || heady > rows - 1)
			return -1;

		State sp = sat[heady][headx];
		// ����ͷ��
		sat[heady][headx] = State.SNAKE;

		int[] carr = null;
		if (!lst.isEmpty())
			carr = lst.getLast();
		int cx = -1;
		int cy = -1;
		int cd = -1;
		if (carr != null) {
			cx = carr[0];
			cy = carr[1];
			cd = carr[2];
		}

		// ��������״̬�ж��Ƿ�Ե�ƻ�������Լ�
		if (sp == State.SNAKE) {
			return -1;
		} else if (sp == State.APPLE) {
			apple.make();
			return 1;
		} else {
			// ɾ��β��
			sat[taily][tailx] = State.BLANK;

			if (cd != -1)
				if (cx == tailx && cy == taily) {
					dirtail = cd;
					lst.removeLast();
				}

			switch (dirtail) {
			case 0:
				taily--;
				break;
			case 1:
				tailx++;
				break;
			case 2:
				taily++;
				break;
			case 3:
				tailx--;
				break;
			}
		}
		return 0;
	}

	// ������
	public void reset() {
		apple.make();
		this.init();
	}

}
