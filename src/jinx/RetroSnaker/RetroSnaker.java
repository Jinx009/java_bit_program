package jinx.RetroSnaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ������Ϸ��̰����
 *
 * ���ݣ� һ���ߣ�һ��һ��ƻ������ײ��ǽ���߳Ե��Լ���Ϸ����
 * 
 * BUG����������Ļ������BUG
 * 
 * @author Chain
 *
 */
public class RetroSnaker extends JFrame implements Runnable {

	private static final long serialVersionUID = 6565734678034031233L;

	// ���ƶ����ٶ�
	private static final int SPEED = 200;
	// ÿ������ı߳�
	private static final int BLOCK_SIZE = 15;
	// ��Ϸ�ռ�����
	private final int rows = 30;
	// ��Ϸ�ռ�����
	private final int columns = 30;
	// ��Ϸ��ͼ���ӣ�ÿ�����ӱ���һ�����飬�����¼�����״̬
	private State sat[][] = new State[rows][columns];
	// �����Ϸ����/��ͣ
	private boolean pause = true;
	// �����Ϸ�Ƿ����
	private boolean over = false;
	// ����ܻ���
	private int score;
	// ��
	private Snake snake;

	private static final Color COLOR_APPLE = Color.RED;
	private static final Color COLOR_SNAKE = Color.BLACK;
	private static final Color COLOR_BLANK = Color.WHITE;
	private static final Color COLOR_SCORE = Color.GRAY;

	// ���ڻ���
	private JPanel p;

	public RetroSnaker() {
		// ��ʼ�����еķ���Ϊ��
		for (int i = 0; i < sat.length; i++)
			for (int j = 0; j < sat[i].length; j++)
				sat[i][j] = State.BLANK;

		snake = Snake.getSnake(sat);

		init();
	}

	// ��ʼ������
	private void init() {
		this.setTitle("̰����");
		this.setSize(columns * BLOCK_SIZE + 10, rows * BLOCK_SIZE + 60);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		// ע�᷽����¼�������
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) // ����
					snake.change(Snake.TURN_LEFT);
				else if (keyCode == KeyEvent.VK_RIGHT) // ����
					snake.change(Snake.TURN_RIGHT);
				else if (keyCode == KeyEvent.VK_DOWN) // ����
					snake.change(Snake.TURN_DOWN);
				else if (keyCode == KeyEvent.VK_UP) // ����
					snake.change(Snake.TURN_UP);
				else if (keyCode == KeyEvent.VK_SPACE) // �ո�����Ƽ���/��ͣ
					pause = !pause;
				else if (keyCode == KeyEvent.VK_R) { // R������
					snake.reset();
					score = 0;
					over = false;
				}
			}
		});

		p = new JPanel() {

			private static final long serialVersionUID = -6588545341260894414L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);

				// ��������
				for (int i = 0; i < rows; i++)
					for (int j = 0; j < columns; j++) {
						State s = sat[i][j];
						if (s == State.SNAKE) {
							g.setColor(COLOR_SNAKE);
						} else if (s == State.APPLE) {
							g.setColor(COLOR_APPLE);
						} else {
							g.setColor(COLOR_BLANK);
						}
						g.fillRoundRect(j * BLOCK_SIZE, i * BLOCK_SIZE + 25, BLOCK_SIZE - 1, BLOCK_SIZE - 1,
								BLOCK_SIZE / 5, BLOCK_SIZE / 5);
					}

				// ��ӡ�÷�
				g.setColor(COLOR_SCORE);
				g.setFont(new Font("Times New Roman", Font.BOLD, 20));
				g.drawString("STATUS : " + (over ? "OVER" : (pause ? "WAIT" : "RUN")), 5, 20);
				g.drawString("SCORE : " + score, 300, 20);

				// ��Ϸ����
				if (over) {
					g.setColor(Color.RED);
					g.setFont(new Font("Times New Roman", Font.BOLD, 20));
					g.drawString("GAME OVER", this.getWidth() / 2 - 60, this.getHeight() / 2);
				}
			}
		};

		this.add(p);

		this.setVisible(true);
	}

	// ���̴߳���������ǣ���ʾ���߼��ֿ�,������ʾsleepʱ��Ӱ�찴��
	@Override
	public void run() {
		while (true) {
			// ��ʾ��һ��״̬
			this.repaint();
			// �ȴ�SPEEDʱ��,������ҵ����ߵ�״̬
			snake.key(true);
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			snake.key(false);
			// �ƶ��߲�����ƶ��Ľ��
			if (!pause) {
				int ans = snake.move();
				if (ans == -1) {
					over = true;
					pause = true;
				} else if (ans == 1)
					score++;
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new RetroSnaker()).start();
	}

}
