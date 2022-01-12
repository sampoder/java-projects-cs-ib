import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuBarIconTest {
    public static void main(String[] args) throws MalformedURLException {
    	try {
			java.awt.SystemTray.getSystemTray().add(new java.awt.TrayIcon(java.awt.Toolkit.getDefaultToolkit().getImage("foo.png")));
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			System.out.println("yikes");
			e.printStackTrace();
		}

    }
}