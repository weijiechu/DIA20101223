/*
 * Test.java
 *
 * Created on __DATE__, __TIME__
 */

package pku.swing;

/**
 *
 * @author  __USER__
 */
public class Test extends javax.swing.JFrame
{

	/** Creates new form Test */
	public Test()
	{
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("jLabel1");
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				Test.this.mouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				jLabel1MouseExited(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				layout.createSequentialGroup().addContainerGap(199,
						Short.MAX_VALUE).add(jLabel1).add(159, 159, 159)));
		layout.setVerticalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				layout.createSequentialGroup().add(78, 78, 78).add(jLabel1)
						.addContainerGap(207, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel1MouseExited(java.awt.event.MouseEvent evt)
	{
		// TODO add your handling code here:
	}

	private void mouseEntered(java.awt.event.MouseEvent evt)
	{
		// TODO add your handling code here:
		System.out.println("hahah");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new Test().setVisible(true);
			}
		});
	}
	
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables

}