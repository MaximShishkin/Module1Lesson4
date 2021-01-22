import java.awt.Color; // ���������� ��� ������ � ������ (4)
import java.awt.Graphics; // ��������� ��� ������ � �������� �� ������ (4)
import java.awt.Image; // (5)
import java.awt.event.ActionEvent; // (5)
import java.awt.event.ActionListener; // (5)
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO; // (5)
import javax.swing.JPanel; // ���������� ��� ������ � ������� (4)
import javax.swing.Timer; // (5)
import java.io.*; // (5)
//����� � ��� �������� (4)
public class MyPanel extends JPanel {
	Image img; // �������� (5)
	Image imgfon; // �������� ����
	Image img2; // �������� ������� �������
	int x=700,y=300; // (5)
	int x_mars=700,y_mars=300;
	int napravlenie = 7; // (5)
	int napravlenie_mars = 5;
	int speed = 5; // (5)
	
	private class mykey implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO ������������� ��������� �������� ������
			int keycode = e.getKeyCode();
			System.out.println(keycode);
			
			if (keycode==68) napravlenie = 0;
			if (keycode==67) napravlenie = 1;
			if (keycode==83) napravlenie = 2;
			if (keycode==90) napravlenie = 3;
			if (keycode==65) napravlenie = 4;
			if (keycode==81) napravlenie = 5;
			if (keycode==87) napravlenie = 6;
			if (keycode==69) napravlenie = 7;
			
			if (keycode==102) napravlenie_mars = 0;
			if (keycode==99) napravlenie_mars = 1;
			if (keycode==98) napravlenie_mars = 2;
			if (keycode==97) napravlenie_mars = 3;
			if (keycode==100) napravlenie_mars = 4;
			if (keycode==103) napravlenie_mars = 5;
			if (keycode==104) napravlenie_mars = 6;
			if (keycode==105) napravlenie_mars = 7;
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}	
	}
	
	// ����� - ����������� ������ � ��������, ������� � ���� ������� (4)
	MyPanel(String stroka)
	{
		addKeyListener(new mykey());
		setFocusable(true); 
		
		// ������� �������� ����� �������� � ������� (4)
		// System.out.println(stroka);
		// (5)
		try {
			// img = ImageIO.read(getClass().getResource("\\planeta.png"));
			img = ImageIO.read(this.getClass().getResource("planeta.png"));
			img2 = ImageIO.read(this.getClass().getResource("mars.png"));
			imgfon = ImageIO.read(this.getClass().getResource("fon.jpg"));	
		} catch (IOException e) {
			// TODO ������������� ��������� ���� catch
			e.printStackTrace();
			System.out.println("�������� �� �������, ����������!");
		} // (5)
		// (5)
		Timer timer = new Timer(25, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ����������� �������� ��� �����
				//---------------------------------------------------------
				if (napravlenie==0)
				{
					x+=speed;
				}
				if (napravlenie==4)
				{
					x-=speed;
				}
				if (napravlenie==2)
				{
					y+=speed;
				}
				if (napravlenie==6)
				{
					y-=speed;
				}
				if (napravlenie==1)
				{
					x+=speed;
					y+=speed;
				}
				if (napravlenie==3)
				{
					x-=speed;
					y+=speed;
				}
				if (napravlenie==5)
				{
					x-=speed;
					y-=speed;
				}
				if (napravlenie==7)
				{
					x+=speed;
					y-=speed;
				}
				
				if (x>1000-120) // ������ �����
				{
					if (napravlenie==1) // ���� ��� ����� � �����, ����������� ���� 1
					{
						napravlenie=3; // �� ������ ����������� 3
					}
					else if (napravlenie==7) // ���� 7
					{
						napravlenie=5; // �� 5
					}
					else
					{
						napravlenie=4; // ���� ��� ������ �����, �� ������ �������� �����������
					}	
				}
				if (x<0) // ����� �����
				{
					if (napravlenie==3)
					{
						napravlenie=1;
					}
					else if (napravlenie==5)
					{
						napravlenie=7;
					}
					else
					{
						napravlenie=0;
					}	
				}
				if (y>700-140) // ������ �����
				{
					if (napravlenie==3)
					{
						napravlenie=5;
					}
					else if (napravlenie==1)
					{
						napravlenie=7;
					}
					else
					{
						napravlenie=6;
					}	
				}
				if (y<0) // ������� �����
				{
					if (napravlenie==7)
					{
						napravlenie=1;
					}
					else if (napravlenie==5)
					{
						napravlenie=3;
					}
					else
					{
						napravlenie=2;
					}	
				}
				//---------------------------------------------------------
				
				// ����������� �������� ��� �����
				//---------------------------------------------------------
				if (napravlenie_mars==0)
				{
					x_mars+=speed;
				}
				if (napravlenie_mars==4)
				{
					x_mars-=speed;
				}
				if (napravlenie_mars==2)
				{
					y_mars+=speed;
				}
				if (napravlenie_mars==6)
				{
					y_mars-=speed;
				}
				if (napravlenie_mars==1)
				{
					x_mars+=speed;
					y_mars+=speed;
				}
				if (napravlenie_mars==3)
				{
					x_mars-=speed;
					y_mars+=speed;
				}
				if (napravlenie_mars==5)
				{
					x_mars-=speed;
					y_mars-=speed;
				}
				if (napravlenie_mars==7)
				{
					x_mars+=speed;
					y_mars-=speed;
				}
				
				if (x_mars>1000-120) // ������ �����
				{
					if (napravlenie_mars==1) // ���� ��� ����� � �����, ����������� ���� 1
					{
						napravlenie_mars=3; // �� ������ ����������� 3
					}
					else if (napravlenie_mars==7) // ���� 7
					{
						napravlenie_mars=5; // �� 5
					}
					else
					{
						napravlenie_mars=4; // ���� ��� ������ �����, �� ������ �������� �����������
					}	
				}
				if (x_mars<0) // ����� �����
				{
					if (napravlenie_mars==3)
					{
						napravlenie_mars=1;
					}
					else if (napravlenie_mars==5)
					{
						napravlenie_mars=7;
					}
					else
					{
						napravlenie_mars=0;
					}	
				}
				if (y_mars>700-140) // ������ �����
				{
					if (napravlenie_mars==3)
					{
						napravlenie_mars=5;
					}
					else if (napravlenie_mars==1)
					{
						napravlenie_mars=7;
					}
					else
					{
						napravlenie_mars=6;
					}	
				}
				if (y_mars<0) // ������� �����
				{
					if (napravlenie_mars==7)
					{
						napravlenie_mars=1;
					}
					else if (napravlenie_mars==5)
					{
						napravlenie_mars=3;
					}
					else
					{
						napravlenie_mars=2;
					}	
				}
				//---------------------------------------------------------
				repaint();
			}
		});
		timer.start(); // (5)
	}
	
	// ����� - ��� ��������� ������� � ����������  (4)
	public void paint(Graphics arg0) {
		super.paint(arg0);
		arg0.drawImage(imgfon,0,0,1000,700,null); // (5)
		
		arg0.setColor(Color.yellow); // ������������� ����� ���� (4)
		arg0.fillOval(x-3,y-3,106,106); // ������ ������ ����� ��������� ������ (4)
	    arg0.drawImage(img,x,y,100,100,null); // (5)	
	    
	    arg0.setColor(Color.red); // ������������� ����� ���� (4)
		arg0.fillOval(x_mars-3,y_mars-3, 106, 106); // ������ ������ ����� ��������� ������ (4)
	    arg0.drawImage(img2,x_mars,y_mars,100,100,null); // (5)	
	}
}
