package de.davidjahnbscinformatik.inputs;
import de.davidjahnbscinformatik.view.SearchWindow;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import org.jdom2.Element;

public class SearchMouseListener implements MouseListener{
	
	private Element xml;
	
	public SearchMouseListener(Element xml) throws HeadlessException {
		this.xml = xml;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		new SearchWindow(this.xml);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
