import javax.swing.JFrame; // ���������� ��� ������ � ������ (4)
// ����� � ��� �������� (4)
public class MyStartClass {
    // ����� -����� ����� (�� ������ ��������� �������� ��������) (4)
	public static void main(String[] args) {
		//  ������ ���� � ��������� � ��������� (4)
		JFrame okno = new JFrame("����� ����� ����� ������� �������");
		// ������������� ������� ���� (5)
		okno.setBounds(10,10,1000,700);
		// ������������� ������� ������ ��� �������� ���� (4)
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����������� ������ � ������ MyPanel (4)
		okno.add(new MyPanel("����� ����� ����� ������� �������, �� ��� �� �����"));
		// ������ ���� ������� (4)
		okno.setVisible(true);
	}
}
